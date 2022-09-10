package robotspaceexplorerstate.actions;

import RobotSpaceExplorer.actions.ReloadAction;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import savestate.actions.CurrentActionState;

public class ReloadActionState implements CurrentActionState {
    private final boolean canChoose;

    public ReloadActionState(AbstractGameAction action) {
        this.canChoose = ReflectionHacks.getPrivate(action, ReloadAction.class, "canChoose");
    }

    @Override
    public AbstractGameAction loadCurrentAction() {
        ReloadAction result = new ReloadAction(canChoose);

        // This should make the action only trigger the second half of the update
        ReflectionHacks
                .setPrivate(result, AbstractGameAction.class, "duration", 0);

        return result;
    }

    @SpirePatch(
            clz = ReloadAction.class,
            paramtypez = {},
            method = "update"
    )
    public static class HalfDoneActionPatch {
        public static void Postfix(ReloadAction _instance) {
            // Force the action to stay in the the manager until cards are selected
            if (AbstractDungeon.gridSelectScreen.selectedCards
                    .isEmpty() && AbstractDungeon.isScreenUp) {
                _instance.isDone = false;
            }
        }
    }
}
