package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.PowerGlovePower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class PowerGlovePowerState extends PowerState {
    public PowerGlovePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new PowerGlovePower(amount);
    }
}
