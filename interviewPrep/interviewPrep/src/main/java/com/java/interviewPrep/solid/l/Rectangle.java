package com.java.interviewPrep.solid.l;

// Violates LSP
class Rectangle {
    int width, height;

    void setWidth(int width) { this.width = width; }
    void setHeight(int height) { this.height = height; }

    int area() { return width * height; }
}

class Square extends Rectangle {
    void setWidth(int width) {

        this.width = this.height = width;
    }

    void setHeight(int height) {
        this.width = this.height = height;
    }
}

// Adheres to LSP: Use composition or better abstraction
interface Shape {
    int area();
}

class RectangleShape implements Shape {
    private int width, height;
    RectangleShape(int w, int h) { this.width = w; this.height = h; }
    public int area() { return width * height; }
}

class SquareShape implements Shape {
    private int side;
    SquareShape(int s) { this.side = s; }
    public int area() { return side * side; }
}
