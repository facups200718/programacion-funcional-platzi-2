package com.platzi.functional._06_reference_operator;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NamesUtils {
    public static void main(String[] args) {
        List<String> professors = getList("Nicolas", "Juan", "Zulema");
        //Como puedo imprimir estos nombres?

        //Mandando un consumer previamente declarado
        Consumer<String> printer = text -> System.out.println(text);
        professors.forEach(printer);

        //Mandando el operador de movida por parametro
        professors.forEach(p -> System.out.println(p));

        //Usando un operador por referencia
        professors.forEach(System.out::println);
    }

    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }
}
