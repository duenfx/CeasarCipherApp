import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        String command = args[0];
        String filePath = args[1];
        String key = args.length > 2 ? args[2] : null;
        new CommandHandler().handle(command, filePath, key);
    }
}