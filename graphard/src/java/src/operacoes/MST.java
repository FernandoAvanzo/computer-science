/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Aresta;
import estrutura.Grafo;
import estrutura.Vertice;
import java.util.Collections;
import java.util.LinkedList;

public class MST {
    private LinkedList<Aresta> A;

    public MST(Grafo G) {
        super();
        kruskal(G);
    }
    
    
    
    private void kruskal(Grafo G){
       this.A = new LinkedList<>();
       
       for (int i = 0; i < G.getVSize(); i++) {
           Vertice v = G.getV(i);
           makeSet(v);
       } 
       Collections.sort(G.getE2(), new comparetorAresta());
        for (int i = 0; i < G.sizeE(); i++) {
            Aresta e = G.getArestaE(i);
            if (!findSet(e.getOrigem()).equals(findSet(e.getDestino())) ){ 
               A.add(e) ;
               union(e.getOrigem(), e.getDestino()); 
            }        
        }
    }
    public void makeSet(Vertice v){
        v.setPai(v);
        v.setD(0);
        
    }
    public Vertice findSet(Vertice v){
        if ((!v.equals(v.getPai()))){
            v.setPai(findSet(v.getPai()));
        }
        return v.getPai();
    }
    public void union(Vertice v, Vertice y){
        link(findSet(v),findSet(y));
    }
    public void link(Vertice v, Vertice y){
        if (v.getD() > y.getD()){
            y.setPai(v);
        } else {
            v.setPai(y);
            if (v.getD()== y.getD()){
                y.setD(y.getD()+1);
            }
        }
    }
    public LinkedList<Aresta> getA() {
        return A;
    }
}
