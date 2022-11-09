/*
Dizemos que um número natural X esconde o Y quando, ao apagar alguns algarismos de X, o número Y aparece. Por exemplo, o número 12345 esconde o número 235, uma vez que pode ser obtido ao apagar os números 1 e 4. Por outro lado, ele não esconde o número 154.

A imagem demonstra números: 1,2,3,4,5 todos estão em azul, mas o número 1 e 4 estão com um risco vermelho.
Ex: 12345 -> 235

Escreva um código que recebe dois números e que retorna um booleano dizendo se o primeiro esconde o segundo.
 */


import java.util.ArrayList;
import java.util.List;

public class Challenge {

    public static void main(String[] args) {

        Integer numero = 12345;
        Integer numeroOculto = 235;

        System.out.println(numero);
        System.out.println(numeroOculto);

        Challenge.checaNumeroEscondido(numero, numeroOculto);
        System.out.println(Challenge.checaNumeroEscondido(numero, numeroOculto));
    }

    public static boolean checaNumeroEscondido(Integer numero,Integer numeroOculto) {

        //Converter os Integer em uma lista de String (numero)
        char[] numeroCharVet = Integer.toString(numero).toCharArray();
        List<String> listaNumero = new ArrayList<>();
        for (char c : numeroCharVet) {
            listaNumero.add(String.valueOf(c));
        }
        //Converter os Integer em uma lista de String (numeroOculto)
        char[] numeroOcultoCharVet = Integer.toString(numeroOculto).toCharArray();
        List<String> listaNumeroOculto = new ArrayList<>();
        for (char c : numeroOcultoCharVet) {
            listaNumeroOculto.add(String.valueOf(c));
        }

        List<String> novoNumero = new ArrayList<>();

        boolean resposta = false ;

        for ( String digitoOculto : listaNumeroOculto){
            for ( String digito : listaNumero){
                System.out.println("digito: " + digito);
                System.out.println("digito oculto: " + digitoOculto);
                if (digito.equals(digitoOculto)) {
                    novoNumero.add(digito);
                    System.out.println("Add digito: " + digito);
                    resposta = novoNumero.toString().equals(listaNumeroOculto.toString());
                    if (resposta) break;
                }

                }
                System.out.println();
                System.out.println("listaNumero " + listaNumero);
                System.out.println("novoNumero " + novoNumero);
            }
        System.out.println();
        System.out.println("listaNumero " + listaNumero);
        System.out.println("novoNumero " + novoNumero);


        return resposta;
    }
}



