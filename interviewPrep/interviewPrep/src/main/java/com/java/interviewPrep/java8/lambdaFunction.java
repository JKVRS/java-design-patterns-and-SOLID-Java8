package com.java.interviewPrep.java8;

@FunctionalInterface
interface Calulator{
    int calculate(int a, int b);
}
public class lambdaFunction {


    public static void main(String[] args) {

        Calulator add = ((a, b) -> a+b);
        /*
        This is valid because you are not directly creating an instance of the interface —
        you are creating an anonymous inner class that implements the interface on the fly.
        class SomeAnonymousClass implements Calculator {
                 public double operate(double a, double b) {
                    return a + b;
                 }
        }
        Calculator add = new SomeAnonymousClass();  // This is what Java internally does
         */
        Calulator multiplie = new Calulator() {
            @Override
            public int calculate(int a, int b) {
                return a*b;
            }
        };

        System.out.println("add :" + add.calculate(2,3));
        System.out.println("Multiplication: "+ multiplie.calculate(4,5));
    }
}
