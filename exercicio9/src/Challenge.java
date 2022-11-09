
/*
Ao se comparar se uma string é maior que outra, considera-se a ordem alfabética ou lexicográfica. No caso, “abcd” < “adbc” < “bacd”.

Escreva uma função que receba uma string A e retorne uma string B, sendo que B é composta pelos mesmos caracteres que A reordenados.

B deve obedecer às seguintes condições:

Ser maior que A
Ser a menor string possível que cumpra as condições acima
Caso não seja possível encontrar uma string que cumpra as condições, retorne a string “sem reposta”.
Por exemplo:

A = “ab”
Logo, o resultado será “ba”

A = “abcde”
Logo, o resultado será “abced”

A = “ba”
Nesse caso, o resultado será “sem resposta"
 */


import java.util.*;

public class Challenge {

    public static void main(String[] args) {

        String name = "abedc";
        Challenge.menorStringMaior(name);
        //System.out.println(Challenge.menorStringMaior(name));
    }

    public static String menorStringMaior(String name) {


        //Converter a String name em uma lista de Strings
        char[] charlistaString = name.toCharArray();
        List<String> listaString = new ArrayList<>();
        for (char c : charlistaString) {
            listaString.add(String.valueOf(c));
        }
        //System.out.println(listaString);
        Collections.sort(listaString); // vai ordenar em ordem alfabética


        //List<String> listaStringsPossiveis = new ArrayList<>();


        List<SortedSet<Comparable>> listaStringsPossiveis = new ArrayList<SortedSet<Comparable>>(); //aqui vai ficar a resposta

        for (String s : listaString) {
            listaStringsPossiveis.add(new TreeSet<Comparable>(Arrays.asList(s))); //insiro a combinação "1 a 1" de cada item
        }

        for (int nivel = 1; nivel < listaString.toArray().length; nivel++) {
            List<SortedSet<Comparable>> statusAntes = new ArrayList<SortedSet<Comparable>>(listaStringsPossiveis); //crio uma cópia para poder não iterar sobre o que já foi
            for (Set<Comparable> antes : statusAntes) {
                SortedSet<Comparable> novo = new TreeSet<Comparable>(antes); //para manter ordenado os objetos dentro do set
                novo.add(listaString.get(nivel));
                if (!listaStringsPossiveis.contains(novo)) { //testo para ver se não está repetido
                    listaStringsPossiveis.add(novo);
                }
            }

        }

            System.out.println("strings possiveis " + listaStringsPossiveis);

                return "";
            }
        }