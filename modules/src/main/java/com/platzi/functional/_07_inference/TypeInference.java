package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.function.Function;

public class TypeInference {
    public static void main(String[] args) {
        Function<Integer, String> converterFunction =
                x -> "Times 2: " + x * 2;

        List<String> students = NamesUtils.getList("Hugo", "Paco", "Luis");
        //Esto es lo que hace java por adentro, indicando cual es el tipo a parsear para el valor que enviamos
        students.forEach((String name) -> System.out.println(name));

        //Esto es lo que se suele escribir. La inferencia de tipos es automatica
        students.forEach(name -> System.out.println(name));
        students.forEach(System.out::println);
    }
}
