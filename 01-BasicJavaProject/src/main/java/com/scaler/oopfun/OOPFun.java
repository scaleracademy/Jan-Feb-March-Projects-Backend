package com.scaler.oopfun;

public class OOPFun {

    public static void main(String[] args) {
        Fruit f = new Mango();
        Mango m = (Mango) f;
        System.out.printf(String.valueOf(m.b));
    }
}
