
/*
Encontrar o par de valores do array que contem a soma passada como argumento
da nossa função

Devemnos considerar que o Array nao tem limite de tamanhi e devemos buscar uma solução:
O(n) para esse problema


 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CodeInterviewIdea {
    public static void main(String[] args) {

       Random random = new Random();

       int[] numbers = random.ints(100000000).toArray();
        System.out.println(numbers.length);
        System.out.println(PairSum(numbers, 100));

    }


    public static boolean PairSum(int[] array, int sum){
        // Podemos fazer a solução bruta, onde usaremos um loop aninhado o que causara a complexidade de execução O(n^2)
        /*
        * Para tentar minimizar essa solução precisamos entao realizar a criação de uma estrutura onde nao
        * vamos precisar validar item por item para chegar ao resultado
        *
        */
        //Criaremos um hash que aramzenara os nossos valores que correspondem a ao valor do array - o valor da soma depois entenderemos

        Set<Integer> corr = new HashSet<Integer>();

        // Após criar nosso Hash vamos começar a logica que será a seguinte:
        /*
        * Sempre vamospegar o valor do array e realizar a subtração da soma - ele
        * Após isso vamos validar se esse numero já existe no Hash
        * Caso exista vamos printar que temos um par de valores correspondentes para chegar ao valor da soma
        * Caso nao exista vamos adicionar o valor no hash ( Soma - Array[i])
        * E depois continuar para o proximo item
        */

        for (int item: array){
            int rest = sum - item;
            if (corr.contains(rest)){
                return true;
            }
            corr.add(rest);
        }
        return false;

    }
}
