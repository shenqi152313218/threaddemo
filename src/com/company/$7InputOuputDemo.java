package com.company;

import java.util.stream.Stream;

//生产者和消费者
public class $7InputOuputDemo { 

    public static void main(String[] args) {

        Stream.iterate(0, n -> n + 1).limit(3).forEach((n) -> System.out.println(n));
        //0, 1, 2
//        Res r = new Res();
//
//        Input in = new Input(r);
//        Output out = new Output(r);
//
//        Thread t1 = new Thread(in);
//        Thread t2 = new Thread(out);
//
//        t1.start();
//        t2.start();
    }
}

class Input implements Runnable {
    private Res r;

    Input(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.input();
    }
}

class Output implements Runnable {
    private Res r;

    Output(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.output();
    }
}

class Res {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void input() {
        int index = 0;
        while (true) {
            if (flag) {
                try {this.wait();} catch (InterruptedException e) {}
            } else {
                if (index == 0) {
                    name = "丽丽";
                    sex = "女女";
                    System.out.println(Thread.currentThread().getName() + "::" + "input::" + name + "----"+ sex);
                } else if (index == 1) {
                    name = "mike";
                    sex = "man";
                    System.out.println(Thread.currentThread().getName() + "::" + "input::" + name + "----"+ sex);
                }
                flag = false;
                index = (index + 1) % 2;
                this.notify();
            }
        }
    }

    public synchronized void output() {
        while (true) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "::::: output" + name + "===" + sex);
                flag = false;
                this.notify();
            } else {
                try {this.wait();} catch (InterruptedException e) {}
            }
        }
    }
}
