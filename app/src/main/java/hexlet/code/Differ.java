package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String firstFilePath, String secondFilePath, String format) throws IOException {
        Map<String, Object> firstMap = getFileData(firstFilePath);
        Map<String, Object> secondMap = getFileData(secondFilePath);
        var fileDifference = DiffDetector.fileDifference(firstMap, secondMap);
        return Formatter.compile(fileDifference, format);
    }
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    private static Map<String, Object> getFileData(String filepath) throws IOException {
        File file = new File(filepath);
        String fileData = Files.readString(file.toPath());
        String fileFormat = getFileFormat(file);
        return Parser.parse(fileData, fileFormat);
    }

    private static String getFileFormat(File file){
        if(!file.getPath().contains(".")) {
            return "";
        }
        int indexOfLastDot = file.getPath().indexOf(".") + 1;
        return file.getPath().substring(indexOfLastDot).toLowerCase();
    }
}