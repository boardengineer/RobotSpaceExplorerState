package robotspaceexplorerstate.cards;

import RobotSpaceExplorer.cards.AbstractDefaultCard;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;

public class AbstractDefaultCardState extends CardState {
    public static final String TYPE_KEY = "RSEAbstractDefaultCard";

    private final int defaultSecondMagicNumber;
    private final int defaultBaseSecondMagicNumber;
    private final boolean upgradedDefaultSecondMagicNumber;
    private final boolean isDefaultSecondMagicNumberModified;

    public AbstractDefaultCardState(AbstractCard card) {
        super(card);

        AbstractDefaultCard actualCard = (AbstractDefaultCard) card;

        this.defaultSecondMagicNumber = actualCard.defaultSecondMagicNumber;
        this.defaultBaseSecondMagicNumber = actualCard.defaultBaseSecondMagicNumber;
        this.upgradedDefaultSecondMagicNumber = actualCard.upgradedDefaultSecondMagicNumber;
        this.isDefaultSecondMagicNumberModified = actualCard.isDefaultSecondMagicNumberModified;
    }

    public AbstractDefaultCardState(String json) {
        super(json);

        JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();

        this.defaultSecondMagicNumber = parsed.get("defaultSecondMagicNumber").getAsInt();
        this.defaultBaseSecondMagicNumber = parsed.get("defaultBaseSecondMagicNumber").getAsInt();
        this.upgradedDefaultSecondMagicNumber = parsed.get("upgradedDefaultSecondMagicNumber")
                                                      .getAsBoolean();
        this.isDefaultSecondMagicNumberModified = parsed.get("isDefaultSecondMagicNumberModified")
                                                        .getAsBoolean();
    }

    public AbstractDefaultCardState(JsonObject cardJson) {
        super(cardJson);

        this.defaultSecondMagicNumber = cardJson.get("defaultSecondMagicNumber").getAsInt();
        this.defaultBaseSecondMagicNumber = cardJson.get("defaultBaseSecondMagicNumber").getAsInt();
        this.upgradedDefaultSecondMagicNumber = cardJson.get("upgradedDefaultSecondMagicNumber")
                                                      .getAsBoolean();
        this.isDefaultSecondMagicNumberModified = cardJson.get("isDefaultSecondMagicNumberModified")
                                                        .getAsBoolean();
    }

    @Override
    public AbstractCard loadCard() {
        AbstractDefaultCard result = (AbstractDefaultCard) super.loadCard();

        result.defaultSecondMagicNumber = this.defaultSecondMagicNumber;
        result.defaultBaseSecondMagicNumber = this.defaultBaseSecondMagicNumber;
        result.upgradedDefaultSecondMagicNumber = this.upgradedDefaultSecondMagicNumber;
        result.isDefaultSecondMagicNumberModified = this.isDefaultSecondMagicNumberModified;

        return result;
    }

    @Override
    public String encode() {
        String result = super.encode();

        JsonObject parsed = new JsonParser().parse(result).getAsJsonObject();

        parsed.addProperty("defaultSecondMagicNumber", defaultSecondMagicNumber);
        parsed.addProperty("defaultBaseSecondMagicNumber", defaultBaseSecondMagicNumber);
        parsed.addProperty("upgradedDefaultSecondMagicNumber", upgradedDefaultSecondMagicNumber);
        parsed.addProperty("isDefaultSecondMagicNumberModified", isDefaultSecondMagicNumberModified);

        parsed.addProperty("type", TYPE_KEY);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("defaultSecondMagicNumber", defaultSecondMagicNumber);
        result.addProperty("defaultBaseSecondMagicNumber", defaultBaseSecondMagicNumber);
        result.addProperty("upgradedDefaultSecondMagicNumber", upgradedDefaultSecondMagicNumber);
        result.addProperty("isDefaultSecondMagicNumberModified", isDefaultSecondMagicNumberModified);

        result.addProperty("type", TYPE_KEY);

        return result;
    }
}
