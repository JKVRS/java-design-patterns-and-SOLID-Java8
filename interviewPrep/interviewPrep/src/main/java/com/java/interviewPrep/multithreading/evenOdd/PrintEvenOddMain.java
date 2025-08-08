package com.java.interviewPrep.multithreading.evenOdd;

class EvenOdd {
    int i =1; // shared resource
    int max ;

    public EvenOdd(int max) {
        this.max = max;
    }

    public synchronized void  printEven() throws InterruptedException {
        while(i<=max){
            if(i%2!=0){
                wait(); // wait for printOdd to print odd number

            }else{
                System.out.println("Even: "+i);
                notify();
                Thread.sleep(1000);
                i++;
            }

        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while(i<=max){
            if(i%2==0){
                wait(); // wait for even to print

            }else{
                System.out.println("Odd: "+i);
                notify();
                Thread.sleep(1000);
                i++;

            }

        }
    }
}

class EvenPrinter implements Runnable{
   private EvenOdd evenOdd;

   public EvenPrinter(EvenOdd e){
       this.evenOdd =e;
   }
    @Override
    public void run() {
        try{
            evenOdd.printEven();
        }catch (Exception e){

        }

    }
}

public class PrintEvenOddMain {
    public static void main(String[] args) throws InterruptedException {
        EvenOdd e = new EvenOdd(10);
        EvenPrinter ep = new EvenPrinter(e);
        Thread t1 = new Thread(ep);
        Thread t2 = new Thread(()->{
            try{
                e.printOdd();
            }catch (Exception ex){

            }
        });
        t1.start();
        t2.start();


    }

}
