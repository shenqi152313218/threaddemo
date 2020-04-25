package com.company;

class $2Ticket implements Runnable {
    private int num = 100;
    public boolean flag = false;

    @Override
    public void run() {
        if(!flag) {
            while (true) {
                synchronized (this) {
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + "::" + num--);
                    }
                }
            }
        } else {
            sell();
        }
    }

    public synchronized void sell() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "::" + num--);
            }
        }
    }
}

//使用两个线程买票，一个线程通过同步代码块卖票，一个线程通过同步函数卖票
public class $2TicketDemo {

    public static void main(String[] args) {
        $2Ticket ticket = new $2Ticket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);

        t1.start();
        try {Thread.sleep(1);} catch (InterruptedException e) {}
        ticket.flag = true;
        t2.start();
    }
}
