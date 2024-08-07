
package operacoes;

//import com.sun.istack.internal.FinalArrayList;
import estrutura.Aresta;
import estrutura.Componente;
import estrutura.Grafo;
import estrutura.Vertice;
import java.util.ArrayList;
import java.util.Collections;

public class SCC {
    private Grafo GScc;
    private ArrayList<Componente> ListSCC;
    
    public SCC() {
        super();
    }
    
    public SCC(Grafo G) {
        super();
        StronglyConnectedComponents(G);
    }
    
    private void StronglyConnectedComponents(Grafo G){
        DFS dfs = new DFS(G);
        Grafo GT = Gtransposto(dfs.getDfsG());   
        ArrayList<Vertice> V = GT.getV();
        Collections.sort(V, new comparetorVertice());
        Collections.reverse(V);
        DFS dfs2 = new DFS(new Grafo(V));
        this.GScc = dfs2.getDfsG();
        this.ListSCC = dfs2.getListComponent();
    }
    
    private Grafo Gtransposto(Grafo G){
        ArrayList<Vertice> V = G.getV();
        for (int i = 0; i < G.getVSize(); i++) {
            Vertice u = G.getV(i);
            for (int j = 0; j < u.getSizeAdj(); j++) {
                Vertice v = u.getAdj(j);
                Aresta e = u.getArestaAdj(j);
                e.inverteAresta();
                v.setTransAdj(e);
            }
        }
        for (int i = 0; i < V.size(); i++) {
            Vertice u = V.get(i);
            u.troca();
            V.set(i, u);
        }
        Grafo Gt = new Grafo(V);
        return Gt;
    }
    
    public Grafo getGScc() {
        return GScc;
    }

    public ArrayList<Componente> getListSCC() {
        return ListSCC;
    }
    
}
