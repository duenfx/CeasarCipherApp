public class BruteForceService {

    private boolean isReadable(String text) {
        int matchCount = 0;
        text = text.toLowerCase();
        String[] commonWords = {
                " the ", " and ", " is ", " of ", " to ", " in ", " that", " it ", " was ", " on "
        };
        for (String word : commonWords) {
            if (text.contains(word)) {
                matchCount++;
            }
        }
        return matchCount >= 3;
    }
    public BruteForceResult bruteForce(char[] encryptSymbol) {
        char[] alphabet = CaesarCipher.getAlphabet();
        for (int key = 1; key < alphabet.length; key++) {
            String result = CaesarCipher.decryptText(encryptSymbol, key);
            if (isReadable(result)) {
                return new BruteForceResult(result, key);
            }
        }
        return null;
    }
}
