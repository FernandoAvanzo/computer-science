/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Vertice {
    private String nome;
    private Integer d;
    private Integer f;
    private Vertice pai = null;
    private String cor = "";
    private LinkedList<Aresta> Adj;
    private LinkedList<Aresta> TransAdj;
    private LinkedList<Vertice> VerticeAdj;
    private Integer peso;
    private boolean noCiclo = false;
    
    public Vertice(){
        super();
        this.Adj = new LinkedList<>();
        this.TransAdj = new LinkedList<>();
        this.VerticeAdj = new LinkedList<>();
    }
    public Vertice(String v){
        super();
        this.nome = v;
        this.Adj = new LinkedList<>();
        this.TransAdj = new LinkedList<>();
    }
    
    public Vertice(String V, Integer d, Integer f){
        this.nome = V;
        this.d = d;
        this.f = f;
        this.Adj = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setAdj(Aresta e) {
        if(e!=null){
            this.Adj.add(e);
        }
    }
    
    public void clearAdj(){
       this.Adj.clear();
    }
    
    public void setAdj(LinkedList<Aresta> adj){
        this.Adj = adj;
    }
    
    public void setAdj(Aresta e, int i){
        if(this.Adj == null){
            this.Adj.add(e);
        }else{
            this.Adj.add(i, e);
        }
    }
    
    public void setAdj(Vertice v, int i){
        Aresta a = this.Adj.get(i);
        a.setDestino(v);
        this.Adj.set(i, a);
    }

    public LinkedList<Aresta> getAdj() {
        return Adj;
    }
    
    public Vertice getAdj(int i){
        Vertice v = this.Adj.get(i).getDestino();
        return v;
    }
    
    public Aresta getArestaAdj(int i){
        Aresta e = this.Adj.get(i);
        return e;
    }
    
    public Integer getD() {
        return d;
    }
    
    public int getSizeAdj(){
        int size = this.Adj.size();
        return size;
    }
    
    public void setD(Integer d) {
        this.d = d;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
        
    }
    
    public void setCor(String cor, int i) {
        this.cor = cor;
        for (int j = 0; j < getSizeAdj(); j++) {
                 Vertice v = getAdj(j);
                 v.setCor("branco");
                 setAdj(v, j);
        }
    }

    public Integer getF() {
        return f;
    }

    public void setTransAdj(Aresta e) {
        this.TransAdj.add(e);
    }
    
    public void setF(Integer f) {
        this.f = f;
    }
    
    public int getIdAresta(Aresta e){
        int i = this.Adj.indexOf(e);
        return i;
    }
    
    public void removeAresta(Aresta e){
        this.Adj.remove(e);    
    }
    
    public void removeAresta(int i){
        this.Adj.remove(i);
    }
    
    public void troca(){
        if(this.TransAdj!=null){
          this.Adj = this.TransAdj;
        }
        
    }
    
    public  Aresta getFirstAresta(){
        Aresta e = null; 
        if(!this.Adj.isEmpty()){
             e = this.Adj.getFirst();
        }
        return e;
    }
    
    public boolean EmptyAdj(){
        boolean vazio = true;
        if (!this.Adj.isEmpty()) {
            vazio = false;
        }
        return vazio;
    }
    
    public Aresta RemoveAresta(){
        Aresta a = null;
        if(!this.Adj.isEmpty()){
            a = this.Adj.getFirst();
            this.Adj.removeFirst();
        }
        return a;
    }
    
    public void RemoveAresta(Aresta f){
        if(!this.Adj.isEmpty()){
            this.Adj.remove(f);
        }
    }
    
    public int SizeAdj(){
        int size = this.Adj.size();
        return size;
    }

    public LinkedList<Aresta> getTransAdj() {
        return TransAdj;
    }

    public void setTransAdj(LinkedList<Aresta> TransAdj) {
        this.TransAdj = TransAdj;
    }

    public boolean isNoCiclo() {
        return noCiclo;
    }

    public void setNoCiclo(boolean noCiclo) {
        this.noCiclo = noCiclo;
    }

}
