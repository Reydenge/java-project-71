package hexlet.code;

public class Utils {
    public static Object normalizeValueForPlain(Object value) {
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
    public static Object normalizeValueForStylish(Object value) {
        if (value == null) {
            return "null";
        }
        return value;
    }
}
