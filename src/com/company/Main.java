package com.company;

public class Main {

    public static void main(String[] args) {

        final int numberOfPhilosophers = 10;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++){
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++){
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];


            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }


            Thread thread = new Thread(philosophers[i], "Philosopher #" + (i + 1));

            thread.start();
        }




    }
}
