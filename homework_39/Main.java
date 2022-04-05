package homework_39;

import homework_39_test.MyAnnotation;
import homework_39_test.TheClass;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.getListOfClasses();
        for (Object object : factory.getList()) {
            showAnnotation(object);
        }
    }

    private static <T> void showAnnotation(T t) {
        Class<? extends Object> aClass = t.getClass();
        if(aClass.isAnnotationPresent(Start.class)){
            Start start = aClass.getAnnotation(Start.class);

            System.out.println(t.getClass());
            System.out.println(start.priority());
            System.out.println(start.method());
            System.out.println("----------------");

        }
    }
}
