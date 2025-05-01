import java.io.IOException;
import java.nio.file.Path;

public class CommandHandler {
    public void handle(String command, String filePath, String key) throws IOException {
        String content = FileService.readFile(Path.of(filePath));
        char[] symbol = content.toCharArray();
        if (command.equalsIgnoreCase("ENCRYPT")) {
            if (key == null) {
                System.out.println("Відсутній ключ для ENCRYPT!");
            } else {
                int newKey = Integer.parseInt(key);
                String cipherText = CaesarCipher.encryptText(symbol, newKey);
                FileService.writeFile(Path.of(filePath), cipherText, command);
            }
        } else if (command.equalsIgnoreCase("DECRYPT")) {
            if (key == null) {
                System.out.println("Відсутній ключ для DECRYPT!");
            } else {
                int newKey = Integer.parseInt(key);
                String decipheredText = CaesarCipher.decryptText(symbol, newKey);
                FileService.writeFile(Path.of(filePath), decipheredText, command);
            }
        } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
            BruteForceService bruteForceService = new BruteForceService();
            BruteForceResult result = bruteForceService.bruteForce(symbol);
            if (result != null) {
                FileService.writeFile(Path.of(filePath), result.getDecryptedText(), command);
                System.out.println("Знайдений ключ: " + result.getKey());
            } else {
                System.out.println("Brute force не зміг розшифрувати текст!");
            }
        }
    }
}
