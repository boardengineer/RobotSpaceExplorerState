package main.java.robotspaceexplorerstate.cards;

import RobotSpaceExplorer.cards.Reload;
import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;

public class ReloadState extends CardState {
    private final boolean canChoose;

    public ReloadState(AbstractCard card) {
        super(card);

        this.canChoose = ReflectionHacks.getPrivate(card, Reload.class, "canChoose");
    }

    public ReloadState(String json) {
        super(json);

        JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();

        canChoose = parsed.get("canChoose").getAsBoolean();

        System.err.println("can choose : " + canChoose);
    }

    public ReloadState(JsonObject cardJson) {
        super(cardJson);

        canChoose = cardJson.get("canChoose").getAsBoolean();

        System.err.println("can choose : " + canChoose);
    }

    @Override
    public AbstractCard loadCard() {
        AbstractCard result = super.loadCard();

        ReflectionHacks.setPrivate(result, Reload.class, "canChoose", canChoose);

//        System.err.println("can choose : " + canChoose);

        return result;
    }

    @Override
    public String encode() {
        String result = super.encode();

        JsonObject parsed = new JsonParser().parse(result).getAsJsonObject();

        parsed.addProperty("canChoose", canChoose);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("canChoose", canChoose);
        System.err.println("can choose : " + canChoose);

        return result;
    }
}
