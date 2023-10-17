package jdk_lesson3.homework;

public class Main {
    public static void main(String[] args) {
        short a = 1;
        float b = 1.5f;
        /*
        Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
        sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа
        (но необязательно разного между собой), над которыми должна быть произведена операция.
         */
        System.out.printf("Результат выполнения sum(%s, %s) - %s\n", a, b, Calculator.sum(a,b));
        System.out.printf("Результат выполнения multiply(%s, %s) - %s\n", a, b, Calculator.multiply(a,b));
        System.out.printf("Результат выполнения divide(%s, %s) - %s\n", a, b, Calculator.divide(a,b));
        System.out.printf("Результат выполнения subtract(%s, %s) - %s\n", a, b, Calculator.subtract(a,b));
        printLine(50, "☭");
        /*
        Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
        если они одинаковые, и false в противном случае.
        Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
         */
        String[] strArray1 = {"apple", "banana", "cherry"};
        String[] strArray2 = {"apple", "banana", "cherry"};
        String[] strArray3 = {"apple", "banana", "kiwi"};
        String[] strArray4 = {"apple", "banana", "cherry", "orange"};

        System.out.printf("Результат сравнения strArray1 и strArray2 - %s\n", MyArray.compareArrays(strArray1, strArray2));
        System.out.printf("Результат сравнения strArray1 и strArray3 - %s\n",MyArray.compareArrays(strArray1, strArray3));
        System.out.printf("Результат сравнения strArray1 и strArray4 - %s\n",MyArray.compareArrays(strArray1, strArray4));
        printLine(50, "☭");
        /*
        Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
        Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
        а также переопределение метода toString(), возвращающее строковое представление пары.
         */
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<String, Double> pair2 = new Pair<>("Hello", 3.14);

        System.out.println("Pair 1: " + pair1);
        System.out.println("Pair 2: " + pair2);

        Integer firstValue = pair1.getFirst();
        String secondValue = pair1.getSecond();
        System.out.println("First value of Pair 1: " + firstValue);
        System.out.println("Second value of Pair 1: " + secondValue);
    }

    public static void printLine(int quantity, String symbol){
        for (int i = 0; i < quantity; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
