package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class DiffBuilder {
    public static Map<String, Map<String, Object>> getDifference(
            Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, Map<String, Object>> fileDifference = new TreeMap<>();
        Set<String> keysSet = new TreeSet<>(firstMap.keySet());
        keysSet.addAll(secondMap.keySet());
        for (String key : keysSet) {
            Map<String, Object> tempMap = new TreeMap<>();
            if (!firstMap.containsKey(key)) {
                tempMap.put("type", "added");
                tempMap.put("oldValue", null);
                tempMap.put("newValue", secondMap.get(key));
            } else if (!secondMap.containsKey(key)) {
                tempMap.put("type", "removed");
                tempMap.put("oldValue", firstMap.get(key));
                tempMap.put("newValue", null);
            } else {
                if (isEqual(firstMap.get(key), secondMap.get(key))) {
                    tempMap.put("type", "unchanged");
                } else {
                    tempMap.put("type", "changed");
                }
                tempMap.put("oldValue", firstMap.get(key));
                tempMap.put("newValue", secondMap.get(key));
            }
            fileDifference.put(key, tempMap);
        }
        return fileDifference;
    }
    private static boolean isEqual(Object firstValue, Object secondValue) {
        if ((firstValue != null && secondValue != null) && firstValue.equals(secondValue)) {
            return true;
        } else {
            return firstValue == null && secondValue == null;
        }
    }
}
