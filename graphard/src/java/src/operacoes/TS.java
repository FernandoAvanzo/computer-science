
package operacoes;

import estrutura.Componente;
import estrutura.Grafo;
import estrutura.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;

public class TS {
    private LinkedList<Vertice> TSlist;
    private ArrayList<Componente> ComponentList;
    
    public TS(){
        super();
        this.TSlist = new LinkedList<>();
    }
    
    public TS(Grafo G){
        super();
        this.TSlist = new LinkedList<>();
        TopologicalSort(G);
    }
    
    private void TopologicalSort(Grafo G){
        DFS dfs = new DFS(G);
        setTSlist(dfs.getVFinalList());
        this.ComponentList = dfs.getListComponent();
    }

    private void setTSlist(LinkedList<Vertice> TSlist) {
        this.TSlist = TSlist;
    }
    
    public ArrayList <Vertice> TSList(){
        ArrayList<Vertice> V = new ArrayList<>();
        LinkedList<Vertice> ts = getTSlist();
        while(!ts.isEmpty()){
            V.add(ts.getFirst());
            ts.removeFirst();
        }
        return V;
    }
    
    public ArrayList<Vertice>TSListInverted(){
        ArrayList<Vertice> V = new ArrayList<>();
        LinkedList<Vertice> ts = getTSlist();
        while(!ts.isEmpty()){
            V.add(ts.getLast());
            ts.removeLast();
        }
        return V;
    }
    
    public LinkedList<Vertice> getTSlist() {
        return TSlist;
    }

    public ArrayList<Componente> getComponentList() {
        return ComponentList;
    }
    
}
