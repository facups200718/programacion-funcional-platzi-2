package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class LambdaSyntax {
    public static void main(String[] args) {
        List<String> courses = NamesUtils.getList("Java SE", "Java Functional");
        courses.forEach(course -> System.out.println(course));

        //Invocamos la funcion que toma 0 argumentos
        //Java toma al "2" como valor de retorno del lambda automaticamente
        useZero(() -> 2);

        //Lo mismo pero para un tipo de funcion preexistente
        usePredicate(text -> text.isEmpty());

        //Creo que se entiende
        useBiFunction((x, y) -> x * y);

        //Mostramos un ejemplo de otra forma sintactica de representar lambdas
        useBiFunction((x, y) -> {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            return x - y;
        });

        //Cuando usamos una funcion que no recibe ningun dato y no devuelve nada
        useDoNothing(() -> {});
        useDoNothing(() -> {
            System.out.println("Hola GlobalLogic");
        });

        //NUNCA usamos tipos de datos primitivos porque las interfaces funcionales trabajan con generics (e.g. <T>)
        //Igualmente, se puede omitir la aclaracion del tipo de dato
        useBiFunction((Integer x, Integer y) -> x * y);
    }

    //Esta es una funcion cualquiera que creamos para poder poner en algun lado nuestra funcion lambda que corresponde al tipo de tipo ZeroArguments
    static void useZero(ZeroArguments zeroArguments) {

    }

    //Se hace lo mismo pero para un tipo preexistente
    static void usePredicate(Predicate<String> predicate) {

    }

    //Creo que se entiende...
    static void useBiFunction(BiFunction<Integer, Integer, Integer> biFunction) {

    }

    static void useDoNothing(DoNothing doNothing) {

    }

    //Creamos una funcion que toma 0 argumentos
    @FunctionalInterface
    interface ZeroArguments {
        int get();
    }

    @FunctionalInterface
    interface DoNothing {
        void doNothing();
    }
}
