/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Grafo;
import estrutura.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Incubadora2
 */
public class BFS {
    private Grafo Gbfs;
    private ArrayList<Vertice> vG;
    private LinkedList<Vertice> Q = new LinkedList<>();
    
    public BFS(Grafo G, Vertice s){
        super();
        this.vG = new ArrayList<>();
        bfs(G, s);
    }
    
    private void bfs(Grafo G, Vertice s){
        G.Vremove(s);
        for (int i = 0; i < G.getVSize();i++) {
             Vertice u = G.getV(i);
             u.setCor("branco");
             u.setD(null);
             u.setPai(null);
        }
        s.setCor("cinza");
        s.setD(0);
        s.setPai(null);
        Enqueue(s);
        while (!this.Q.isEmpty()) {
            Vertice u = Desenqueue();
            for (int i = 0; i < u.getSizeAdj(); i++) {
                Vertice v = u.getAdj(i);
                if("branco".equals(v.getCor())){
                    v.setCor("cinza");
                    v.setD(u.getD()+1);
                    v.setPai(u);
                    Enqueue(v);
                }
            }
            u.setCor("preto");
            setvG(u);
        }
    }
    private void Enqueue(Vertice v){
        if(this.Q.isEmpty())
        {
            this.Q.add(v);
        }else{
            this.Q.addLast(v);
        }        
    }
    
    private Vertice Desenqueue(){
        Vertice v = this.Q.getFirst();
        this.Q.removeFirst();
        return v;
    }

    private void setvG(Vertice v) {
        this.vG.add(v);
    }

    public Grafo getGbfs() {
        this.Gbfs = new Grafo(this.vG);
        return Gbfs;
    }
 
}
