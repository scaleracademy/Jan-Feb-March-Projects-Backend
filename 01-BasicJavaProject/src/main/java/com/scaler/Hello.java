package com.scaler;

public class Hello {
    public static void main(String[] args) {
        Greetings gr = new Greetings();
        StringBuilder greetingBuider = new StringBuilder();

        greetingBuider.append(gr.getRandomGreeting());
        greetingBuider.append(" ");
        greetingBuider.append(args[0]);
        greetingBuider.append("!");

        System.out.println(greetingBuider);
    }
}
