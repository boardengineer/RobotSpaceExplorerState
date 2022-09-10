package robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.AcceleratorPower;
import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;

public class AcceleratorPowerState extends PowerState {
    private final int zeroCostCardsPlayedThisTurn;

    public AcceleratorPowerState(AbstractPower power) {
        super(power);

        this.zeroCostCardsPlayedThisTurn = ReflectionHacks
                .getPrivate(power, AcceleratorPower.class, "zeroCostCardsPlayedThisTurn");
    }

    public AcceleratorPowerState(String jsonString) {
        super(jsonString);

        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.zeroCostCardsPlayedThisTurn = parsed.get("zeroCostCardsPlayedThisTurn").getAsInt();
    }

    public AcceleratorPowerState(JsonObject powerJson) {
        super(powerJson);

        this.zeroCostCardsPlayedThisTurn = powerJson.get("zeroCostCardsPlayedThisTurn").getAsInt();
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        AcceleratorPower result = new AcceleratorPower(amount);

        ReflectionHacks
                .setPrivate(result, AcceleratorPower.class, "zeroCostCardsPlayedThisTurn", zeroCostCardsPlayedThisTurn);

        return result;
    }

    @Override
    public String encode() {
        JsonObject parsed = new JsonParser().parse(super.encode()).getAsJsonObject();

        parsed.addProperty("zeroCostCardsPlayedThisTurn", zeroCostCardsPlayedThisTurn);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("zeroCostCardsPlayedThisTurn", zeroCostCardsPlayedThisTurn);

        return result;
    }
}
