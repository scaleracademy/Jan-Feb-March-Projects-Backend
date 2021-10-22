package com.scaler.threads;

import java.util.ArrayList;

public class MultiThreading {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("i = " + i + " thread = " + Thread.currentThread());
                }
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            threads.add(new Thread(r));
        }

        for (int i = 0; i < 32; i++) {
            threads.get(i).start();
        }
    }
}
