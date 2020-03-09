
package MatrizDispersa;

public class NodoMatriz {
    int columna;
    char valor;
    NodoMatriz siguiente;
    NodoMatriz anterior;
    int indice;
    
    public NodoMatriz(int _columna, char _valor){
        this.valor      = _valor;
        this.columna    = _columna;
    }
    
    
    public void insertar(int _columna, char _valor){
        if(_columna > this.columna && this.siguiente == null){
            NodoMatriz nuevo = new NodoMatriz(_columna, _valor);
            this.siguiente = nuevo;
            nuevo.anterior = this;
        }
        else if(_columna > this.columna && this.siguiente != null){
            this.siguiente.insertar(_columna, _valor);
        }
        else if(_columna < this.columna){
            NodoMatriz nuevo = new NodoMatriz(_columna, _valor);
            NodoMatriz aux = this.anterior;            
            aux.siguiente = nuevo;
            nuevo.anterior = aux;            
            this.anterior = nuevo;
            nuevo.siguiente = this;
        }
    }
    
    public String graficarGrande(int _fila){
        String str = this.graficar();
        str += "\tnode" + _fila + " -> node" + this.indice + ";\n";
        return str;
    }
    
    
    public String graficar(){
        this.indice = statics.indiceMatriz++;
        String str = "\tnode" + this.indice + "[label = \"" + this.valor + " \"];\n";
        if(this.siguiente != null){
            str += this.siguiente.graficar();
            str += "\tnode" + this.indice + " -> node" + siguiente.indice + ";\n"; 
        }
        if(this.anterior != null){
            str += "\tnode" + this.indice + " -> node" + anterior.indice + ";\n"; 
        }
        return str;
    }
}
