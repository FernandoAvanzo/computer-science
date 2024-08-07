/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Aresta;
import estrutura.Grafo;
import estrutura.Pilha;
import estrutura.Vertice;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class EC {
    
    private LinkedList<Vertice> C;
    private Pilha S;

    public EC() {
        super();
    }
    
    public EC(Grafo G) {
        super();
        hierholzer2(G);
        
    }
    
    private void hierholzer2(Grafo G){
        Vertice vo = G.getV(0);
        this.S = new Pilha(vo);
        this.C = new LinkedList<>();
        while (!this.S.Empty()) {            
            Vertice u = this.S.pop();
            CpreAdd(u);
            while (!u.EmptyAdj()) {                
                this.S.push(u);
                Aresta uv = u.RemoveAresta();
                uv.setNoCiclo(true);
                u = uv.getDestino();
                boolean ciclo;
                if(u.getFirstAresta() != null){ciclo = u.getFirstAresta().isNoCiclo();}else{ciclo = false;}
                
                while (ciclo) {
                     Aresta e;
                     e = u.RemoveAresta();
                     ciclo = e.isNoCiclo();
                     System.out.println("teste");
                }
                /*
                 boolean ciclo;
                if(u.getFirstAresta() != null){
                    if(u.getFirstAresta().getOrigem().isNoCiclo()&&u.getFirstAresta().getDestino().isNoCiclo()){
                        ciclo = u.getFirstAresta().getDestino().isNoCiclo();
                        u.getFirstAresta().setNoCiclo(true);
                    }else{
                        ciclo = false;
                    }
                }else{ciclo = false;}
                while (ciclo) {
                     Aresta e;
                     e = u.RemoveAresta();
                     ciclo = e.isNoCiclo();
                     System.out.println("teste");
                }
                */
                
            }
        }
    }
    
    private void CpreAdd(Vertice v){
        this.C.addLast(v);
    }

    public LinkedList<Vertice> getC() {
        return C;
    }
    
    
}
