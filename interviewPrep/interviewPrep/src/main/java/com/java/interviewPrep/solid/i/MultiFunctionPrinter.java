package com.java.interviewPrep.solid.i;

// Violates ISP
interface MultiFunctionPrinter {
    void print();
    void scan();
    void fax();
}

class BasicPrinter implements MultiFunctionPrinter {
    public void print() {
        System.out.println("Printing...");
    }
    public void scan() {
        throw new UnsupportedOperationException("Not supported");
    }
    public void fax() {
        throw new UnsupportedOperationException("Not supported");
    }
}

// Better: Split interfaces
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }
}
