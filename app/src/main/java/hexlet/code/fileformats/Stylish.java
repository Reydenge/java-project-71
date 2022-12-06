package hexlet.code.fileformats;

import java.io.IOException;
import java.util.Map;

public class Stylish {
    public static String stylishFormat(Map<String, Map<String, Object>> fileDifference) throws IOException {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("added")) {
                sb.append("  + ").append(mapEntry.getKey()).append(": ")
                        .append(fileDifference.get(mapEntry.getKey()).get("newValue")).append("\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("removed")) {
                sb.append("  - ").append(mapEntry.getKey()).append(": ")
                        .append(fileDifference.get(mapEntry.getKey()).get("oldValue")).append("\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("changed")) {
                sb.append("  - ").append(mapEntry.getKey()).append(": ")
                        .append(fileDifference.get(mapEntry.getKey()).get("oldValue")).append("\n");
                sb.append("  + ").append(mapEntry.getKey()).append(": ")
                        .append(fileDifference.get(mapEntry.getKey()).get("newValue")).append("\n");
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("unchanged")) {
                sb.append("    ").append(mapEntry.getKey()).append(": ")
                        .append(fileDifference.get(mapEntry.getKey()).get("oldValue")).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
