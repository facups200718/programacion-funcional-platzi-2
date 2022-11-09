package com.platzi.functional._14_optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalsClass {
    private static final boolean SURNAME_FLAG = Boolean.FALSE;

    public static void main(String[] args) {
        Optional<List<String>> optionalNameList = getNames();
        optionalNameList.ifPresent(names -> names.forEach(System.out::println));

        //El orElseGet lo que hace es fijarse si optionalSurname() vuelve empty y da una alternativa
        String apellido = optionalSurname().orElseGet(() -> "Sin apellido");
        System.out.println("apellido = " + apellido);
    }
    
    static Optional<List<String>> getNames() {
        List<String> arrayList = Arrays.asList("Pepe","Rodolfo");
        return Optional.of(arrayList);
    }

    static Optional<String> optionalSurname() {
        return SURNAME_FLAG ? Optional.of("Perez") : Optional.empty();
    }
}
