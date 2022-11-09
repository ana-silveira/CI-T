/*
Dado um texto qualquer e uma lista de termos de pesquisa (sequencia de caracteres),
retorne os primeiros K termos mais recorrentes na ‘string’, onde K é um parâmetro configurável.
Exemplo: String-> "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
Lista de termos: ["a", "em", "i", "el"]
K: 2
Resultado: ["i", "a"]
Explicação: Ocorrências de cada termo,"i": 11, "a": 7, "em": 2, "el": 1, com K = 2, retornamos "i" e "a" ordenados conforme a quantidade de ocorrências de cada termo.
Obs: Quando houver termos com quantidades iguais, priorizar o retorno de acordo com a ordem de ocorrência do termo na 'string'.


 Pendência: @Test-> expected:<[i, a, em]> but was:<[i, a, el]>

 */

import java.util.*;
import java.util.stream.Collectors;

class Challenge {

    public static void main(String[] args) {

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua el";
        List<String> termos = new ArrayList<>();
        termos.add("a");
        termos.add("em");
        termos.add("i");
        termos.add("el");
        Integer k = 4;

        //Challenge.calculaTopOcorrenciasDeQueries(loremIpsum, termos, k);
        System.out.println(Challenge.calculaTopOcorrenciasDeQueries(loremIpsum, termos, k));
    }

    public static List<String> calculaTopOcorrenciasDeQueries(String texto,List<String> queries,Integer k) {

        HashMap<String, Integer> quantidadesDosTermos = new HashMap<>();

        for (String termo : queries) {
            int cont = (texto.split(termo, -1).length) - 1;
            quantidadesDosTermos.put(termo, cont);
        }

        System.out.println(quantidadesDosTermos);
        System.out.println(texto.indexOf("s"));
        System.out.println(texto.indexOf("em"));
        System.out.println(texto.indexOf("i"));
        System.out.println(texto.indexOf("el"));


        return quantidadesDosTermos.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

   }
}
