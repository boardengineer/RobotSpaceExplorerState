package main.java.robotspaceexplorerstate;

import RobotSpaceExplorer.powers.*;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import main.java.robotspaceexplorerstate.powers.*;
import savestate.StateElement;
import savestate.StateFactories;
import savestate.powers.PowerState;

@SpireInitializer
public class RobotSpaceExplorerState implements PostInitializeSubscriber, EditCardsSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new RobotSpaceExplorerState());
    }

    @Override
    public void receivePostInitialize() {
        populateCurrentActionsFactory();
        populateActionsFactory();
        populatePowerFactory();

        StateElement.ElementFactories stateFactories = new StateElement.ElementFactories(() -> new RobotSpaceExplorerStateElement(), json -> new RobotSpaceExplorerStateElement(json), jsonObject -> new RobotSpaceExplorerStateElement(jsonObject));
        StateFactories.elementFactories.put(RobotSpaceExplorerStateElement.ELEMENT_KEY, stateFactories);

    }

    private void populateCurrentActionsFactory() {
    }

    private void populateActionsFactory() {
    }

    private void populatePowerFactory() {
        StateFactories.powerByIdMap
                .put(AcceleratorPower.POWER_ID, new PowerState.PowerFactories(power -> new AcceleratorPowerState(power), jsonString -> new AcceleratorPowerState(jsonString), jsonObject -> new AcceleratorPowerState(jsonObject)));
        StateFactories.powerByIdMap
                .put(AutoloaderPower.POWER_ID, new PowerState.PowerFactories(power -> new AutoloaderPowerState(power), jsonString -> new AutoloaderPowerState(jsonString), jsonObject -> new AutoloaderPowerState(jsonObject)));
        StateFactories.powerByIdMap
                .put(DischargerPower.POWER_ID, new PowerState.PowerFactories(power -> new DischargerPowerState(power)));
        StateFactories.powerByIdMap
                .put(DroneSwarmPower.POWER_ID, new PowerState.PowerFactories(power -> new DroneSwarmPowerState(power)));
        StateFactories.powerByIdMap
                .put(DualCorePower.POWER_ID, new PowerState.PowerFactories(power -> new DualCorePowerState(power), jsonString -> new DualCorePowerState(jsonString), jsonObject -> new DualCorePowerState(jsonObject)));
        StateFactories.powerByIdMap
                .put(ExhaustFanPower.POWER_ID, new PowerState.PowerFactories(power -> new ExhaustFanPowerState(power)));
        StateFactories.powerByIdMap
                .put(FreezeRayPower.POWER_ID, new PowerState.PowerFactories(power -> new FreezeRayPowerState(power)));
        StateFactories.powerByIdMap
                .put(MiniBoostersPower.POWER_ID, new PowerState.PowerFactories(power -> new MiniBoostersPowerState(power)));
        StateFactories.powerByIdMap
                .put(MultitoolPower.POWER_ID, new PowerState.PowerFactories(power -> new MultitoolPowerState(power)));
        StateFactories.powerByIdMap
                .put(PowerCollectorPower.POWER_ID, new PowerState.PowerFactories(power -> new PowerCollectorPowerState(power)));
        StateFactories.powerByIdMap
                .put(MultitoolPower.POWER_ID, new PowerState.PowerFactories(power -> new MultitoolPowerState(power)));
        StateFactories.powerByIdMap
                .put(PowerCollectorPower.POWER_ID, new PowerState.PowerFactories(power -> new PowerCollectorPowerState(power)));
        StateFactories.powerByIdMap
                .put(MultitoolPower.POWER_ID, new PowerState.PowerFactories(power -> new MultitoolPowerState(power)));
        StateFactories.powerByIdMap
                .put(PowerCollectorPower.POWER_ID, new PowerState.PowerFactories(power -> new PowerCollectorPowerState(power)));
        StateFactories.powerByIdMap
                .put(PowerGlovePower.POWER_ID, new PowerState.PowerFactories(power -> new PowerGlovePowerState(power)));
        StateFactories.powerByIdMap
                .put(SalvageNextTurnPower.POWER_ID, new PowerState.PowerFactories(power -> new SalvageNextTurnPowerState(power)));
        StateFactories.powerByIdMap
                .put(SolarFlarePower.POWER_ID, new PowerState.PowerFactories(power -> new SolarFlarePowerState(power)));
        StateFactories.powerByIdMap
                .put(StarDustEnergyDownPower.POWER_ID, new PowerState.PowerFactories(power -> new StarDustEnergyDownPowerState(power)));
        StateFactories.powerByIdMap
                .put(StarDustPower.POWER_ID, new PowerState.PowerFactories(power -> new StarDustPowerState(power)));
        StateFactories.powerByIdMap
                .put(SurgePower.POWER_ID, new PowerState.PowerFactories(power -> new SurgePowerState(power)));
        StateFactories.powerByIdMap
                .put(SwiftStepPower.POWER_ID, new PowerState.PowerFactories(power -> new SwiftStepPowerState(power)));
        StateFactories.powerByIdMap
                .put(TrailblazerPower.POWER_ID, new PowerState.PowerFactories(power -> new TrailblazerPowerState(power)));

    }

    @Override
    public void receiveEditCards() {
    }
}