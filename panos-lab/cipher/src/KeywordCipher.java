public class KeywordCipher extends Cipher {
    char[] codeAlphabet = new char[26];
    KeywordCipher(String givenWord){
        givenWord.toCharArray();
        for(int i = 0; i < ALPHABET.length(); i++){
            boolean found = false;
            for(int j = 0; j < givenWord.length(); j++) {
                if (givenWord.charAt(j) == ALPHABET.charAt(i)) {
                    found = true;
                }
            }
            if(found == false){
                givenWord = givenWord + ALPHABET.charAt(i);
            }
        }
        this.codeAlphabet = givenWord.toCharArray();
    }

    public String encode(String payload){
        String codedAlphebet = new String(codeAlphabet);
        return replaceCharacters(payload,ALPHABET,codedAlphebet);
    }

    public String decode(String payload){
        String codedAlphebet = new String(codeAlphabet);
        return replaceCharacters(payload,codedAlphebet,ALPHABET);
    }
}
