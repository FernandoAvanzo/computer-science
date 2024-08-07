
package operacoes;

import estrutura.Componente;
import estrutura.Grafo;
import estrutura.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {
    private int tempo;
    private Grafo dfsG;
    private LinkedList<Vertice> VFinalList;
    private Componente component;
    private ArrayList<Componente> listComponent;
    
    
    public DFS(){
        super();
        this.VFinalList = new LinkedList<>();
        this.listComponent = new ArrayList<>();
    }
    
    public DFS(Grafo G){
        super();
        this.VFinalList = new LinkedList<>();
        this.listComponent = new ArrayList<>();
        dfs(G);
    }
    
    private void dfs(Grafo G){
        for (int i = 0; i < G.getVSize(); i++) {
            Vertice u = G.getV(i);
            u.setCor("branco");
            u.setPai(null);
        }
        this.tempo = 0;
        for (int i = 0; i < G.getVSize(); i++) {
            Vertice u = G.getV(i);
            if (u.getCor().equals("branco")) {
                this.component = new Componente();
                dfsVisit(G, u);
                addComponent(this.component);
            }
        }
        this.dfsG = G;
    }
    
    private void dfsVisit(Grafo G, Vertice u){ 
        this.tempo += 1;
        u.setD(tempo);
        u.setCor("cinza");
        for (int i = 0; i < u.getSizeAdj(); i++) {
            Vertice v = u.getAdj(i);
            if (v.getCor().equals("branco")) {
                v.setPai(u);
                dfsVisit(G, v);
            }
        }
        u.setCor("preto");
        tempo += 1;
        u.setF(tempo);
        setVFinalList(u);
        addItem(u);
    }
    
    private void addComponent(Componente C){
        this.listComponent.add(C);
    }
    
    private void addItem(Vertice v){
        this.component.addIten(v);
    }
    
    public Grafo getDfsG() {
        return dfsG;
    }

    private void setVFinalList(Vertice v) {
        if(this.VFinalList.isEmpty()){
            this.VFinalList.add(v);
        }else{
            this.VFinalList.addFirst(v);
        }
    }

    public LinkedList<Vertice> getVFinalList() {
        return VFinalList;
    }

    public ArrayList<Componente> getListComponent() {
        return listComponent;
    }
    
}
