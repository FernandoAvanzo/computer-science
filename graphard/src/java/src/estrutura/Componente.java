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
public class Componente {
    private LinkedList<Vertice> itenComponent;

    public Componente() {
        super();
        this.itenComponent = new LinkedList<>();
    }
    
    public void addIten(Vertice v){
        if(this.itenComponent == null){
            this.itenComponent.add(v);
        }else{
           this.itenComponent.addFirst(v);
        }
    }
    
    public int componentSize(){
        int size = this.itenComponent.size();
        return size;
    }
    
    public Vertice getIten(int i){
        Vertice v = null;
        if(i != -1){
            v = this.itenComponent.get(i);
        }
        return v;
    }
    
    public Boolean EmpetyComponent(){
        return this.itenComponent.isEmpty();
    }
    
    public void ClearComponent(){
        this.itenComponent.clear();
    }
    
}
