package robotspaceexplorerstate;

import RobotSpaceExplorer.actions.AutoloaderAction;
import RobotSpaceExplorer.actions.ReloadAction;
import RobotSpaceExplorer.cards.AbstractDefaultCard;
import RobotSpaceExplorer.cards.Explosion;
import RobotSpaceExplorer.cards.Reload;
import RobotSpaceExplorer.cards.Wormhole;
import RobotSpaceExplorer.characters.RobotSpaceExplorer;
import RobotSpaceExplorer.powers.*;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import battleaimod.BattleAiMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import robotspaceexplorerstate.actions.AutoloaderActionState;
import robotspaceexplorerstate.actions.ReloadActionState;
import robotspaceexplorerstate.cards.AbstractDefaultCardState;
import robotspaceexplorerstate.cards.ExplosionState;
import robotspaceexplorerstate.cards.ReloadState;
import robotspaceexplorerstate.heuristics.PlayHeuristic;
import robotspaceexplorerstate.powers.*;
import savestate.CardState;
import savestate.StateElement;
import savestate.StateFactories;
import savestate.actions.CurrentActionState;
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
        populateCardFactories();

        StateFactories.powerPrefixes.add(AutoloaderPower.POWER_ID);

        StateElement.ElementFactories stateFactories = new StateElement.ElementFactories(() -> new RobotSpaceExplorerStateElement(), json -> new RobotSpaceExplorerStateElement(json), jsonObject -> new RobotSpaceExplorerStateElement(jsonObject));
        StateFactories.elementFactories
                .put(RobotSpaceExplorerStateElement.ELEMENT_KEY, stateFactories);

        BattleAiMod.cardPlayHeuristics.add(new PlayHeuristic());
    }

    private void populateCurrentActionsFactory() {
        StateFactories.currentActionByClassMap
                .put(AutoloaderAction.class, new CurrentActionState.CurrentActionFactories(action -> new AutoloaderActionState(action)));
        StateFactories.currentActionByClassMap
                .put(ReloadAction.class, new CurrentActionState.CurrentActionFactories(action -> new ReloadActionState(action)));
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
                .put(ScannerPower.POWER_ID, new PowerState.PowerFactories(power -> new ScannerPowerState(power)));
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

    private void populateCardFactories() {
        CardState.CardFactories reloadFactories = new CardState.CardFactories(card -> new ReloadState(card), json -> new ReloadState(json), jsonObject -> new ReloadState(jsonObject));

        StateFactories.cardFactoriesByType.put(Reload.class, reloadFactories);
        StateFactories.cardFactoriesByCardId.put(Reload.ID, reloadFactories);

        CardState.CardFactories explosionFactories = new CardState.CardFactories(card -> new ExplosionState(card), json -> new ExplosionState(json), jsonObject -> new ExplosionState(jsonObject));

        StateFactories.cardFactoriesByType.put(Explosion.class, explosionFactories);
        StateFactories.cardFactoriesByCardId.put(Explosion.ID, explosionFactories);

        CardState.CardFactories cardFactories = new CardState.CardFactories(card -> new AbstractDefaultCardState(card), json -> new AbstractDefaultCardState(json), jsonObject -> new AbstractDefaultCardState(jsonObject));

        StateFactories.cardFactoriesByType.put(AbstractDefaultCard.class, cardFactories);
        StateFactories.cardFactoriesByTypeName
                .put(AbstractDefaultCardState.TYPE_KEY, cardFactories);
    }

    @Override
    public void receiveEditCards() {
        // Action not supported, not sure we want it in AI control at all
        BaseMod.removeCard(Wormhole.ID, RobotSpaceExplorer.Enums.ROBOT_ORANGE);
    }
}