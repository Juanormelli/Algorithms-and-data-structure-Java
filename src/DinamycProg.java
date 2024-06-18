import java.util.HashMap;

public class DinamycProg {

    public static void main(String[] args) {
        var vlList = new HashMap<>();
        vlList.put("Water", new int[2]);
        vlList.put("Book", new int[2]);
        vlList.put("Food", new int[2]);
        vlList.put("Casaco", new int[2]);
        vlList.put("Camera", new int[2]);

        var vlEnumerator = new HashMap<>();
        vlEnumerator.put(0, "Water");
        vlEnumerator.put(1, "Book");
        vlEnumerator.put(2, "Food");
        vlEnumerator.put(3, "Casaco");
        vlEnumerator.put(4, "Camera");

        int[] Water = (int []) vlList.get("Water");
        Water[0] = 3;
        Water[1] = 10;

        int[] Book = (int []) vlList.get("Book");
        Book[0] = 1;
        Book[1] = 3;

        int[] Food = (int []) vlList.get("Food");
        Food[0] = 2;
        Food[1] = 9;

        int[] Casaco = (int []) vlList.get("Casaco");
        Casaco[0] = 2;
        Casaco[1] = 5;

        int[] Camera = (int []) vlList.get("Camera");
        Camera[0] = 1;
        Camera[1] = 6;

        int viSumOfBestDecision = BestDecision(vlList, 6, vlEnumerator);
        System.out.println(viSumOfBestDecision);
        System.out.println(SubStr("Mario", "Maria"));
    }

    public static int BestDecision(HashMap liList, int liMaxKg, HashMap lhmEnumarator){
        int viSumOfBestDecision = 0;
        int[][] vtbTable = new int[liList.size()][6];

        for (int i = 0; i <= liList.size() ; i++) {
            for (int j = 1; j <= liMaxKg; j++) {
                int[] element = (int[]) liList.get(lhmEnumarator.get(i));
                if (element == null) {
                    return viSumOfBestDecision;
                }
                if (i == 0) {
                    if (element[0] <= j) {
                        vtbTable[i][j - 1] = element[1];
                        viSumOfBestDecision = element[1];
                    } else {
                        vtbTable[i][j - 1] = 0;
                    }
                } else {
                    if (element[0] <= j) {
                        if (j - 1 - element[0] < 0) {
                            if (vtbTable[i - 1][j - 1] > element[1]) {
                                vtbTable[i][j - 1] = vtbTable[i - 1][j - 1];
                            } else {
                                vtbTable[i][j - 1] = element[1];
                            }
                        } else {
                            vtbTable[i][j - 1] = Math.max(vtbTable[i - 1][j - 1], element[1] + vtbTable[i - 1][j - 1 - element[0]]);

                            if (vtbTable[i][j - 1] > viSumOfBestDecision) {
                                viSumOfBestDecision = vtbTable[i][j - 1];
                            }
                        }
                    } else {
                        vtbTable[i][j - 1] = vtbTable[i - 1][j - 1];
                    }

                }
            }
        }
        return viSumOfBestDecision;
    }

    public static int SubStr(String lsString1, String lsString2){
        int[][] vtbTable = new int[lsString1.length()][lsString2.length()];
        int viNumOfCharSubStr = 0;
        for (int i = 0; i< lsString1.length(); i++){
            for (int j = 0; j< lsString2.length(); j++){
                if (lsString1.charAt(i) == lsString2.charAt(j) && i==0){
                    vtbTable[i][j] = 1;
                    viNumOfCharSubStr = 1;
                }
                else if (lsString1.charAt(i) == lsString2.charAt(j) && i!=0){
                    if ( j - 1 >=0){
                        vtbTable[i][j] = vtbTable[i-1][j-1] + 1;
                        viNumOfCharSubStr = vtbTable[i][j];
                    }
                }
                else{
                    vtbTable[i][j] = 0;
                }
            }
        }
        return viNumOfCharSubStr;
    }
}
