package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        //Estas son funciones que extienden de Function<T,T>

        //Esta espera un solo tipo de dato de entrada y devuelve el mismo tipo de dato en la salida
        UnaryOperator<String> quote = text -> "'" + text + "'";
        System.out.println(quote.apply("Buenas tardes mostro!"));

        //Lo mismo que el de arriba pero espera dos parametros del mismo tipo que la salida
        BinaryOperator<String> quote2 = (text1, text2) -> text1 + " " + text2;
        System.out.println(quote2.apply("Hola GlobalLogic,", "dame un ascenso a ssr"));

        //2 parametros de entrada que pueden tener distintos tipos y salida que tampoco tiene que tener un mismo tipo
        BiFunction<String, Integer, String> leftPad
                = (text, number) -> String.format("%" + number + "s", text);
        System.out.println(leftPad.apply("Java", 10));
    }
}
