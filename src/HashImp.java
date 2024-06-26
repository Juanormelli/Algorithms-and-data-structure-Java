import java.util.ArrayList;

public class HashImp {
    int[] arr ;
    public HashImp(int size){
        this.arr =  new int[size];
    }

    private int hashFunc(String key){
        int hash = 0;

        for (int i = 0; i< key.length(); i++){
            hash = (hash + (int)key.charAt(i) * i)% this.arr.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int positionKey = hashFunc(key);

        arr[positionKey] = value;
    }
     public int get(String key){
        int positionKey = hashFunc(key);

        return arr[positionKey] ;
    }


}
