public class TestHash {

   public static void main(String[] args) {
       HashImp hs = new HashImp(50);
       hs.set("Teste", 255);
       System.out.println(hs.get("Teste"));



   }
}
