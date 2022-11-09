package com.platzi.functional._09_defaults;

public class StringFunctions {
    public static void main(String[] args) {
        //(1) aca es donde asignamos al metodo abstracto una funcion lambda, para darle un proposito
        StringOperations six = () -> 6;
        System.out.println(six.getAmount());
        //El funcionamiento del metodo predefinido "operate" se ve afectado por el funcionamiento del metodo getAmount() definido en la primera linea
        six.operate("Alumno");
    }

    //Toda interfaz funcional necesita y puede tener como maximo solo 1 metodo abstracto
    //Este metodo abstracto es al cual le asignamos una funcion lambda (1)
    @FunctionalInterface
    interface StringOperations {
        int getAmount();

        //Hablando mas en general sobre las interfaces de java, estos son metodos para los cuales establecemos un funcionamiento predefinido
        //Pero en este caso, el funcionamiento del metodo se ve afectado por el funcionamiento que definamos para getAmount()
        default void operate(String text) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(text);
            }
        }

        //Un metodo default podria contener una conexion a una bd y una ejecucion de alguna sentencia sql definida por nosotros
        //Y el metodo abstracto seria lo que queremos hacer mientras estemos conectados a la bd (la query sql)
        //Es decir, el funcionamiento final del metodo default se veria afectado por lo que definamos para que haga el metodo abstracto
    }
}
