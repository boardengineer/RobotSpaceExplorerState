package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.ScannerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class ScannerPowerState extends PowerState {
    public ScannerPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ScannerPower();
    }
}
