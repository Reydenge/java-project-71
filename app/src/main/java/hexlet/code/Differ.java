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

    private static Map<String, Object> getData(String filepath) throws Exception {
        String fileData = Files.readString(Paths.get(filepath));
        String fileFormat = getFileFormat(filepath);
        return Parser.parse(fileData, fileFormat);
    }

    private static String getFileFormat(String filepath) throws Exception {
        if (!filepath.contains(".")) {
            throw new DataFormatException();
        }
        int indexOfLastDot = filepath.lastIndexOf(".") + 1;
        return filepath.substring(indexOfLastDot).toLowerCase();
    }
}
