package com.company;

class Ticket implements Runnable {
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "::" + num--);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {}
                }
            }
        }
    }

    public synchronized void sell() {
        if (num > 0) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "::" + num--);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        }
    }
}

public class $1TicketDemo {

    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
