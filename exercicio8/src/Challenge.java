/*
Um grande amigo seu mora numa cidade pequena, onde existem apenas duas empresas de táxi - a Empresa 1 e a Empresa 2. Ambas mudam suas taxas a cada dia e calculam o valor de suas corridas da seguinte forma: uma taxa fixa mais um valor por quilômetro rodado.
Seu amigo é fisioterapeuta e pega táxis diariamente para visitar seus clientes ao redor da cidade. Você decidiu escrever um código para ajudá-lo a decidir qual empresa escolher para cada uma das corridas, baseado no preço.

Sua função receberá 4 valores: TF1 (a taxa fixa da empresa 1), VQR1 (o valor por quilômetro rodado da empresa 1), TF2 (a taxa fixa da empresa 2), VQR2 (o valor por quilômetro rodado da empresa 2), todos em formato string. Seu retorno deve ser uma string em uma das seguintes formas:

“Tanto faz” - para o caso de o valor das duas empresas para qualquer corrida ser igual
“Empresa 1” - se o valor da Empresa 1 for sempre menor que o da Empresa 2
“Empresa 2” - para o caso contrário do citado acima
“Empresa Xpto quando a distância < N, Tanto faz quando a distância = N, Empresa Ypto quando a distância > N” para o caso de a escolha depender da distância a ser percorrida (onde Xpto e Ypto representa 1 ou 2 e N representa a distância).
Exemplo:
TF1 = 2,50
VQR1 = 1,00
TF2 = 5,00
VQR2 = 0,75
Output:
“Empresa 1 quando a distância < 10.0, Tanto faz quando a distância = 10.0, Empresa 2 quando a distância > 10.0”
 */


import java.util.Objects;

public class Challenge {

    public static void main(String[] args) {


        String tf1 = "2,50";
        String vqr1 = "1,00";
        String tf2 = "5,00";
        String vqr2 = "0,75";

        /*
        tf1 = 7.5 / vqr1 = 2.0 / tf2 = 5.0 / vqr2 = 0.75
        Valor 1 : 27.5 / Valor 2: 15.0
        expected:<Empresa [2]>
        but was:<Empresa [1 quando a distancia < 10.0, Tanto faz quando a distancia = 10.0, Empresa 2 quando a distancia > 10.0]>

        tf1 = 2.5 / vqr1 = 1.0 / tf2 = 5.0 / vqr2 = 2.75
        Valor 1 : 12.5 / Valor 2: 30.0
        expected:<Empresa 1[]>
        but was:<Empresa 1[ quando a distancia < 10.0, Tanto faz quando a distancia = 10.0, Empresa 2 quando a distancia > 10.0]>

        tf1 = 2.5 / vqr1 = 1.0 / tf2 = 5.0 / vqr2 = 0.75
        Valor 1 : 12.5 / Valor 2: 10.0
        expected:<...resa 1 quando a dist[ância < 10.0, Tanto faz quando a distância = 10.0, Empresa 2 quando a distâ]ncia > 10.0>
        but was:<...resa 1 quando a dist[ancia < 10.0, Tanto faz quando a distancia = 10.0, Empresa 2 quando a dista]ncia > 10.0>

        tf1 = 0 / vqr1 = 1.7 / tf2 = 5.0 / vqr2 = 1.0
        Valor 1 : 17.0 / Valor 2: 10.0
        expected:<...resa 1 quando a dist[ância < 7.14, Tanto faz quando a distância = 7.14, Empresa 2 quando a distância > 7.14]>
        but was:<...resa 1 quando a dist[ancia < 10.0, Tanto faz quando a distancia = 10.0, Empresa 2 quando a distancia > 10.0]>

        */



        Challenge.escolheTaxi(tf1, vqr1, tf2, vqr2);
        System.out.println(Challenge.escolheTaxi(tf1, vqr1, tf2, vqr2));
    }

    public static String escolheTaxi(String tf1, String vqr1, String tf2, String vqr2) {

        System.out.println("tf1 = " + tf1 + " / vqr1 = " + vqr1 + " / tf2 = " + tf2 + " / vqr2 = " + vqr2);
        double n = 10;

        double fixa1 = Double.parseDouble(tf1.replace(",","."));
        double fixa2 = Double.parseDouble(tf1.replace(",","."));
        double rotativa1 = Double.parseDouble(vqr1.replace(",","."));
        double rotativa2 = Double.parseDouble(vqr2.replace(",","."));

        double valor1 = fixa1 + ( n * rotativa1);
        double valor2 = fixa2 + ( n * rotativa2);

        n = (valor1 - fixa1) / rotativa1;


        String resultado = "";

        String fixaMaisVantajosa = (fixa1 > fixa2) ? "Empresa 2" : "Empresa 1";
        String fixaMenosVantajosa = (fixa1 > fixa2) ? "Empresa 1" : "Empresa 2";

        if (Objects.equals(tf1, tf2) && Objects.equals(rotativa1, rotativa2) )
            resultado = "Tanto faz";
        else if ( fixa1 > fixa2 && rotativa1 > rotativa2 ) resultado = "Empresa 2";
        else if ( fixa2 > fixa1 && rotativa2 > rotativa1 ) resultado = "Empresa 1";
        else {
            resultado =
                fixaMaisVantajosa + " quando a distancia < " + n +
                        ", Tanto faz quando a distancia = " + n +
                        ", " + fixaMenosVantajosa + " quando a distancia > " + n ;
        }
        System.out.println( "Valor 1 : " + valor1 + " / Valor 2: " + valor2);

        return resultado;
    }
}
