package hexlet.code.formats;

import hexlet.code.Utils;
import java.io.IOException;
import java.util.Map;

public class Stylish {
    enum Types {
        added,
        removed,
        changed,
        unchanged;
    }
    public static String stylishFormat(Map<String, Map<String, Object>> fileDifference) throws IOException {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            if (getCurrentValue(mapEntry, fileDifference).equals(Types.added.toString())) {
                sb.append("  + ").append(getNewValue(mapEntry));
            }
            if (getCurrentValue(mapEntry, fileDifference).equals(Types.removed.toString())) {
                sb.append("  - ").append(getOldValue(mapEntry));
            }
            if (getCurrentValue(mapEntry, fileDifference).equals(Types.changed.toString())) {
                sb.append("  - ").append(getOldValue(mapEntry));
                sb.append("  + ").append(getNewValue(mapEntry));
            }
            if (getCurrentValue(mapEntry, fileDifference).equals(Types.unchanged.toString())) {
                sb.append("    ").append(getOldValue(mapEntry));
            }
        }
        sb.append("}");
        return sb.toString();
    }
    private static StringBuilder getOldValue(Map.Entry<String, Map<String, Object>> mapEntry) {
        StringBuilder result = new StringBuilder();
        result.append(mapEntry.getKey()).append(": ")
                .append(Utils.normalizeValueForStylish(mapEntry.getValue().get("oldValue"))).append("\n");
        return result;
    }
    private static StringBuilder getNewValue(Map.Entry<String, Map<String, Object>> mapEntry) {
        StringBuilder result = new StringBuilder();
        result.append(mapEntry.getKey()).append(": ")
                .append(Utils.normalizeValueForStylish(mapEntry.getValue().get("newValue"))).append("\n");
        return result;
    }
    private static Object getCurrentValue(Map.Entry<String, Map<String, Object>> mapEntry,
                                          Map<String, Map<String, Object>> fileDifference) {
        return fileDifference.get(mapEntry.getKey()).get("type");
    }
}
