package hexlet.code.fileformats;

import java.io.IOException;
import java.util.Map;

public class Stylish {
    public static String stylishFormat(Map<String, Map<String, Object>> fileDifference) throws IOException {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Map<String, Object>> mapEntry : fileDifference.entrySet()) {
            StringBuilder oldValueBuild = new StringBuilder();
            oldValueBuild.append(mapEntry.getKey()).append(": ")
                    .append(fileDifference.get(mapEntry.getKey()).get("oldValue")).append("\n");
            StringBuilder newValueBuild = new StringBuilder();
            newValueBuild.append(mapEntry.getKey()).append(": ")
                    .append(fileDifference.get(mapEntry.getKey()).get("newValue")).append("\n");
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("added")) {
                sb.append("  + ").append(newValueBuild);
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("removed")) {
                sb.append("  - ").append(oldValueBuild);
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("changed")) {
                sb.append("  - ").append(oldValueBuild);
                sb.append("  + ").append(newValueBuild);
            }
            if (fileDifference.get(mapEntry.getKey()).get("type").equals("unchanged")) {
                sb.append("    ").append(oldValueBuild);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
