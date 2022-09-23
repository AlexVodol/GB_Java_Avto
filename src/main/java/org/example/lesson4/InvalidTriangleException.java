package org.example.lesson4;


public class InvalidTriangleException extends Exception {
    public InvalidTriangleException() {
        super("Треугольник не существует");
    }
}
