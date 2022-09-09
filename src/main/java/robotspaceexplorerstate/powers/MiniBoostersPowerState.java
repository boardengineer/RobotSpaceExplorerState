package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.MiniBoostersPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class MiniBoostersPowerState extends PowerState {
    public MiniBoostersPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new MiniBoostersPower(amount);
    }
}
