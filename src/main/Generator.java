package main;

import java.util.Random;

public class Generator {
    private final String[] alphabet = { "qwertasdfgyxcvQWERTASDFGYXCV12345",
            "zuiopghjklvbnmZUIOPGHJKLVBNM67890" };
    private Random rand = new Random();
    private boolean special;

    public Generator(boolean special) {
        this.special = special;
    }

    public String createPW(int length) { // Suppose length 8-24
        String out = "";
        if (special) {
            // Format : rrll-rrll-rrll......
            // TODO : normalize length
        } else {
            // Format : lllrrrrllrrrlll.....
            int handAlternator = 1;
            while (length > 0) {
                String tempAlph = alphabet[handAlternator++ % 2];
                int sequenceLength = length <= 4 ? length : rand.nextInt(3) + 2; // 2
                                                                                 // -
                                                                                 // 4
                for (int i = 0; i < sequenceLength; i++) {
                    out += tempAlph.charAt(rand.nextInt(tempAlph.length()));
                }
                length -= sequenceLength;
            }
        }
        return out;
    }

}
