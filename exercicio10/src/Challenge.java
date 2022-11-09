/*
Sua equipe está trabalhando em um app de streaming de músicas e uma das funcionalidades é criar um embaralhador de músicas.
Uma pesquisa feita pela equipe de UX (experiência do usuário) mostrou que essa é uma das funcionalidades mais importantes
para os usuários e por isso foi priorizada a criação de um experimento para testar a melhor solução.

A ideia é criar vários embaralhadores diferentes e realizar um teste com partes dos usuários (chamado de teste A/B),
onde cada grupo de usuários selecionado recebe uma versão e através de pesquisas e métricas de utilização saberemos
qual terá a maior aceitação.

Sua tarefa será desenvolver um desses embaralhadores.
Você deve criar uma função que receberá uma lista de pesos que representa as músicas mais ouvidas pelo usuário.
Sua função deve retornar uma lista organizada intercalando as músicas mais ouvidas com as músicas menos ouvidas.
Por exemplo:

Na situação onde a lista de pesos é: [2, 10, 5, 3] sua função deverá retornar [10, 2, 5, 3]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Challenge {

    public static void main(String[] args) {
        //List<Integer> musicasTocadas = Arrays.asList(2,10,5,3);

        Challenge.shuffleMusicas(Arrays.asList(2,10,5,3));
        System.out.println(Challenge.shuffleMusicas(Arrays.asList(2,10,5,3)));

    }

    public static List<Integer> shuffleMusicas(List<Integer> musicasTocadas) {
        List<Integer> maisOuvidas =  musicasTocadas.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> menosOuvidas = musicasTocadas.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> listaIntercalada = new ArrayList<>();
        int cont = 0;
        for (int i = 0; i < musicasTocadas.toArray().length; i++) {
            if (i % 2 == 0) listaIntercalada.add(maisOuvidas.get(cont));
            else {
                listaIntercalada.add(menosOuvidas.get(cont));
                cont++;
            }
        }
        return listaIntercalada;
    }
}