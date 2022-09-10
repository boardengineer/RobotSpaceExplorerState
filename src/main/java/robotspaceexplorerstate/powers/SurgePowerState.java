package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.SurgePower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class SurgePowerState extends PowerState {
    public SurgePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new SurgePower(amount);
    }
}
