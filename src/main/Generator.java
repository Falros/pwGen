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

    public String createPW(int length) {// Length in [6-24]
        String out = "";
        int handAlternator = 1;
        /*
         * length = 4*length/4 + length/4 -1
         */
        while (length > 0) {
            String handSelected = alphabet[(handAlternator++) % 2];
            for (int i = 0; i < 4; i++) {
                out += handSelected.charAt(rand.nextInt(handSelected.length()));
            }
            length -= 4;
            if (special && length > 0) {
                out += "-";
                length--;
            }

        }
        return out;
    }

}
