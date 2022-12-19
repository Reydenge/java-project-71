package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.DataFormatException;

public class Differ {
    public static String generate(String firstPath, String secondPath, String format) throws Exception {
        var firstData = getData(firstPath);
        var secondData = getData(secondPath);
        var difference = DiffBuilder.getDifference(firstData, secondData);
        return Formatter.format(difference, format);
    }
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    private static Map<String, Object> getData(String path) throws Exception {
        String content = Files.readString(Paths.get(path));
        String extension = getExtension(path);
        return Parser.parse(content, extension);
    }

    private static String getExtension(String path) throws Exception {
        if (!path.contains(".")) {
            throw new DataFormatException();
        }
        int indexOfLastDot = path.lastIndexOf(".") + 1;
        return path.substring(indexOfLastDot).toLowerCase();
    }
}
