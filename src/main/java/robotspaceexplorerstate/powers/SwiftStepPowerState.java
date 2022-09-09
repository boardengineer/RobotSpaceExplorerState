package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.SwiftStepPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class SwiftStepPowerState extends PowerState {
    public SwiftStepPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new SwiftStepPower(amount);
    }
}
