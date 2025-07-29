package com.java.interviewPrep.designPatterns.singletonDP;


/*
    Design Patterns are proven, reusable solutions to common problems that occur in software design.
    They are templates or best practices that help solve design issues in object-oriented systems.
    Three type of DP is there
    1. Creational - Singleton, Factory, Builder, Prototype, Abstract Factory
    2. Behavioral - Adapter, Decorator, Composite, Proxy, Facade, Bridge
    3. Structural - Strategy, Observer, Command, State, Template Method, Iterator
 */

public class SingletonDpMain {

    /*
      The Singleton Pattern ensures that only one instance of a class is created throughout
      the application and provides a global access point to that instance.
     */

    private static volatile SingletonDpMain instance = null;

       // Private constructor prevents instantiation from other classes
    private SingletonDpMain(){

    }

    public SingletonDpMain getInstance(){
        if(instance ==null){
            synchronized (SingletonDpMain.class){
                if(instance ==null){
                    instance = new SingletonDpMain();
                }
            }
        }
        return instance;
    }

}
