package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.StarDustEnergyDownPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class StarDustEnergyDownPowerState extends PowerState {
    public StarDustEnergyDownPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new StarDustEnergyDownPower(amount);
    }
}
