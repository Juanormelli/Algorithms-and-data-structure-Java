import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDS {
  public static void main(String[] args) {
    String str = "Olá sou o Juan";
    System.out.println(reverseString(str));

    int[] arr1 = {0,3,4,31, 37, 39} ;
    int[] arr2 = {4,6,30};

    System.out.println(mergeSortedArrays(arr1, arr2));

  }

  /*
  * Precisamos inverter uma string entao vamos começar pensando que teremos que transformar ela em um array para facilitar esse ponto
  *
  * */
  public static String reverseString (String str1){
     String[] words = str1.split("");

    // Criamos nossa variavel que será responsavel por armazenar a nossa string reversa
    // Criamos um loop inverso que ira do tamanho do array até 0 poassaando letra por letra e adicionando o valor em nossa Variavel criada para armazenar oi valor

    StringBuilder strReverse = new StringBuilder();
    for(int i = words.length - 1; i>=0; i--){
        strReverse.append(words[i]) ;
    }
    String Reverse = strReverse.toString();
    return Reverse;


    // O(n)

  }

  /*
  * Temos dlis Arrays oredenados e queremos que seja feito uma uniao destes arrays
  * */
  public static List mergeSortedArrays (int[] arr1, int[] arr2){
    List<Integer> mergedArray = new ArrayList<>();

    int length = arr1.length + arr2.length;
    int countArr2 = 0;
    int countArr1 = 0;

    while(countArr1 + countArr2 <= length - 1){
      if(countArr1 >= arr1.length && countArr2 < arr2.length){
        mergedArray.add(arr2[countArr2]);
        countArr2++;
      }
      else if(countArr2 >= arr2.length && countArr1 < arr1.length){
        mergedArray.add(arr1[countArr1]);
        countArr1++;
      }
      else if (arr1[countArr1] < arr2[countArr2]) {
        mergedArray.add(arr1[countArr1]);
        countArr1++;
      }
      else{
        mergedArray.add(arr2[countArr2]);
        countArr2++;
      }
    }
    return mergedArray;
  }
}
