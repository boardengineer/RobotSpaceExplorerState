package main.java.robotspaceexplorerstate;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

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
    }

    private void populateCurrentActionsFactory() {}

    private void populateActionsFactory() {}

    private void populatePowerFactory() {
    }

    @Override
    public void receiveEditCards() {
    }
}