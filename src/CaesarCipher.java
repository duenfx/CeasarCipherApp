public class CaesarCipher {
    private static final char[] alphabet = new char[]
            {
                    'A', 'B', 'C', 'D', 'E', 'F', 'G',
                    'H', 'I', 'J', 'K', 'L', 'M', 'N',
                    'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                    'V', 'W', 'X', 'Y', 'Z',
                    'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u',
                    'v', 'w', 'x', 'y', 'z',
                    '.', ',', ':', '!', '?', '«', '»',
                    '"', ' '
            };
    public static String encryptText(char[] symbol, int key) {
        String cipherText;
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (symbol[i] == alphabet[j]) {
                    symbol[i] = alphabet[(j + key) % alphabet.length];
                    break;
                }
            }
        }
        cipherText = new String(symbol);
        return cipherText;
    }
    public static String decryptText(char[] symbol, int key) {
        String decipheredText;
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (symbol[i] == alphabet[j]) {
                    symbol[i] = alphabet[(j - key) % alphabet.length];
                    break;
                }
            }
        }
        decipheredText = new String(symbol);
        return decipheredText;
    }
}
