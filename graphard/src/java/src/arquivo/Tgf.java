/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivo;

import estrutura.Aresta;
import estrutura.Grafo;
import estrutura.Vertice;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class Tgf {

    private File tgfFile;
    private ArrayList<String> tgf;
    private ArrayList<Vertice> vertices;
    private Map<String,Vertice> mapVertice;
    private Grafo G;

    public Tgf(String path) {
        super();
        this.vertices = new ArrayList<>();
        this.mapVertice = new HashMap<>();
        setTgfFile(path);
        geraGrafo();
        this.G = new Grafo(this.vertices);
    }
    
    private void geraGrafo() {
        String marca = "";
        for (int j = 0; j < this.tgf.size(); j++) {
            if(!"#".equals(marca)){
                marca = this.tgf.get(j);
                if(!"#".equals(marca)){
                    Vertice v = new Vertice(this.tgf.get(j));
                    this.mapVertice.put(this.tgf.get(j), v);
                    this.vertices.add(this.mapVertice.get(this.tgf.get(j)));
                }
             }else{
                    String[] tokens = this.tgf.get(j).split(" ");
                    Vertice origem = this.mapVertice.get(tokens[0]);
                    Vertice destino = this.mapVertice.get(tokens[1]);
                    Aresta e = new Aresta();
                    if(tokens.length > 2){
                        Integer peso = Integer.parseInt(tokens[3]);
                        e.setPeso(peso);  
                    }
                    e.setOrigem(origem);
                    e.setDestino(destino);
                    origem.setAdj(e);
             }
        }
    }
    
    private void setTgfFile(String path) {
        @SuppressWarnings("CollectionWithoutInitialCapacity")
        ArrayList<String> xfile = new ArrayList<>();
        try {
          this.tgfFile =  new File(path);
            try {
              Scanner file =  new Scanner(this.tgfFile); 
              int i = 0;
              while (true) {
                    xfile.add(i, file.nextLine());
                    i++;
                }
             } catch (Exception e) {
             }
        } catch (Exception e) {
        }
        this.tgf = xfile;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    
    
    public Grafo getG() {
        return G;
    }
     
     
}
