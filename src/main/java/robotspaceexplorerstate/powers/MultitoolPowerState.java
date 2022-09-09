package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.MultitoolPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class MultitoolPowerState extends PowerState {
    public MultitoolPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new MultitoolPower(amount);
    }
}
