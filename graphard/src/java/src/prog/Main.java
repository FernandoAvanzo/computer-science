/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prog;

import arquivo.Tgf;
import estrutura.Aresta;
import estrutura.Componente;
import estrutura.Grafo;
import estrutura.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;
import operacoes.BFS;
import operacoes.BfsSaida;
import operacoes.EC;
import operacoes.MST;
import operacoes.SCC;
import operacoes.TS;


public class Main {
    public static void main(String [] args)throws Exception{
       String sel = "ec";
        
        switch (sel) {
        case "bfs":
            BFS(args[1]);
            break;
        
        case "ts" :
            TS(args[1]);
            break;

        case "scc":
            SCC(args[1]);
            break; 
                    
        case "mst":
            MST(args[1]);
        
        case "ec":
            System.out.println("roudou");
            EC("C:\\graphard\\testes\\ec\\10.g");
               
        default: break;
        }
    }

    private static void BFS(String path) {
        Grafo G = new Grafo(path);
        Vertice s = G.getV(0);
        BFS bfs = new BFS(G, s);
        G = bfs.getGbfs();
        BfsSaida out = new BfsSaida();
        for (int j = 0; j < G.getVSize(); j++) {
          Vertice u = G.getV(j);
          out.setAcessa(G.getV(j).getNome());
          out.setDistancia(G.getV(j).getD());
          out.setOrigem(G.getV(0).getNome()); 
          System.out.println(out.getOrigem()+" "+out.getAcessa()+" "+out.getDistancia());   
        } 
    }

    private static void TS(String path) {
        Grafo G = new Grafo(path);
        TS ts = new TS(G);
        LinkedList<Vertice> tsList = ts.getTSlist();
        while (!tsList.isEmpty()) {                
            Vertice u = tsList.getFirst();
            tsList.removeFirst();
            System.out.println(u.getNome());
        
         }
   }

    private static void SCC(String path) {
            Grafo G = new Grafo(path);
            Grafo GT = new Grafo(path);
            SCC scc = new SCC(GT);
            ArrayList<Componente> comp = scc.getListSCC();
            Componente C;
            
            for (int i = 0; i < comp.size(); i++) {
                C = comp.get(i);
                for (int j = 0; j < C.componentSize(); j++) {
                    Vertice u = C.getIten(j);
                    System.out.print(u.getNome()+" ");
                }
                System.out.println("");
        }
    }

    private static void MST(String path) {
        Grafo G = new Grafo(path);
        Aresta e = G.getArestaE(0);
        MST mst = new MST(G);
        LinkedList<Aresta> es = mst.getA();
         for (int j = 0; j < es.size(); j++) {
             Aresta w = es.get(j);
             System.out.print(w.getOrigem().getNome()+" "+w.getDestino().getNome());
             System.out.println("");

         }
    }
    
    private static void EC(String path){
        Tgf file = new Tgf(path);
        Grafo G = file.getG();
        //EC ec= new EC(G);
       
        for (int i = 0; i < G.getVSize(); i++) {
            Vertice u = G.getV(i);
            System.out.println(u.getNome());
            for (int j = 0;  j< u.getSizeAdj(); j++) {
                Aresta e = u.getArestaAdj(j);
                System.out.println(e.getOrigem().getNome()+" <->"+e.getDestino().getNome());
            }
        }
        
    }
            
      
}
