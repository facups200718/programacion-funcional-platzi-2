package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.function.Function;

public class TypeInference {
    public static void main(String[] args) {
        Function<Integer, String> converterFunction =
                x -> "Times 2: " + x * 2;

        List<String> students = NamesUtils.getList("Hugo", "Paco", "Luis");
        //Ya no tenemos que hacer esto, aclarar el tipo del dato que se está enviando
        students.forEach((String name) -> System.out.println(name));

        //Sino que ahora no se aclara (ver estos 2 ejemplos), y Java se encarga de comparar el tipo del dato enviado y del dato esperado en tiempo de compilación
        students.forEach(name -> System.out.println(name));
        students.forEach(System.out::println);
    }
}
