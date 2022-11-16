package com.platzi.functional._15_streams_intro;

import java.util.stream.IntStream;

public class TypedStream {
    public static void main(String[] args) {
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1); //un stream que va generando numeros infinitamente
        //arranca en 0 y va subiendo de a uno
        infiniteStream.limit(1000) //El maximo va a ser 1000
                .filter(x -> x % 2 == 0) //Vamos a filtrar por los que son pares
                .allMatch(x -> x % 2 == 0); //Verificamos de que los valores que nos quedan sean pares
        //El allMatch nos puede servir por ejemplo para validar que todos los registros que obtenemos de una bd tengan un campo que nunca este vacio

        IntStream infiniteStream2 = IntStream.iterate(0, x -> x + 1);
        infiniteStream2.limit(1000)
                .parallel() //Distribuye la tarea en varios hilos, esto es cuando tenemos un gran volumen de datos y NO nos importa el orden de los mismos
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }
}
