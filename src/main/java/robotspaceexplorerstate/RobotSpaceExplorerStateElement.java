package main.java.robotspaceexplorerstate;

import RobotSpaceExplorer.patches.SalvagePatch;
import RobotSpaceExplorer.powers.AutoloaderPower;
import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import savestate.StateElement;

public class RobotSpaceExplorerStateElement implements StateElement {
    public static String ELEMENT_KEY = "ROBOT_SPACE_EXPLORER_STATE_ELEMENT";

    private final int autoLoaderIdOffset;
    private final boolean salvagedThisTurn;

    public RobotSpaceExplorerStateElement() {
        this.autoLoaderIdOffset = ReflectionHacks
                .getPrivateStatic(AutoloaderPower.class, "IdOffset");
        this.salvagedThisTurn = SalvagePatch.salvagedThisTurn.get(AbstractDungeon.actionManager);
    }

    public RobotSpaceExplorerStateElement(String jsonState) {
        JsonObject parsed = new JsonParser().parse(jsonState).getAsJsonObject();

        this.autoLoaderIdOffset = parsed.get("autoLoaderIdOffset").getAsInt();
        this.salvagedThisTurn = parsed.get("salvagedThisTurn").getAsBoolean();
    }

    public RobotSpaceExplorerStateElement(JsonObject elementJson) {
        this.autoLoaderIdOffset = elementJson.get("autoLoaderIdOffset").getAsInt();
        this.salvagedThisTurn = elementJson.get("salvagedThisTurn").getAsBoolean();
    }

    @Override
    public String encode() {
        JsonObject stateJson = new JsonObject();

        stateJson.addProperty("autoLoaderIdOffset", autoLoaderIdOffset);
        stateJson.addProperty("salvagedThisTurn", salvagedThisTurn);

        return stateJson.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject stateJson = new JsonObject();

        stateJson.addProperty("autoLoaderIdOffset", autoLoaderIdOffset);
        stateJson.addProperty("salvagedThisTurn", salvagedThisTurn);

        return stateJson;
    }

    @Override
    public void restore() {
        ReflectionHacks.setPrivateStatic(AutoloaderPower.class, "IdOffset", autoLoaderIdOffset);
        SalvagePatch.salvagedThisTurn.set(AbstractDungeon.actionManager, salvagedThisTurn);
    }
}
