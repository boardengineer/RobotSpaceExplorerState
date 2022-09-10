package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.SolarFlarePower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class SolarFlarePowerState extends PowerState {
    public SolarFlarePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new SolarFlarePower(amount);
    }
}
