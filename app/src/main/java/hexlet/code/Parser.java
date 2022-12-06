package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String fileData, String fileFormat) throws IOException {
        ObjectMapper objectMapper = identifyFileFormat(fileFormat);
        return objectMapper.readValue(fileData, new TypeReference<>() { });
    }
    private static ObjectMapper identifyFileFormat(String fileFormat) {
        return "json".equals(fileFormat) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
