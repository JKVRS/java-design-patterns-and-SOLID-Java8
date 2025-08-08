package com.java.interviewPrep.multithreading.printNumberUsing3Thread;


class Counter{
    int number =1;  // shared resource
    int max = 20;  // sshared resoruce
    public synchronized void printNumber(int threadId) throws InterruptedException {
        while(number<=max){

                while(number%3!=threadId && number<=max){
                    wait();
                }
            if (number > max) {
                break;
            }
                System.out.println("ThreadId- "+threadId +": "+number);
            number++;
                notifyAll();
                Thread.sleep(1000);



        }
    }
}
class printNumbers implements Runnable{
    private Counter c;
    private int threadId;
    public printNumbers(Counter c,int threadId){
        this.c=c;
        this.threadId=threadId;
    }
    @Override
    public void run() {
        try {
            c.printNumber(threadId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class PrintNumber3ThreadsMain {

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(new printNumbers(c,1));
        Thread t2 = new Thread(new printNumbers(c,2));
        Thread t3 = new Thread(new printNumbers(c,0));
        t1.start();
        t2.start();
        t3.start();
    }


}
