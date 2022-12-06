package hexlet.code;

import hexlet.code.fileformats.Json;
import hexlet.code.fileformats.Stylish;
import hexlet.code.fileformats.Plain;

import java.io.IOException;
import java.util.Map;

public class Formatter {
    public static String compile(Map<String, Map<String, Object>> filesDifference, String format) throws IOException {
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
