import java.util.Scanner;

public class CaesarShiftCipher extends Cipher {

    String codeAlphabet;

    public CaesarShiftCipher(int shiftDistance) {
        char[] tempAlpha = ALPHABET.toUpperCase().toCharArray();
        char[] cipher = new char[26];
        for(int i = 0; i < 26; i++){
            cipher[i] = (char)((tempAlpha[i]-65+shiftDistance)%26+65);
        }
        this.codeAlphabet = new String(cipher).toLowerCase();
    }

    public String encode(String payload){
        return replaceCharacters(payload,ALPHABET,this.codeAlphabet);
    }

    public String decode(String payload){
        return replaceCharacters(payload,this.codeAlphabet,ALPHABET);
    }
}
