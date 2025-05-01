import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public static String readFile(Path path) throws IOException {
        return Files.readString(path);
    }

    public static void writeFile(Path path, String text, String mode) throws IOException {
        String fileName = path.getFileName().toString();
        int index = fileName.lastIndexOf(".");
        String name;
        String extension;
        if (index != -1) {
            name = fileName.substring(0, index);
            extension = fileName.substring(index);
        } else {
            name = fileName;
            extension = "";
        }
        String suffix = "";
        if (mode.equalsIgnoreCase("ENCRYPT")) {
            suffix = "[ENCRYPTED]";
        } else if (mode.equalsIgnoreCase("DECRYPT")) {
            suffix = "[DECRYPTED]";
        }
        String newFileName = name + suffix + extension;
        Path dir = path.getParent();
        Path newPath = dir.resolve(newFileName);
        Files.writeString(newPath, text);
    }
}
