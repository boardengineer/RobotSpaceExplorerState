package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.FreezeRayPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class FreezeRayPowerState extends PowerState {
    public FreezeRayPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new FreezeRayPower(amount);
    }
}
