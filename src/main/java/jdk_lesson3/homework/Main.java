package jdk_lesson3.homework;

public class Main {
    public static void main(String[] args) {
        short a = 1;
        float b = 1.5f;

        System.out.println(Calculator.sum(a,b));
        System.out.println(Calculator.multiply(a,b));
        System.out.println(Calculator.divide(a,b));
        System.out.println(Calculator.subtract(a,b));
    }
}
