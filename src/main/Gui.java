package main;

public class Gui {
    public static void main(String[] args) {
        Generator gen = new Generator(false);
        for (int i = 8; i <= 24; i++) {
            String s = gen.createPW(i);
            System.out.println(s + " | "+s.length());
        }
    }
}
