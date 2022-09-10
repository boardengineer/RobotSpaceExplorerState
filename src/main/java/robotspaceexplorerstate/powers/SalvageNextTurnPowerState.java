package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.SalvageNextTurnPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class SalvageNextTurnPowerState extends PowerState {
    public SalvageNextTurnPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new SalvageNextTurnPower(amount);
    }
}
