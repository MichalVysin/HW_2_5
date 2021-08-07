package com.company;

public class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    private void doAction(String action) {
        System.out.println(Thread.currentThread().getName() + " " + action);
    }

    @Override
    public void run() {

        int numberOfServings = 10000;
        int alreadyEaten = 0;
        while (alreadyEaten <= numberOfServings) {


            synchronized (leftFork) {
                doAction("Picked up left fork.");

                synchronized (rightFork) {
                    doAction("Picked up right fork.");
                    doAction("Eating his " + alreadyEaten + ". serving.");
                    doAction("Put down right fork.");
                    ++alreadyEaten;
                }
                doAction("Put down left fork.");

            }
        }

        System.out.println("-".repeat(40) + "\nAll philosophers ate their servings.");

    }
}
