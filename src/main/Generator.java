package main;

import java.util.Random;

public class Generator {
    private final String[] alphabet = { "qwertasdfgyxcvQWERTASDFGYXCV12345",
            "zuiopghjklvbnmZUIOPGHJKLVBNM67890" };
    private Random rand = new Random();
    private boolean special;
    private boolean specific = false;

    public Generator(boolean special) {
        this.special = special;
    }

    public boolean special() {
        return this.special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public void setSpecific(boolean specific) {
        this.specific = specific;
    }

    public String createPW(int length) { // Suppose length 8-24
        if (!special) {
            return createPWnoSpecial(length);
        } else {
            String out = "";
            switch (length) {
            case 9:
                // llll-rrrr
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                return out;
            case 13:
                // rrrlll-lllrrr
                out += fillSequence(3, alphabet[1]);
                out += fillSequence(3, alphabet[0]);
                out += "-";
                out += fillSequence(3, alphabet[0]);
                out += fillSequence(3, alphabet[1]);
                return out;
            case 14:
                // llll-rrrr-llll
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += "-";
                out += fillSequence(4, alphabet[0]);
                return out;
            case 15:
                // llll-rrrlll-rrrr
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                return out;
            case 18:
                // rrrlll-rrrr-lllrrr
                out += fillSequence(3, alphabet[1]);
                out += fillSequence(3, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += "-";
                out += fillSequence(3, alphabet[0]);
                out += fillSequence(3, alphabet[1]);
                return out;
            case 19:
                // llll-rrrr-llll-rrrr
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += "-";
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                return out;
            case 20:
                // rrrlll-rrrlll-rrrlll
                out += fillSequence(3, alphabet[1]);
                out += fillSequence(3, alphabet[0]);
                out += "-";
                out += fillSequence(3, alphabet[1]);
                out += fillSequence(3, alphabet[0]);
                out += "-";
                out += fillSequence(3, alphabet[1]);
                out += fillSequence(3, alphabet[0]);
                return out;
            case 24:
                // llll-rrrr-llll-rrrr-llll
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += "-";
                out += fillSequence(4, alphabet[0]);
                out += "-";
                out += fillSequence(4, alphabet[1]);
                out += "-";
                out += fillSequence(4, alphabet[0]);
                return out;
            default:
                if (specific) {
                    return createPWnoSpecial(length);
                } else {
                    return null;
                }
            }
        }
    }

    private String createPWnoSpecial(int length) {
        String out = "";
        // Format : lllrrrrllrrrlll.....
        int handAlternator = 1;
        while (length > 0) {
            String tempAlph = alphabet[handAlternator++ % 2];
            int sequenceLength = length <= 4 ? length : rand.nextInt(3) + 2;
            out += fillSequence(sequenceLength, tempAlph);
            length -= sequenceLength;
        }
        return out;
    }

    private String fillSequence(int size, String a) {
        String r = "";
        for (int i = 0; i < size; i++) {
            r += a.charAt(rand.nextInt(a.length()));
        }
        return r;
    }

}
