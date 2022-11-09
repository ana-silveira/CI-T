/*
Você está trabalhando para uma empresa que fornece materiais escolares e precisa da sua ajuda para entrar no mundo digital.
Como primeira atividade, você identificou que não existe uma funcionalidade que é muito importante para a empresa ter
mais controle sobre os valores dos produtos vendidos.
Esta funcionalidade consiste em descobrir o maior e o menor valor dos produtos vendidos num período de tempo, para cada vendedor.

Os valores das vendas que devem ser consideradas podem variar entre 20 e 500 reais e estão agrupados por vendedores.
Além disso, deve-se ignorar as devoluções, que estão indicadas com o valor 0.

A sua função/método deverá
— receber uma lista vendas agrupadas por vendedores, (e.g. [[200, 100], [300]]) e
— retornar um array onde a primeira posição contém o menor valor e a segunda posição o maior valor (e.g. [100, 300]).

Mas preste atenção! Algum vendedor pode não ter realizado vendas no período.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class Challenge {

    public static void main(String[] args) {
        System.out.println(Challenge.retornaMenorEMaiorValorDeVendas(Arrays.asList(Arrays.asList(100,0,130,350, 600),Arrays.asList(100, 0, 130, 350),Arrays.asList(400, 500, 29, 99),Arrays.asList(32, 20, 255), Arrays.asList())));

    }

    public static List<Integer> retornaMenorEMaiorValorDeVendas(List<List<Integer>> listaVendedores) {

        System.out.println(listaVendedores);

        int max;
        int min;

        ArrayList<Integer> todasAsVendas = new ArrayList<>();

        for ( List<Integer> vendedor : listaVendedores) {
            todasAsVendas.addAll(vendedor);
        }
        Collections.sort(todasAsVendas);
        List<Integer> listaFiltrada = todasAsVendas.stream().filter( valor -> valor >= 20 && valor <= 500).collect(Collectors.toList());

        min = listaFiltrada.stream().mapToInt(v -> v).min().orElse(0);
        max = listaFiltrada.stream().mapToInt(v -> v ).max().orElse(0);

        System.out.println(listaFiltrada);

        return Arrays.asList(min, max);

    }
}