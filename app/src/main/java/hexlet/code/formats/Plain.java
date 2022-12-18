package hexlet.code.formats;

import java.util.Map;

public class Plain {
    public static String plainFormat(Map<String, Map<String, Object>> fileDifference) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            String valueType = (String) fileDifference.get(mapEntry.getKey()).get("type");
            var newValue = normalize(mapEntry.getValue().get("newValue"));
            var oldValue = normalize(mapEntry.getValue().get("oldValue"));
            switch (valueType) {
                case "added" -> sb.append("Property '").append(mapEntry.getKey()).append("' was added with value: ")
                        .append(newValue).append("\n");
                case "removed" -> sb.append("Property '").append(mapEntry.getKey()).append("' was removed\n");
                case "changed" -> sb.append("Property '").append(mapEntry.getKey()).append("' was updated. From ")
                        .append(oldValue).append(" to ").append(newValue).append("\n");
                default -> throw new RuntimeException();
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }
    public static Object normalize(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Integer || value instanceof Boolean) {
            return value;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return "[complex value]";
        }
    }
}
