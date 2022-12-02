package robotspaceexplorerstate.patches;

import RobotSpaceExplorer.actions.CometAction;
import RobotSpaceExplorer.powers.SolarFlarePower;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class CometPatch {
    // CometAction Update is poorly implemented
    @SpirePatch(clz = CometAction.class, method = "update")
    public static class BetterUpdatePatch {
        @SpirePrefixPatch
        public static SpireReturn betterUpdate(CometAction cometAction) {
            float duration = ReflectionHacks.getPrivate(cometAction, AbstractGameAction.class, "duration");
            int amount = cometAction.amount;

            if (duration == Settings.ACTION_DUR_FAST) {
                AbstractDungeon.actionManager
                        .addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SolarFlarePower(amount), amount));
                AbstractDungeon.actionManager
                        .addToBottom(new CometAllEnemiesAction());
            }


            ReflectionHacks.privateMethod(AbstractGameAction.class, "tickDuration")
                           .invoke(cometAction);
            return SpireReturn.Return(null);
        }
    }

    public static class CometAllEnemiesAction extends AbstractGameAction {
        @Override
        public void update() {
            AbstractPower pow = AbstractDungeon.player.getPower(SolarFlarePower.POWER_ID);
            if (pow != null) {
                this.addToBot(new DamageAllEnemiesAction(null, DamageInfo
                        .createDamageMatrix(pow.amount, true), DamageInfo.DamageType.THORNS, AttackEffect.FIRE));
            }


            this.isDone = true;
        }
    }
}
