package hexlet.code.fileformats;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static String jsonFormat(Map<String, Map<String, Object>> fileDifference) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(fileDifference);
    }
}
