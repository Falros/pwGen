package pwGen;

import java.util.Random;
import java.util.Scanner;

public class Generator {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'123456789+-._%&";

    public static void main(String[] args) {
        Random rand = new Random();
        // Pseudo random is enough here...
        Scanner sc = new Scanner(System.in);
        System.out.println("Longueur : ");
        int l = sc.nextInt();
        String pwd = "";
        if (l < 0 || l > 32) {
            l = 16;
            System.out.println("Longueur invalide. Longueur par défaut : 16");
        }
        for (int i = 0; i < l; i++) {
            pwd += alphabet.charAt(rand.nextInt(alphabet.length()));
        }
        System.out.println(pwd);
    }
    /*
     * TODO PATTERNS rightUpperCase rightLowerCase leftUpperCase leftLowerCase
     * 
     * leftUpperNumber rightNumber rightNumber rightUpperNumber
     * 
     * rightUpperCase rightLowerCase leftUpperCase leftLowerCase
     * 
     * leftSymbol leftNumber rightNumber rightSymbol
     */

}
