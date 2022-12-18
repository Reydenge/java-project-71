package hexlet.code;

import hexlet.code.formats.Json;
import hexlet.code.formats.Stylish;
import hexlet.code.formats.Plain;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Map<String, Object>> filesDifference, String format) throws Exception {
        switch (format) {
            case "json" -> {
                return Json.jsonFormat(filesDifference);
            }
            case "stylish" -> {
                return Stylish.stylishFormat(filesDifference);
            }
            case "plain" -> {
                return Plain.plainFormat(filesDifference);
            }
            default -> System.out.println("Format: " + format + "is invalid");
        }
        return Stylish.stylishFormat(filesDifference);
    }
}
