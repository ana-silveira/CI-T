/*
Você e o seu time estão desenvolvendo um sistema de indicações de postos de gasolina que ficam próximos da localização atual do veículo.
No modo de direção “viagem”, a funcionalidade a ser desenvolvida é de indicar ao condutor o posto mais distante possível no limite atual de combustível.
E caso não exista posto de gasolina, retornar -1.

A pessoa responsável por fazer a especificação do sistema informou que você terá as seguintes informações:
— consumo médio de combustível,
— quantidade de combustível restante no veículo e
— um array contendo distâncias dos postos de gasolinas.

Exemplo:
Combustivel (em litros): 2
Consumo médio (km/l): 8
Postos de Gasolina (km): [2, 15, 22, 10.2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Challenge {

    public static void main(String[] args) {
        List<Integer> postosDeGasolina = new ArrayList<>();
        int parada = Challenge.ultimaParada(2, 8, Arrays.asList(2, 15, 22, 11));
        System.out.println(parada);
    }

    public static Integer ultimaParada(Integer combustivel, Integer consumo, List<Integer> postosDeGasolina) {
        int distancia = combustivel * consumo;
        int postoAtualNaLista = 0;

        for (Integer posto : postosDeGasolina) {
            if (posto < distancia) {
                if (postoAtualNaLista < posto) {
                    postoAtualNaLista = posto;
                }
            }
        }

        return ( postoAtualNaLista > 0 ) ? postoAtualNaLista : -1;
    }
}

