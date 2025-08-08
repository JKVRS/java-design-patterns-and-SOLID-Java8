package com.java.interviewPrep.multithreading.criticalSectio;


class Counter{

    int count=0;
    public synchronized void increament() {
        count++;
    }
}
class Myclass implements Runnable{
    private Counter counter;

    public Myclass(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            counter.increament();
        }
    }
}
public class MultiMain {

    public static void main(String[] args) throws InterruptedException {
      //  Myclass m = new Myclass(new Counter());
        Counter c = new Counter();
        Thread t1 = new Thread( new Myclass(c));
        Thread t2 = new Thread( new Myclass(c));
        t1.start();

        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);
    }
}
