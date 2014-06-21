package main;

public class Gui {
    public static void main(String[] args) {
        if (args.length == 0) {
            Generator gen = new Generator(false);
            System.out.println("\n Passwords with no special characters :\n");
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
            System.out.println("\n");
        } else {
            if (args[0].equals("nofuss")) {
                Generator gen = new Generator(true);
                System.out.println("\n");
                System.out.println(gen.createPW(19));
                gen.setSpecial(false);
                System.out.println(gen.createPW(12));
                System.out.println("\n");
            } else if (args[0].equals("card")) {
                Generator gen = new Generator(true);
                System.out.println("\n");
                for (int i = 0; i < 5; i++) {
                    System.out.println(gen.createPW(19));
                }
                System.out.println("\n");
            } else {
                System.out
                        .println("Illegal arguments. Valid arguments are nofuss and card.");
            }
        }
    }
}
