package hexlet.code.fileformats;

import java.util.Map;

public class Plain {
    public static String plainFormat(Map<String, Map<String, Object>> fileDifference) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("added")) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was added with value: ")
                        .append(returnComplexValue(mapEntry.getValue().get("newValue"))).append("\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("removed")) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was removed\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("changed")) {
                sb.append("Property '").append(mapEntry.getKey()).append("' was updated. From ")
                        .append(returnComplexValue(mapEntry.getValue().get("oldValue"))).append(" to ")
                        .append(returnComplexValue(mapEntry.getValue().get("newValue"))).append("\n");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }

    private static Object returnComplexValue(Object value) {
        if (value == null || value instanceof Integer || value instanceof Boolean) {
            return value;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return "[complex value]";
        }
    }
}
