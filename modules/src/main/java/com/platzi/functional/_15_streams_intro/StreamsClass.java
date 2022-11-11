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
        Stream<String> emphasizedCourseNames = coursesStream.map(course -> course + "!");
        //Para FILTRAR el contenido de un stream (que es muy distinto a cambiarlo), usamos filter
        //Creamos coursesStream2 porque no podemos trabajar sobre un stream mas de una vez/que ya fue consumido
        Stream<String> coursesStream2 = Stream.of("Java", "Python", "Go");
        Stream<String> javaCoursesOnly = coursesStream2.filter(c -> c.toLowerCase().contains("java"));
    }
}
