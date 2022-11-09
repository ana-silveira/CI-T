/*
Uma famosa empresa de streams de jogos quer fornecer para os seus streamers um mecanismo para eles poderem realizar
sorteios nas suas lives de formas a dar mais chances para seus fãs mais fiéis. Você foi contratado com a missão de
ajudar a automatizar esse sorteio, sendo que ele deve seguir as seguintes regras:

A chance de uma pessoa ser sorteada é diretamente proporcional às horas de conteúdo que ela assistiu naquele canal.
Assim sendo, uma pessoa que ficou 20 horas acompanhando esse streamer tem o dobro de chances de ser sorteado do que uma
pessoa que o assistiu durante 10 horas, se ambas não forem assinantes pagos. O número de horas é recebido em minutos e
é sempre arredondado para cima, ou seja:

181 minutos = 4h
239 min = 4h
180 min = 3h

Se você possui uma assinatura paga da plataforma, suas chances são dobradas. Assim, no caso acima, se a pessoa que
assistiu 10 horas for assinante premium e a que assistiu 20 horas não, ambos terão a mesa chance no sorteio.

Assuma que você vai receber os dados de horas assistidas e de assinaturas em dois vetores, no modelo mostrado abaixo:

assinante = [True, False, False, False, True, False, True, True, False, False, False]
minutos_assistidos = [6144, 2742, 330, 30, 1500, 4032, 24036, 3288, 2076, 24540, 4716]
Considere que as mesmas posições do vetor representam a mesma pessoa.
Ex:
A pessoa número 1 é assinante e viu 103 horas de conteúdo
A pessoa número 4 não é assinante e viu meia hora de conteúdo
Escreva um código que retorne um vetor com o percentual de chances de cada uma das pessoas ser sorteada. Retorne os
valores arredondados para o inteiro mais próximo.

Exemplo:
assinante = [True, False]
horas_assistidas = [ 60, 120]

Output:
[50, 50]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Challenge {

    public static void main(String[] args) {

        //List<Boolean> assinante = Arrays.asList(true, false, false, false, true, false, true, true, false, false, false);
        //List<Integer> minutos_assistidos = Arrays.asList (6144, 2742, 330, 30, 1500, 4032, 24036, 3288, 2076, 24540, 4716);

        //List<Boolean> assinante = Arrays.asList(true, false);
        //List<Integer> minutos_assistidos = Arrays.asList (60, 120);

        List<Boolean> assinante = Arrays.asList(true, false, false, false, true, false, true, true, false, false, false);
        List<Integer> minutos_assistidos = Arrays.asList (6144, 2742, 330, 30, 1500, 4032, 24036, 3288, 2076, 24540, 4716);

        System.out.println(Challenge.calculaPorcentagemSorteio(assinante, minutos_assistidos));
    }

    public static List<Integer> calculaPorcentagemSorteio(List<Boolean> assinante, List<Integer> minutosAssistidos) {

        System.out.println(assinante);
        System.out.println(minutosAssistidos);
        System.out.println();


        //Converter minutos em horas:
        List<Integer> horas_assistidas = new ArrayList<>();

        for (int minuto : minutosAssistidos){
            int horas = 0;
            horas = minuto / 60;
            if ( minuto % 60 != 0) {
                horas++;
            }

            System.out.println(horas);
            horas_assistidas.add(horas);
        }

        //Correção das horas entre assinantes (2x) e não assinantes:
        int valorHoraCorrigida = 0;
        List<Integer> horasCorrigidas = new ArrayList<>();
        for (int i = 0; i < horas_assistidas.toArray().length; i++){
            valorHoraCorrigida = (assinante.get(i)) ?  2 * horas_assistidas.get(i) :  horas_assistidas.get(i);
            horasCorrigidas.add(valorHoraCorrigida);
        }

        //Verificar chances de ser sorteado:
        int totalHoras = 0;
        List<Integer> chancesDeSerSorteada = new ArrayList<>();

        System.out.println(assinante.toArray().length);

        totalHoras = horasCorrigidas.stream().reduce(0, Integer::sum);
        System.out.println(totalHoras);
        /*for (int i = 0; i < assinante.toArray().length; i++){
            totalHoras += horasCorrigidas.get(i);
            System.out.println(totalHoras);
        }
        */

        int chances;
        for (int hora : horasCorrigidas){ // Erro no arredondamento
            chances = (hora * 100) / totalHoras ;
            chancesDeSerSorteada.add(chances);
        }

        return chancesDeSerSorteada;
    }
}