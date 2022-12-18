package hexlet.code.formats;


import java.util.Map;

public class Stylish {
    public static String stylishFormat(Map<String, Map<String, Object>> fileDifference) throws Exception {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            String valueType = (String) mapEntry.getValue().get("type");
            Object oldValue = mapEntry.getValue().get("oldValue");
            Object newValue = mapEntry.getValue().get("newValue");
            switch (valueType) {
                case "added" -> sb.append("  + ").append(getValue(mapEntry, newValue));
                case "removed" -> sb.append("  - ").append(getValue(mapEntry, oldValue));
                case "changed" -> {
                    sb.append("  - ").append(getValue(mapEntry, oldValue));
                    sb.append("  + ").append(getValue(mapEntry, newValue));
                }
                case "unchanged" -> sb.append("    ").append(getValue(mapEntry, oldValue));
                default -> {
                    return sb.toString();
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
    private static String getValue(Map.Entry<String, Map<String, Object>> mapEntry, Object requiredValue) {
        StringBuilder result = new StringBuilder();
        String key = mapEntry.getKey();
        result.append(key).append(": ").append(String.valueOf(requiredValue)).append("\n");
        return result.toString();
    }
}
