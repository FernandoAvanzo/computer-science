
package estrutura;

public class Aresta {
    private Vertice origem;
    private Vertice Destino;
    private boolean noCiclo = false;
    private Integer peso = 0;

    public Aresta(){
        super();
    }
    
    public Aresta( String v){
         super();
         setAresta(v);
    }
    
    private void setAresta(String v){
        int i = 0;
         while(' '!= v.charAt(i)){
             i++;
         }
         int j = i;
         int z=j+1;
         int y = 0;
         String pes = "";
         for (int k = 0; k < v.length(); k++) {
            if(' ' == v.charAt(k)){y +=1;}
         }
         if (y > 1) {
            while(j<v.length()){
             if(' ' == v.charAt(z) && z < v.length()){
                 j += 1;
                 break; 
             }
             z++;
             j++;
           } 
           pes = v.substring(y+2,v.length());
           this.peso = Integer.parseInt(pes);
        }else{
             while(j<v.length()){
             z++;
             j++;
           }
         }
         String u = v.substring(0,i);
         String vi = v.substring(i+1,j);
         this.origem = new Vertice(u);
         this.Destino = new Vertice(vi);
    }
    
    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return Destino; 
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public void setDestino(Vertice Destino) {
        this.Destino = Destino;
    }
    
    public void inverteAresta(){
        Vertice d = this.Destino;
        this.Destino = this.origem;
        this.origem = d;
    }

    public int getPeso() {
        return peso;
    }

    public boolean isNoCiclo() {
        return noCiclo;
    }

    public void setNoCiclo(boolean no) {
        this.noCiclo = no;
        //this.Destino.setNoCiclo(no);
        //this.origem.setNoCiclo(no);
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
    
    
    
    
    
}
    

