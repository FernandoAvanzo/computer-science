/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Aresta;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class comparetorAresta implements Comparator<Aresta> {

    @Override
    public int compare(Aresta o1, Aresta o2) {
        int peso = 0;
        if (o1.getPeso() < o2.getPeso()){
            peso = -1;
        }
         if(o1.getPeso() > o2.getPeso())
         {
             peso = 1;
         }
         
         if(o1.getPeso() == o2.getPeso()){
             peso = 0;
         }
        return peso;
        
    }
    
    
    
    
}
