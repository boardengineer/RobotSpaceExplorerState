package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.ExhaustFanPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class ExhaustFanPowerState extends PowerState {
    public ExhaustFanPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ExhaustFanPower(amount);
    }
}
