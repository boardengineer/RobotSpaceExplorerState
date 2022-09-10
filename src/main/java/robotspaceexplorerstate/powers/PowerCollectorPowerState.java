package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.PowerCollectorPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class PowerCollectorPowerState extends PowerState {
    public PowerCollectorPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new PowerCollectorPower(amount);
    }
}
