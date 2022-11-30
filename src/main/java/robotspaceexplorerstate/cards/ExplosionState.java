package robotspaceexplorerstate.cards;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;

public class ExplosionState extends CardState {
    public ExplosionState(AbstractCard card) {
        super(card);
    }

    public ExplosionState(String jsonString) {
        super(jsonString);
    }

    public ExplosionState(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public AbstractCard loadCard() {
        AbstractCard result = super.loadCard();

        if (upgraded && !result.cardsToPreview.upgraded) {
            result.cardsToPreview.upgrade();
        }

        return result;
    }
}
