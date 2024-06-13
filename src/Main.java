//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Criando Grafo
        var Grafo = new HashMap();
        Grafo.put("Inicio", new HashMap<>());
        Grafo.put("A", new HashMap<>());
        Grafo.put("B", new HashMap<>());
        Grafo.put("C", new HashMap<>());
        Grafo.put("D", new HashMap<>());
        Grafo.put("Fim", new HashMap<>());

        // Definindo os priemiros Valores do Grafo
        HashMap inicio = (HashMap) Grafo.get("Inicio");
        inicio.put("A", 5);
        inicio.put("B", 2);


        // Definindo os vertices
        HashMap a = (HashMap) Grafo.get("A");
        a.put("C", 4);
        a.put("D", 2);


        HashMap b = (HashMap) Grafo.get("B");
        b.put("A", 8);
        b.put("D", 7);

        HashMap c = (HashMap) Grafo.get("C");
        c.put("D", 6 );
        c.put("Fim", 3);

        HashMap de = (HashMap) Grafo.get("D");
        de.put("Fim", 1);

        // Definindo custos iniciais
        var Custos = new HashMap();
        Custos.put("A",6);
        Custos.put("B",2);
        Custos.put("C",10000000);
        Custos.put("D",100000000);
        Custos.put("Fim",1000000000);

        // Definindo os vertices Pais de cada vertice
        var Pais = new HashMap();
        Pais.put("A","Inicio");
        Pais.put("B","Inicio");
        Pais.put("C",null);
        Pais.put("D",null);
        Pais.put("Fim",null);


        // Inicializando classe responsavel pela implementação da função de encontrar o menor node em cada uma das vertices
        Dijkstra d = new Dijkstra();
        // Array onde vamos aramazenar pontos que já foram processados
        ArrayList<String> proc = new ArrayList<String>();

        // Inicio do Algorithm
        // Pirmeira chamada para a função onde iremos encontrar o primeiro node com menor custo
        String node = d.FindLessNode(Custos, proc);

        // Loop: Enquanto o node tiver Outras vertices continuamos a exec
        while(node != null){

            // Pegamos o custo do node selecionado
            var custo = (Integer)Custos.get(node);
            // Buscamos no nosso grafo inicial os vizinhos do node atual
            var vizinhos = (HashMap)Grafo.get(node);

            // Fazemos um loop para cada vizinho do node
            for (var n : vizinhos.keySet()) {

                // Criamos um calculo do novo custo para aquela vertice especifica
                var novo_cost = custo + (Integer)vizinhos.get(n);

                // Validamos os valores do custo novo, com o custo antigo daquela vertice
                if ((Integer)Custos.get(n) > novo_cost){
                    // Caso o custo novo seja menor que o atual: Atualizamos o custo do vizinho e Ataulizamos o pai do nosso node
                     Custos.put(n,novo_cost);
                     Pais.put(n,node);
                }
            }
            // Adicionamos o node a lista de validados
            proc.add(node);

            // E continuamos a execução a partir da nossa funçao inicial
            node = d.FindLessNode(Custos, proc);

        }

        System.out.println(Custos);
        System.out.println(Pais);

    }

}