import java.util.Scanner;

public class ROT13Cipher extends Cipher {
    char[] codeAlphabet = "nopqrstuvwxyzabcdefghijklm".toCharArray();


    public String encode(String payload){
        String codedAlphebet = new String(codeAlphabet);
        return replaceCharacters(payload,ALPHABET,codeAlphabet.toString());
    }

    public String decode(String payload){
        String codedAlphebet = new String(codeAlphabet);
        return replaceCharacters(payload,codedAlphebet,ALPHABET);
    }

}
