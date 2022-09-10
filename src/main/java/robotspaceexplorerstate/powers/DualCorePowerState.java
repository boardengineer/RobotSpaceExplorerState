package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.DualCorePower;
import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class DualCorePowerState extends PowerState {
    private final int magicNumber;

    public DualCorePowerState(AbstractPower power) {
        super(power);
        this.magicNumber = ReflectionHacks.getPrivate(power, DualCorePower.class, "magicNumber");
    }

    public DualCorePowerState(String jsonString) {
        super(jsonString);

        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.magicNumber = parsed.get("magicNumber").getAsInt();
    }

    public DualCorePowerState(JsonObject powerJson) {
        super(powerJson);

        this.magicNumber = powerJson.get("magicNumber").getAsInt();
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        DualCorePower result = new DualCorePower(magicNumber);

        ReflectionHacks.setPrivate(result, DualCorePower.class, "magicNumber", magicNumber);
        result.amount = amount;

        return result;
    }

    @Override
    public String encode() {
        JsonObject parsed = new JsonParser().parse(super.encode()).getAsJsonObject();

        parsed.addProperty("magicNumber", magicNumber);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("magicNumber", magicNumber);

        return result;
    }
}
