package robotspaceexplorerstate.patches;

import RobotSpaceExplorer.actions.ModifyAutoloaderDamageAction;
import RobotSpaceExplorer.powers.AutoloaderPower;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.UUID;

public class ModifyAutoloaderDamageActionPatch {
    @SpirePatch(clz = ModifyAutoloaderDamageAction.class, method = "update")
    public static class SmarterUpdatePatch {
        @SpirePrefixPatch
        public static SpireReturn smartUpdate(ModifyAutoloaderDamageAction action) {
            for (AbstractPower p : AbstractDungeon.player.powers) {
                if (p.ID.equals(AutoloaderPower.POWER_ID)) {
                    AbstractCard c = ((AutoloaderPower) p).cardToPlay;
                    UUID uuid = ReflectionHacks
                            .getPrivate(action, ModifyAutoloaderDamageAction.class, "uuid");
                    if (c.uuid == uuid) {
                        c.baseDamage += action.amount;
                    }
                }
            }

            action.isDone = true;

            return SpireReturn.Return(null);
        }
    }
}
