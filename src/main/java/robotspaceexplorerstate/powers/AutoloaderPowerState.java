package main.java.robotspaceexplorerstate.powers;

import RobotSpaceExplorer.powers.AutoloaderPower;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.CardState;
import savestate.powers.PowerState;

public class AutoloaderPowerState extends PowerState {
    private final CardState cardToPlay;

    public AutoloaderPowerState(AbstractPower power) {
        super(power);

        this.cardToPlay = CardState.forCard(((AutoloaderPower) power).cardToPlay);
    }

    public AutoloaderPowerState(String jsonString) {
        super(jsonString);

        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.cardToPlay = CardState.forString(parsed.get("cardToPlay").getAsString());
    }

    public AutoloaderPowerState(JsonObject powerJson) {
        super(powerJson);

        this.cardToPlay = CardState.forJson(powerJson.get("cardToPlay").getAsJsonObject());
    }

    @Override
    public String encode() {
        JsonObject parsed = new JsonParser().parse(super.encode()).getAsJsonObject();

        parsed.addProperty("cardToPlay", cardToPlay.encode());

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.add("cardToPlay", cardToPlay.jsonEncode());

        return result;
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        AutoloaderPower result = new AutoloaderPower(cardToPlay.loadCard());

        result.ID = powerId;

        return result;

    }
}
