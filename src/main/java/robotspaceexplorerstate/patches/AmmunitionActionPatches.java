package robotspaceexplorerstate.patches;

import RobotSpaceExplorer.actions.AmmunitionAction;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;

public class AmmunitionActionPatches {
    @SpirePatch(clz = AmmunitionAction.class, method = "update")
    public static class BetterUpdatePatch {
        @SpirePrefixPatch
        public static SpireReturn betterUpdate(AmmunitionAction ammunitionAction) {
            int numberOfAttacks = ReflectionHacks
                    .getPrivate(ammunitionAction, AmmunitionAction.class, "numberOfAttacks");

            if (numberOfAttacks > 0) {
                ammunitionAction.addOne();
            }

            numberOfAttacks--;

            if (numberOfAttacks == 0) {
                ammunitionAction.isDone = true;
            } else {
                ReflectionHacks
                        .setPrivate(ammunitionAction, AmmunitionAction.class, "numberOfAttacks", numberOfAttacks);
            }
            return SpireReturn.Return(null);
        }
    }
}
