package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command (name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff = 1.0",
        description = "Compares two configuration files and shows a difference")

public final class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to the first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to the second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    @Override
    public Integer call() throws Exception {
        try {
            String difference = Differ.generate(filepath1, filepath2, format);
            System.out.println(difference);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        var exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
