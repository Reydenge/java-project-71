package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;
public class DifferTest {
    @Test
    public void testDifferenceGeneration() throws Exception {
        String ymlFirstFilePath = "./src/test/resources/testfile1.yml";
        String ymlSecondFilePath = "./src/test/resources/testfile2.yml";
        var actualFileDifference = Differ.generate(ymlFirstFilePath, ymlSecondFilePath);
        String ymlExpectedFilePath = "./src/test/resources/expected_stylish.txt";
        var expectedFileDifference = Files.readString(Path.of(ymlExpectedFilePath));
        assertThat(expectedFileDifference).isEqualTo(actualFileDifference);
    }
    @Test
    public void testDifferenceGenerationStylishFormat() throws Exception {
        String jsonFirstFilePath = "./src/test/resources/testfile1.json";
        String jsonSecondFilePath = "./src/test/resources/testfile2.json";
        var actualFileDifference = Differ.generate(jsonFirstFilePath, jsonSecondFilePath, "stylish");
        String jsonExpectedFilePath = "./src/test/resources/expected_json.txt";
        var expectedFileDifference = Files.readString(Path.of(jsonExpectedFilePath));
        assertThat(expectedFileDifference).isEqualTo(actualFileDifference);
    }
    @Test
    public void testDifferenceGenerationPlainFormat() throws Exception {
        String ymlFirstFilePath = "./src/test/resources/testfile1.yml";
        String ymlSecondFilePath = "./src/test/resources/testfile2.yml";
        var actualFileDifference = Differ.generate(ymlFirstFilePath, ymlSecondFilePath, "plain");
        String ymlExpectedFilePath = "./src/test/resources/expected_plain.txt";
        var expectedFileDifference = Files.readString(Path.of(ymlExpectedFilePath));
        assertThat(expectedFileDifference).isEqualTo(actualFileDifference);
    }
    @Test
    public void testDifferenceGenerationJsonFormat() throws Exception {
        String jsonFirstFilePath = "./src/test/resources/testfile1.json";
        String jsonSecondFilePath = "./src/test/resources/testfile2.json";
        var actualFileDifference = Differ.generate(jsonFirstFilePath, jsonSecondFilePath, "json");
        String jsonExpectedFilePath = "./src/test/resources/expected_output.txt";
        var expectedFileDifference = Files.readString(Path.of(jsonExpectedFilePath));
        assertThat(expectedFileDifference).isEqualTo(actualFileDifference);
    }
}