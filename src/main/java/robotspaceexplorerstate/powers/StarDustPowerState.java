package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.StarDustPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class StarDustPowerState extends PowerState {
    public StarDustPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new StarDustPower(amount);
    }
}
