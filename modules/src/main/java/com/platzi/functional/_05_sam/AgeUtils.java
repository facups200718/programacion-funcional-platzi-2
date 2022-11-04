package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class AgeUtils {
    public static void main(String[] args) {
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(
                        addCeros.apply(day) + "/" + addCeros.apply(month) + "/" + addCeros.apply(year), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(parseDate.apply(day, month, year), LocalDate.now()).getYears();

        System.out.println(calculateAge.apply(11,11,1992));
    }

    //Sirve para crear funciones que reciben 3 o mas parametros de tipos diferentes
    //Permitiendonos crear nuestras propias "funciones funcionales"
    //Es una interfaz SAM la que creamos o sea, Single Abstract Method
    //TriFunction es solo un ejemplo de nombre, si quiero la puedo llamar "Pepe"
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

}
