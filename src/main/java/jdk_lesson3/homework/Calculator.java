package jdk_lesson3.homework;

public class Calculator  {

    public  static <T extends Number, U extends Number> double sum(T  t, U u){

        return t.doubleValue() + u.doubleValue();
    }
    public static <T extends Number, U extends Number> double multiply(T  t, U  u){
        return t.doubleValue() * u.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T  t, U  u){
        return t.doubleValue() / u.doubleValue();
    }
    public static <T extends Number, U extends Number> double subtract(T  t, U  u){
        return t.doubleValue() - u.doubleValue();
    }

}
