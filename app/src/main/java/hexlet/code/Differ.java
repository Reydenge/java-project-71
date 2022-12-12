package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.DataFormatException;

public class Differ {
    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {
        var firstData = getFileData(firstFilePath);
        var secondData = getFileData(secondFilePath);
        var fileDifference = DiffBuilder.fileDifference(firstData, secondData);
        return Formatter.format(fileDifference, format);
    }
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    private static Map<String, Object> getFileData(String filepath) throws Exception {
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
