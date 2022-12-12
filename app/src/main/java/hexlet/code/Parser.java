package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String fileData, String fileFormat) throws Exception {
        return switch (fileFormat) {
            case "json" -> new ObjectMapper().readValue(fileData, new TypeReference<>() { });
            case "yml" -> new ObjectMapper(new YAMLFactory()).readValue(fileData, new TypeReference<>() { });
            default -> throw new RuntimeException("Transmitted file format '" + fileFormat + "' is unsupported");
        };
    }
}
