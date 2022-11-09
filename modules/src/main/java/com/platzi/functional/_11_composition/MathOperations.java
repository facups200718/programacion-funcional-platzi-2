package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations {
    public static void main(String[] args) {
        Function<Integer, Integer> timesThree = x -> x * 3;
        //Con el compose le agregamos un paso previo a una funcion lambda
        //Es decir, primero se ejecuta la lambda que mandamos y luego la funcion lambda en la variable timesThree
        Function<Integer, Integer> addOneThenTimesThree = timesThree.compose(x -> x + 1);
        System.out.println(addOneThenTimesThree.apply(5));

        //Con esto agregamos una funcion que se ejecuta posteriormente a la funcion lambda en la variable addOneThenTimesThree
        Function<Integer,Integer> andSquare = addOneThenTimesThree.andThen(x -> x * x);
        System.out.println(andSquare.apply(2));

        //Esto puede servir para agregar/verificar que haya una conexion de bd antes de realizar una consulta
    }
}
