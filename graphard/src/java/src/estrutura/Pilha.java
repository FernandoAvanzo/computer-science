/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class Pilha {
    private LinkedList<Vertice> pilha;

    public Pilha() {
        super();
        this.pilha = new LinkedList<>();
    }
   
    public Pilha(Vertice v) {
        super();
        this.pilha = new LinkedList<>();
        this.pilha.add(v);
    }
    
    public void push( Vertice v){  
        this.pilha.addLast(v);
    }
    
    public Vertice pop(){
        Vertice v = null;
        if (!this.pilha.isEmpty()){
            v = this.pilha.getLast();
            this.pilha.removeLast();
        }
        return v;
    }
    
    public boolean Empty(){
        boolean vazio = true;
        if (!this.pilha.isEmpty()) {
            vazio = false;
        }
        return vazio;
    }
}
