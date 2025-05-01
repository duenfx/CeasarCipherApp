public class BruteForceResult {
    private final String decryptedText;
    private final int key;

    public BruteForceResult(String decryptedText, int key) {
        this.decryptedText = decryptedText;
        this.key = key;
    }
    public String getDecryptedText() {
        return decryptedText;
    }
    public  int getKey() {
        return key;
    }
}
