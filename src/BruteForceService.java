public class BruteForceService {
    private boolean isReadable(String text) {
        return (text.contains(" the ") || text.contains(" and ") || text.contains(" is ") || text.contains(" of ") || text.contains(" "));
    }
    public String bruteForce(char[] decryptSymbol) {
        char[] alphabet = CaesarCipher.getAlphabet();
        for (int key = 1; key < alphabet.length; key++) {
            String result = CaesarCipher.decryptText(decryptSymbol, key);
            if (isReadable(result)) {
                return result;
            }
        }
        return null;
    }
}
