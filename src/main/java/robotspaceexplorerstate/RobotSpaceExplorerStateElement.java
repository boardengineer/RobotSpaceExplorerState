package main.java.robotspaceexplorerstate;

import RobotSpaceExplorer.powers.AutoloaderPower;
import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import savestate.StateElement;

// TODO: add this to state mod class
public class RobotSpaceExplorerStateElement implements StateElement {
    public static String ELEMENT_KEY = "ROBOT_SPACE_EXPLORER_STATE_ELEMENT";

    public final int autoLoaderIdOffset;

    public RobotSpaceExplorerStateElement() {
        this.autoLoaderIdOffset = ReflectionHacks
                .getPrivateStatic(AutoloaderPower.class, "IdOffset");
    }

    public RobotSpaceExplorerStateElement(String jsonState) {
        JsonObject parsed = new JsonParser().parse(jsonState).getAsJsonObject();

        this.autoLoaderIdOffset = parsed.get("autoLoaderIdOffset").getAsInt();
    }

    public RobotSpaceExplorerStateElement(JsonObject elementJson) {
        this.autoLoaderIdOffset = elementJson.get("autoLoaderIdOffset").getAsInt();
    }

    @Override
    public String encode() {
        JsonObject stateJson = new JsonObject();
        stateJson.addProperty("autoLoaderIdOffset", autoLoaderIdOffset);

        return stateJson.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject stateJson = new JsonObject();

        stateJson.addProperty("autoLoaderIdOffset", autoLoaderIdOffset);

        return stateJson;
    }

    @Override
    public void restore() {
        ReflectionHacks.setPrivateStatic(AutoloaderPower.class, "IdOffset", autoLoaderIdOffset);
    }
}
