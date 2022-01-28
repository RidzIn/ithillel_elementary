package homework_39;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<Object> list = new ArrayList<>();

    public List<Object> getListOfClasses(){
        list.add(new Foo1());
        list.add(new Foo2());
        list.add(new Foo3());
        list.add(new Foo4());
        list.add(new Foo5());
        list.add(new Foo6());
        return list;
    }

    public List<Object> getList() {
        return list;
    }

    private <T> void showAnnotation(T t ){
        Class<? extends Object> aClass = t.getClass();
        for(Annotation annotation : aClass.getAnnotations()){
            System.out.println(annotation.toString());
        }

    }
}
