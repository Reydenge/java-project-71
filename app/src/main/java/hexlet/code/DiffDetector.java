package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class DiffDetector {
    public static Map<String, Map<String, Object>> fileDifference(
            Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, Map<String, Object>> fileDifference = new TreeMap<>();
        Set<String> keysSet = new TreeSet<>(firstMap.keySet());
        keysSet.addAll(secondMap.keySet());
        for (String key : keysSet) {
            Map<String, Object> tempMap = new TreeMap<>();
            String oldValue = firstMap.get(key) == null ? "null" : firstMap.get(key).toString();
            String newValue = secondMap.get(key) == null ? "null" : secondMap.get(key).toString();
            if (!firstMap.containsKey(key)) {
                tempMap.put("type", "added");
                tempMap.put("oldValue", "null");
                tempMap.put("newValue", secondMap.get(key));
            } else if (!secondMap.containsKey(key)) {
                tempMap.put("type", "removed");
                tempMap.put("oldValue", firstMap.get(key));
                tempMap.put("newValue", "null");
            } else {
                if (oldValue.equals(newValue)) {
                    tempMap.put("type", "unchanged");
                    tempMap.put("oldValue", firstMap.get(key));
                    tempMap.put("newValue", secondMap.get(key));
                } else {
                    tempMap.put("type", "changed");
                    tempMap.put("oldValue", firstMap.get(key));
                    tempMap.put("newValue", secondMap.get(key));
                }
            }
            fileDifference.put(key, tempMap);
        }
        return fileDifference;
    }
}
