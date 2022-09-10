package robotspaceexplorerstate.actions;

import RobotSpaceExplorer.actions.AutoloaderAction;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import savestate.CardState;
import savestate.PlayerState;
import savestate.actions.CurrentActionState;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoloaderActionState implements CurrentActionState {
    private final CardState[] nonAttacks;

    public AutoloaderActionState(AbstractGameAction action) {
        ArrayList<AbstractCard> nonAttacks = ReflectionHacks
                .getPrivate(action, AutoloaderAction.class, "nonAttacks");
        this.nonAttacks = PlayerState.toCardStateArray(nonAttacks);
    }

    @Override
    public AbstractGameAction loadCurrentAction() {
        AutoloaderAction result = new AutoloaderAction("Irrelevant text");

        ArrayList<AbstractCard> resultNonAttacks = ReflectionHacks
                .getPrivate(result, AutoloaderAction.class, "nonAttacks");

        resultNonAttacks.clear();
        Arrays.stream(nonAttacks).map(CardState::loadCard).forEach(resultNonAttacks::add);

        // This should make the action only trigger the second half of the update
        ReflectionHacks
                .setPrivate(result, AbstractGameAction.class, "duration", 0);

        return result;
    }

    @SpirePatch(
            clz = AutoloaderAction.class,
            paramtypez = {},
            method = "update"
    )
    public static class NoDoubleDualWieldPatch {
        public static void Postfix(AutoloaderAction _instance) {
            // Force the action to stay in the the manager until cards are selected
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved && AbstractDungeon.isScreenUp) {
                _instance.isDone = false;
            }
        }
    }
}
