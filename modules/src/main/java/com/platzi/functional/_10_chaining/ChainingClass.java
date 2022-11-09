package com.platzi.functional._10_chaining;

public class ChainingClass {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        //Esto es el chaining
        stringBuilder.append("Hola")
                .append("peer")
                .append("de")
                .append("GlobalLogic");

        //Prueba de chaining hecho por nosotros
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye().sayHi();
    }

    static class Chainer {
        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Chau");
            return this;
        }
    }
}
