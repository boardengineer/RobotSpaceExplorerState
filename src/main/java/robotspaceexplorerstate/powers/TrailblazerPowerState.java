package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.TrailblazerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class TrailblazerPowerState extends PowerState {
    public TrailblazerPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new TrailblazerPower(amount);
    }
}
