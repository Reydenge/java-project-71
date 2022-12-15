package hexlet.code.formats;

import java.util.Map;
import hexlet.code.Utils;

public class Plain {
    enum Types {
        added,
        removed,
        changed;

    }
    public static String plainFormat(Map<String, Map<String, Object>> fileDifference) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            var newValue = Utils.normalizeValueForPlain(mapEntry.getValue().get("newValue"));
            var oldValue = Utils.normalizeValueForPlain(mapEntry.getValue().get("oldValue"));
            if (fileDifference.get(mapEntry.getKey()).get("type").equals(Types.added.toString())) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was added with value: ")
                        .append(newValue).append("\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals(Types.removed.toString())) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was removed\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals(Types.changed.toString())) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was updated. From ")
                        .append(oldValue).append(" to ").append(newValue).append("\n");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }
}
