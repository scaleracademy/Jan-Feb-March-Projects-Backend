package com.scaler.hello;

public class Hello {
    public static void main(String[] args) {
        Greetings gr = new Greetings();
        StringBuilder greetingBuider = new StringBuilder();

        greetingBuider.append(gr.getRandomGreeting());
        greetingBuider.append(" ");
        if (args.length > 0) {
            greetingBuider.append(args[0]);
        } else {
            greetingBuider.append("Buddy");
        }
        greetingBuider.append("!");

        System.out.println(greetingBuider);
    }
}
