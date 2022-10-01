package robotspaceexplorerstate.patches;

import RobotSpaceExplorer.patches.MonsterDamagePatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import savestate.monsters.MonsterState;

public class MonsterMultiplierPatch {
    @SpirePatch(clz = MonsterState.class, method = SpirePatch.CLASS)
    public static class MonsterMultiplierStateField {
        public static SpireField<Integer> monsterMultiplier = new SpireField<>(() -> 1);
    }

    @SpirePatch(clz = MonsterState.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {AbstractMonster.class})
    public static class MainConstructorFoilPatch {
        @SpirePostfixPatch
        public static void addFoilParam(MonsterState monsterState, AbstractMonster monsterParam) {
            MonsterMultiplierStateField.monsterMultiplier
                    .set(monsterState, MonsterDamagePatch.monsterMultiplier.get(monsterParam));
        }
    }

    @SpirePatch(clz = MonsterState.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {JsonObject.class})
    public static class JsonObjectConstructorFoilPatch {
        @SpirePostfixPatch
        public static void addFoilParam(MonsterState monsterState, JsonObject monsterJson) {
            MonsterMultiplierStateField.monsterMultiplier
                    .set(monsterState, monsterJson.get("monster_multiplier").getAsInt());
        }
    }

    @SpirePatch(clz = MonsterState.class, method = "populateSharedFields")
    public static class LoadCardFoilPatch {
        private static final boolean disable = true;

        @SpirePrefixPatch
        public static void maybeDoNothing(MonsterState monsterState, AbstractMonster result) {
            MonsterDamagePatch.monsterMultiplier
                    .set(result, MonsterMultiplierStateField.monsterMultiplier.get(monsterState));
        }
    }

    @SpirePatch(clz = MonsterState.class, method = "jsonEncode")
    public static class EncodeFoilPatch {
        private static boolean disable = true;

        @SpirePrefixPatch
        public static SpireReturn maybeDoNothing(MonsterState monsterState) {
            if (disable) {
                disable = false;
                JsonObject result = monsterState.jsonEncode();
                result.addProperty("monster_multiplier", MonsterMultiplierStateField.monsterMultiplier
                        .get(monsterState));
                disable = true;
                return SpireReturn.Return(result);
            }
            return SpireReturn.Continue();
        }
    }
}
