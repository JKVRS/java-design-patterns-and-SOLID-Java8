package com.java.interviewPrep.solid.s;

// Bad Example: Logging and Writing to File
public class LogManager {
    public void log(String message) {
        System.out.println(message);
        // Also writing to file — violates SRP
    }
}

// Good Example: Separation of concerns
  class ConsoleLogger {
    public void log(String message) {
        System.out.println(message);
    }
}

  class FileLogger {
    public void logToFile(String message) {
        // code to write to file
    }
}
