package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class DiffBuilder {
    public static Map<String, Map<String, Object>> fileDifference(
            Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, Map<String, Object>> fileDifference = new TreeMap<>();
        Set<String> keysSet = new TreeSet<>(firstMap.keySet());
        keysSet.addAll(secondMap.keySet());
        for (String key : keysSet) {
            Map<String, Object> tempMap = new TreeMap<>();
            if (!firstMap.containsKey(key)) {
                tempMap.put("type", "added");
                tempMap.put("oldValue", "null");
                tempMap.put("newValue", secondMap.get(key));
            } else if (!secondMap.containsKey(key)) {
                tempMap.put("type", "removed");
                tempMap.put("oldValue", firstMap.get(key));
                tempMap.put("newValue", "null");
            } else {
                var oldValue = firstMap.get(key) == null ? "null" : firstMap.get(key);
                var newValue = secondMap.get(key) == null ? "null" : secondMap.get(key);
                if (oldValue.equals(newValue)) {
                    tempMap.put("type", "unchanged");
                    tempMap.put("oldValue", oldValue);
                    tempMap.put("newValue", newValue);
                } else {
                    tempMap.put("type", "changed");
                    tempMap.put("oldValue", oldValue);
                    tempMap.put("newValue", newValue);
                }
            }
            fileDifference.put(key, tempMap);
        }
        return fileDifference;
    }
}
