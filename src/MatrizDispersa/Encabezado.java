
package MatrizDispersa;

public class Encabezado {
    int fila;
    NodoFila columnas;
    Encabezado siguiente;
    Encabezado anterior;
    int indice;
    
    
    public Encabezado(){}
    
    public Encabezado(int _fila, int _columna, char _valor){
        this.fila = _fila;
        this.columnas = new NodoFila();
        this.columnas.insertar(_columna, _valor);
    }
    
    public Encabezado(int _fila){
        this.fila = _fila;
        this.columnas = new NodoFila();
    }
    
    
    public void insertar(int _fila, int _columna, char _valor){
        if(_fila > this.fila && this.siguiente == null){
            Encabezado nuevo = new Encabezado(_fila);
            this.siguiente = nuevo;
            nuevo.anterior = this;
            nuevo.columnas.insertar(_columna, _valor);
        }
        else if(_fila > this.fila && this.siguiente != null){
            this.siguiente.insertar(_fila, _columna, _valor);
        }
        else if(_fila < this.fila){
            Encabezado nuevo = new Encabezado(_fila);
            Encabezado aux = this.anterior;            
            aux.siguiente = nuevo;
            nuevo.anterior = aux;            
            this.anterior = nuevo;
            nuevo.siguiente = this;
            nuevo.columnas.insertar(_columna, _valor);
        }
        else if(_fila == this.fila){
            this.columnas.insertar(_columna, _valor);
        }
    }
    
    
    public String graficar(){
        String str = this.graficarNodos();
        str += "\t{rank = same; " + this.alinearGraph() + "}\n";
        return str;
    }
    
    private String alinearGraph(){
        String str = "node" + this.indice + " ";
        if(this.siguiente != null)
            str += this.siguiente.alinearGraph();
        return str;
    }
    
    private String graficarNodos(){
        this.indice = statics.indiceMatriz++;
        String str = "\tnode" + this.indice + "[label = \"" + this.fila + "\"];\n";
        str += this.columnas.graficarGrande(this.indice);
        if(this.siguiente != null){
            str += this.siguiente.graficarNodos();
            str += "\tnode" + this.indice + " -> node" + siguiente.indice + ";\n"; 
        }
        if(this.anterior != null){
            str += "\tnode" + this.indice + " -> node" + anterior.indice + ";\n"; 
        }
        return str;
    }
}
