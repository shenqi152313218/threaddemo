package com.company;

//有两个储户，每次存100，共存3次
//1、明确哪些是多线程运行代码
//2、明确哪些是共享数据
//3、明确多线程代码哪些是操作共享数据的
class Bank {
    private int sum = 0;

    public synchronized void add(int num) {
        sum = sum + num;
        System.out.println(Thread.currentThread().getName() + "::" + sum);
    }
}

class Cus implements Runnable {
    private Bank bank;

    Cus(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.add(100);
        bank.add(100);
        bank.add(100);
    }
}

public class $3BankDemo {

    public static void main(String[] args) {
    }
}
