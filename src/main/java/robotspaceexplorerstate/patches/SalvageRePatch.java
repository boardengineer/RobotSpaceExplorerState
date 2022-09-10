package robotspaceexplorerstate.patches;

import RobotSpaceExplorer.patches.SalvagePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import ludicrousspeed.simulator.ActionSimulator;

public class SalvageRePatch {
    @SpirePatch(clz = ActionSimulator.class, method = "callEndOfTurnActions")
    public static class SetOnEOTPatch {
        @SpirePostfixPatch
        public static void resetSalave() {
            SalvagePatch.salvagedThisTurn.set(AbstractDungeon.actionManager, false);
        }
    }
}
