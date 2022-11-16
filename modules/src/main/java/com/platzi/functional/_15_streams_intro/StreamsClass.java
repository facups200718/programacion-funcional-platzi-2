package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NamesUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsClass {
    public static void main(String[] args) {
        List<String> courseList = NamesUtils.getList("Java", "Python", "Go");
        for (String course : courseList) {
            String newCourseName = course.toLowerCase().replace("!", "!!");
            System.out.println("course = " + newCourseName);
        }

        //-Un stream NO es una estructura de datos, sino un modelo/envoltorio/flujo de datos
        //-Nos permite hacer procesos ETL (extract transform and load) sobre collections,
        //Es decir, facilita la manipulacion de colecciones
        //-Los streams NO sirven para mutar/cambiar valores de datos
        //-El stream es una alternativa "con esteroides" a los iteradores
        Stream<String> coursesStream = Stream.of("Java", "Python", "Go");

        //El map me convierte a mi stream en otro stream. Lo tenemos que usar si queremos cambiar el contenido del stream, ya que los streams son inmutables
        Stream<Integer> courseNameLengthStream = coursesStream.map(course -> course.length());

        //Averiguamos cual es el nombre mas largo. Se usa un optional porque puede no haber uno mas largo.
        //El lamba que se pasa por parametros es un comparador (si y - x es positivo, entonces y va antes de x)
        Optional<Integer> longestCourseName = courseNameLengthStream.max((x, y) -> y - x);
        //Stream<String> emphasizedCourseNames = coursesStream.map(course -> course + "!");

        //Para FILTRAR el contenido de un stream (que es muy distinto a cambiarlo), usamos filter
        //Creamos coursesStream2 porque no podemos trabajar sobre un stream mas de una vez/que ya fue consumido
        Stream<String> coursesStream2 = Stream.of("Java", "Python", "Go");
        Stream<String> javaCoursesOnly = coursesStream2.filter(c -> c.toLowerCase().contains("java"));

        //Para poder consumir un stream en varias ocasiones usamos chaining
        Stream<String> coursesStream3 = Stream.of("Java", "Python", "Go");
        coursesStream3.map(course -> course + "!!")
                .filter(course -> course.toLowerCase().contains("java"))
                .forEach(System.out::println);

        //La duda que nos surge es... y forEach devuelve un dato? NO.
        //Los streams tienen operaciones intermedias y TERMINALES (estas te devuelven un tipo distinto a un stream o no te devuelven nada)
        //Una ventaja de los streams frente a las listas es que muchas de sus operaciones devuelven optionals, haciendo que un codigo se ejecute solo si los datos estan presentes

        Stream<String> coursesStream4 = Stream.of("Java", "Python", "Go");
        addOperator(coursesStream4 .map(course -> course + "!!")
                .filter(course -> course.toLowerCase().contains("java"))
                ).forEach(System.out::println); //El for each lo ponemos despues de agregar el operador peek para loggear, recordemos que es un operador TERMINAL
    }

    //Este tipo de funciones static se utilizan para agregar operadores/funciones a un stream ya existente
    //Esto por ejemplo lo podemos usar para manipular de manera mas segura datos que obtenemos de una base de datos
    //Seria mas segura la manipulacion porque no nos tenemos que preocupar por la ausencia o presencia de datos ya que muchos de los operadores usan optionals, como dije arriba
    static <T> Stream<T> addOperator(Stream<T> stream) {
        //Peek lo que hace es permitirnos boludear con el contenido de un stream (podemos logguearlo en la consola, o cualquiera cosa que no retorne un valor),
        //y poder continuar operando sobre el, ya que peek retorna al stream intacto.
        //Esto puede servir por si queremos debuggear y ver el valor de algo en el medio de la ejecucion de los operadores
        return stream.peek(data -> System.out.println("data = " + data));
    }
}
