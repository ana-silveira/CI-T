/*

Uma empresa fabrica painéis de LED compostos por quadrados de 1 cm de lado.
Nos vértices de cada quadrado fica um LED, sendo que o tamanho de cada painel é escolhido pelo cliente conforme a sua necessidade.
A imagem abaixo mostra um painel de 2 cm por 4 cm, composto por 15 LEDs no total.

Atualmente os funcionários desta fábrica perdem muito tempo (que poderia ser utilizado para inovação) com o cálculo manual desses painéis.
A alta diretoria da fábrica decidiu então contratar você para evoluir e construir um cálculo automatizado, modernizando assim os sistemas deles.

Considerando um painel de n por m centímetros, desenvolva um código para calcular o número total de LEDs no painel.

A imagem demonstra um painel de leds que possuem 4 quadrados agrupados em cima e 4 embaixo onde em
cada ponta possuem 4 pontos vermelhos de led totalizando 15 pontos.

OBS:

Os valores da altura e da largura devem ser recebidos por meio de parâmetros

 */
public class Challenge {

    public static void main(String[] args) {


        //Integer altura = 2;
        //Integer largura = 4;
        //Total de leds: 15

        //Integer altura = 2;
        //Integer largura = 3;
        //Total de leds: 12

        Integer altura = 0;
        Integer largura = 200;
        //Total de leds: 12

        Challenge.calculaTotalLeds(altura, largura);
        //System.out.println(Challenge.calculaTotalLeds(altura, largura));
    }


    public static Integer calculaTotalLeds(Integer altura, Integer largura) {

        Integer quantidadeLEDs = 1;

        Integer AREA_PAINEL = 1;
        Integer areaPainelCliente = altura * largura;

        Integer quantPaineisDeLed = areaPainelCliente / AREA_PAINEL;

        Integer[][] painelMatriz = new Integer[altura][largura];


        if (areaPainelCliente >= AREA_PAINEL) {
            for (int i = 0; i <= altura; i++) {
                for (int j = 0; j <= largura; j++) {
                    if (i == 0) quantidadeLEDs = j + 1; // 1 é o número de leds na posição [0,0]
                    else {
                        quantidadeLEDs++;
                    }
                    System.out.println("Quant de leds: " + quantidadeLEDs + " / i = " + i + " j = " + j);
                }
                System.out.println(quantidadeLEDs);
            }
        } else {
            quantidadeLEDs = 0;
        }
        return quantidadeLEDs;
    }
}

