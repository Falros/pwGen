package main;

public class Gui {
    public static void main(String[] args) {
        if (args.length == 0) {
            Generator gen = new Generator(false);
            System.out.println("Passwords with no special characters :\n");
            for (int i = 8; i <= 24; i++) {
                String s = gen.createPW(i);
                if (s != null) {
                    if (s.length() < 10) {
                        System.out.print(" ");
                    }
                    System.out.println(s.length() + "  |  " + s);
                }
            }
            System.out.println("\n\nPasswords with special characters :\n");
            gen.setSpecial(true);
            for (int i = 8; i <= 24; i++) {
                String s = gen.createPW(i);
                if (s != null) {
                    if (s.length() < 10) {
                        System.out.print(" ");
                    }
                    System.out.println(s.length() + "  |  " + s);
                }
            }
        } else {
            if (args[0].equals("nofuss")) {
                Generator gen = new Generator(true);
                System.out.println(gen.createPW(19));
                gen.setSpecial(false);
                System.out.println(gen.createPW(12));
            } else {
                Generator gen = new Generator(Boolean.parseBoolean(args[0]));
                gen.setSpecific(true);
                System.out.println(gen.createPW(Integer.parseInt(args[1])));
            }
        }
    }
}
