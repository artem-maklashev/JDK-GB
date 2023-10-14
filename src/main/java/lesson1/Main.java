package lesson1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new ChatWindow();
        } catch (IOException e) {
            System.out.println("I/O error");
            throw new RuntimeException(e);
        }
    }
}
