package hexlet.code.formats;


import java.util.Map;

public class Stylish {
    public static String stylishFormat(Map<String, Map<String, Object>> fileDifference) throws Exception {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            Object oldValue = mapEntry.getValue().get("oldValue");
            Object newValue = mapEntry.getValue().get("newValue");
            switch ((String) mapEntry.getValue().get("type")) {
                case "added" -> sb.append("  + ").append(getValue(mapEntry.getKey(), newValue));
                case "removed" -> sb.append("  - ").append(getValue(mapEntry.getKey(), oldValue));
                case "changed" -> {
                    sb.append("  - ").append(getValue(mapEntry.getKey(), oldValue));
                    sb.append("  + ").append(getValue(mapEntry.getKey(), newValue));
                }
                case "unchanged" -> sb.append("    ").append(getValue(mapEntry.getKey(), oldValue));
                default -> {
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
    private static String getValue(String key, Object requiredValue) {
        StringBuilder result = new StringBuilder();
        return result.append(key).append(": ").append(String.valueOf(requiredValue)).append("\n").toString();
    }
}
