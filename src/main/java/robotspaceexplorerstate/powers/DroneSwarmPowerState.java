package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.DroneSwarmPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

// TODO: add me
public class DroneSwarmPowerState extends PowerState {
    public DroneSwarmPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new DroneSwarmPower(amount);
    }
}
