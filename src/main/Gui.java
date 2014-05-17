package main;

public class Gui {
    public static void main(String[] args) {
        Generator gen = new Generator(true);
        for (int i = 0; i < 10; i++){
            String s = gen.createPW(16);
            System.out.println(s+"  ||  "+s.length());
        }
    }
}
