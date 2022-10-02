package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(square.apply(5));
        System.out.println(square.apply(25));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        Predicate<Integer> isEven = x -> x % 2 == 0;
        isEven.test(4);

        Predicate<Student> isApproved = student -> student.getGrade() >= 6;
        System.out.println(isApproved.test(new Student(5)));
    }

    static class Student {
        private double grade;

        public double getGrade() {
            return grade;
        }

        public Student(double grade) {
            this.grade = grade;
        }
    }
}
