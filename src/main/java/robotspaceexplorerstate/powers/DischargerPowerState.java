package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.DischargerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class DischargerPowerState extends PowerState {
    public DischargerPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new DischargerPower(amount);
    }
}
