/*
Durante uma expedição tecnológica, sua equipe encontrou o que parece ser a senha que lhes dá acesso a um grande tesouro
digital. Por sorte, sua equipe é formada pelas pessoas mais feras em programação e vocês rapidamente descobriram como decifrá-la.

Com a possibilidade de que vocês encontrem mais códigos contendo outras senhas, você foi designado à tarefa de
desenvolver um algoritmo que decifra os códigos para não precisarem fazer isso de forma manual.

A senha é representada por um número binário de 10 dígitos formado pelo dígito predominante de cada coluna.
Caso a coluna tenha a mesma quantidade de dígitos 0 e 1, deve se considerar o número 1.

Exemplo: A primeira coluna da lista tem como dígito predominante o número 1, sendo assim, o primeiro dígito - dos 10 - da senha é 1.

0110100000
1001011111
1110001010
0111010101
0011100110
1010011001
1101100100
1011010100
1001100111
1000011000

Desenvolva um algoritmo que receba um array de valores binários (como o exemplo acima) e retorne a representação decimal da senha.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenge {

    public static void main(String[] args) {
        /*
        List<Integer> listaMatriz = new ArrayList<>();
        Arrays.asList(
                "0110100000",
                "1001011111",
                "1110001010",
                "0111010101",
                "0011100110",
                "1010011001",
                "1101100100",
                "1011010100",
                "1001100111",
                "1000011000");
        int matrizSenha = Challenge.calculaNumeroDaSenha(listaMatriz);
        */

        List<String> matrizSenha = Arrays.asList("0110100000","1001011111","1110001010","0111010101","0011100110","1010011001","1101100100","1011010100","1001100111","1000011000");

        Challenge.calculaNumeroDaSenha(matrizSenha);

        //System.out.println(Challenge.calculaNumeroDaSenha(matrizSenha));
    }

    public static Integer calculaNumeroDaSenha(List<String> senha) {

        Integer[][] intListaArrays = new Integer[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String[] listaNumeros = senha.get(i).split("(?!^)"); //[0, 1, 1, 0, 1, 0, 0, 0, 0, 0]
                intListaArrays[i][j] = Integer.parseInt(listaNumeros[j]);
            }
        }

        int contZero = 0;
        int contUm= 0;

        List<Integer> digitosSenha = new ArrayList<>();

        //Para calcular os 10 digitos da senha em número binário:
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                int contador = (intListaArrays[j][i] == 0) ? contZero++ : contUm++;
                System.out.println("Linha " + j + " Coluna " + i + " -> ContZero: " + contZero + " / ContUm: " + contUm);
            }
            digitosSenha.add((contUm == contZero) ? (1) : (contZero > contUm) ? (0) : (1));
            contZero = 0;
            contUm = 0;
        }   //System.out.println(digitosSenha);


        // Transformar o número binário em número decimal:
        System.out.println();
        System.out.println();
        System.out.println();

        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < 10; i++){
            texto.append(digitosSenha.get(i));
        }
        System.out.println(texto);

        return Integer.parseInt(String.valueOf(texto), 2);
    }
}