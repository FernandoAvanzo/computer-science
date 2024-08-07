/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Vertice;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class comparetorVertice implements Comparator<Vertice> {

    @Override
    public int compare(Vertice o1, Vertice o2) {
        int peso = 0;
        if (o1.getF() < o2.getF()){
            peso = -1;
        }
         if(o1.getF() > o2.getF())
         {
             peso = 1;
         }
         
         if(o1.getF() == o2.getF()){
             peso = 0;
         }
        return peso;
    }
    
}
