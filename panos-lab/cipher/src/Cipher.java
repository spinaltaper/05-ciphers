import java.util.Scanner;

public class Cipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String output = cipherMenu(args);
        System.out.print(output);
        System.out.println();
    }

    public static String cipherMenu(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which cipher are you interested in? \n1: Caesar Shift\n2. Keyword\n3. ROT13\n4. Plaintext");
        String selectedCipher = sc.next();
        System.out.println("Do you want to decode or encode? \n1. Decode\n2. Encode");
        String selectedDirection = sc.next().toLowerCase().toString();
        System.out.println(selectedDirection);
        boolean validSelection = false;
        if(selectedDirection.equals("1")||selectedDirection.equals("decode")){
            selectedDirection = "1";
            validSelection = true;
        }
        if(selectedDirection.equals("2")||selectedDirection.equals("encode")){
            selectedDirection = "2";
            validSelection = true;
        }
        if(!validSelection){
            return("Invalid encode/decode selection!");
        }

        System.out.println(selectedDirection);
        switch(selectedCipher) {
            case "1": System.out.println("How large of a shift?\n");
            CaesarShiftCipher chosenCipherCae = new CaesarShiftCipher(Integer.parseInt(sc.next()));
                if(selectedDirection.equals("1")){
                    return chosenCipherCae.decode(args[0]);
                }
                else{ return chosenCipherCae.encode(args[0]);}
            case "2":System.out.println("Which word do you want to use to determine the cipher?");
            KeywordCipher chosenCipherKey = new KeywordCipher(sc.next());
                if(selectedDirection.equals("1")){
                    return chosenCipherKey.decode(args[0]);
                }else{
                    if(selectedDirection.equals("2")){
                        return chosenCipherKey.decode(args[0]);
                    }else{
                        System.out.println("Invalid direction selected.");
                    }
                }
                break;
            case "3":ROT13Cipher chosenCipherROT = new ROT13Cipher();
                if(selectedDirection.equals("1")){
                    return chosenCipherROT.decode(args[0]);
                }else{
                    if(selectedDirection.equals("2")){
                        return chosenCipherROT.decode(args[0]);
                    }else{
                        System.out.println("Invalid direction selected.");
                    }
                }
                break;
            case "4":
                return args[0];
            default:
                System.out.println("Please select a cipher using a number key from 1 to 4.");
                return("Invalid cipher selection.");
        }
        return("Undefined error.");
    }

    public String encode(String payload) {
        return payload;
    }
    public String decode(String payload) {
        return payload;
    }
    protected String replaceCharacters(String payload, String source, String target) {
        char[] replacedString = new char[payload.length()];
        for(int i = 0; i < payload.length(); i++){
            for(int j = 0; j< source.length(); j++)
                if(payload.charAt(i) == source.charAt(j))
                {
                    replacedString[i] = target.charAt(j);
                }
        }
        String returnerString = new String(replacedString);
        return returnerString;
    }
    }
