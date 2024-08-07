
package estrutura;

import arquivo.Tgf;
import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
    private ArrayList<Vertice> V;
    private ArrayList<Vertice> V2;
    private LinkedList<Aresta> E;
    private Tgf fileGrafo;

    
    public Grafo(){
        super();
        this.V = new ArrayList<>();
        this.E = new LinkedList<>();
    }
    
    public Grafo(ArrayList<Vertice> V){
        super();
        this.E = new LinkedList<>();
        setV(V);
    }
    public Grafo(String path){
        super();
        this.fileGrafo = new Tgf(path);
        this.V = this.fileGrafo.getVertices();
    }
    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    private void setV(ArrayList<Vertice> V) {
        this.V = V;
    }
    
    public void setV(Vertice U,Vertice V){
        int i = this.V.indexOf(U);
        this.V.set(i, V);
    }
    public ArrayList<Vertice> getV() {
        return V;
    }
    
    public Vertice getV(int i){
        return this.V.get(i);
    }
    public Vertice getV(Vertice V){
        int i = this.V.indexOf(V);
        return this.V.get(i);
    }
    
    
    
    public int getVSize(){
        int size = this.V.size();
        return size;         
    }
    
    public void Vremove(Vertice v){
        this.V.remove(v);
    }

    public ArrayList<Vertice> getV2() {
        return V2;
    }

    public LinkedList<Aresta> getE2() {
        return E;
    }
    
    public int sizeE(){
        int size = this.E.size();
        return size;
    }
    
    public Aresta getArestaE(int i){
        Aresta e = this.E.get(i);
        return e;
        
    }
   
}
