/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

import estrutura.Vertice;

/**
 *
 * @author Incubadora2
 */
public class BfsSaida {
    private String origem;
    private String acessa;
    private int Distancia;
    
    public BfsSaida(){
        super();
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setAcessa(String acessa) {
        this.acessa = acessa;
    }

    public void setDistancia(int Distancia) {
        this.Distancia = Distancia;
    }

    public String getOrigem() {
        return origem;
    }

    public String getAcessa() {
        return acessa;
    }

    public int getDistancia() {
        return Distancia;
    }
    
    
}
