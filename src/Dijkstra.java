import java.util.ArrayList;
import java.util.HashMap;


public class Dijkstra {
    public String FindLessNode(HashMap custos, ArrayList<String> proc) {
        Integer lessCost = 1000000;
        String lessCostNode = null;
        for (var cost : custos.keySet()) {
            int custo = (Integer) custos.get(cost);
            if (custo < lessCost && !proc.contains(cost)) {
                lessCost = custo;
                lessCostNode = cost.toString();
            }
        }
        return lessCostNode;
    }
}
