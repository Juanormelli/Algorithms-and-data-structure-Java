import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DinamycProg {

    public static void main(String[] args) {
        var list = new HashMap<>();
        list.put("Water", new int[2]);
        list.put("Book", new int[2]);
        list.put("Food", new int[2]);
        list.put("Casaco", new int[2]);
        list.put("Camera", new int[2]);

        var enumerator = new HashMap<>();
        enumerator.put(0, "Water");
        enumerator.put(1, "Book");
        enumerator.put(2, "Food");
        enumerator.put(3, "Casaco");
        enumerator.put(4, "Camera");

        int[] Water = (int []) list.get("Water");
        Water[0] = 3;
        Water[1] = 10;

        int[] Book = (int []) list.get("Book");
        Book[0] = 1;
        Book[1] = 3;

        int[] Food = (int []) list.get("Food");
        Food[0] = 2;
        Food[1] = 9;

        int[] Casaco = (int []) list.get("Casaco");
        Casaco[0] = 2;
        Casaco[1] = 5;

        int[] Camera = (int []) list.get("Camera");
        Camera[0] = 1;
        Camera[1] = 6;



        List best = BestDecision(list, 6, enumerator);

        System.out.println(SubStr("Mario", "Maria"));
    }

    public static List<String> BestDecision(HashMap integerList, int maxKg, HashMap lhmEnumarator){
        int Best = 0;
        int[][] tab = new int[integerList.size()][6];
        List<String> names = new ArrayList<>();
        for (int i = 0; i <=integerList.size() ; i++) {
            for (int j = 1; j <= maxKg ; j++) {
                int[] teste = (int[]) integerList.get(lhmEnumarator.get(i));
                if (teste == null){
                    return names;
                }
                if(i == 0){
                    if(j == maxKg){
                         names.add((String)lhmEnumarator.get(i));
                    }

                    if (teste[0] <=  j){
                        tab[i][j - 1] = teste[1];
                        Best = teste[1];


                    }
                    else {
                        tab[i][j - 1] = 0;
                    }


                }
                else {
                    if (teste[0] <=  j) {
                        if(j - 1 - teste[0] < 0){
                            if(tab[i - 1][j - 1] > teste[1]){
                                tab[i][j - 1] = tab[i - 1][j - 1];
                            }
                            else{
                                tab[i][j - 1] = teste[1];
                            }

                        }
                        else {
                            tab[i][j - 1] = Math.max(tab[i - 1][j - 1], teste[1] + tab[i - 1][j - 1 - teste[0]]);

                            if (tab[i][j - 1] > Best) {
                                Best = tab[i][j - 1];
                                names.remove(0);
                                names.add((String) lhmEnumarator.get(i));

                            }
                        }
                    }
                    else {
                        tab[i][j - 1] = tab[i - 1][j - 1];
                    }

                }


            }

        }
        System.out.println(names);
        return names;
    }

    public static int SubStr(String str1, String str2){
        int[][] tab = new int[str1.length()][str2.length()];
        int numChar = 0;
        for (int i = 0; i< str1.length(); i++){
            for (int j=0; j<str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j) && i==0){
                    tab[i][j] = 1;
                    numChar = 1;
                }
                else if (str1.charAt(i) == str2.charAt(j) && i!=0){
                    if ( j - 1 >=0){
                        tab[i][j] = tab[i-1][j-1] + 1;
                        numChar = tab[i][j];
                    }
                }
                else{
                    tab[i][j] = 0;
                }
            }
        }

        return numChar;
    }
}
