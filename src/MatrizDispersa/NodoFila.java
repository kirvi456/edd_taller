
package MatrizDispersa;

public class NodoFila {
    NodoMatriz primero;
    
    
    public NodoFila(){
        
    }
    
    public void insertar(int _columna, char _valor){
        if(primero == null)
            primero = new NodoMatriz(_columna, _valor);
        primero.insertar(_columna, _valor);
    }
    
    public String graficar(){
        return primero.graficar();
    }
    
    public String graficarGrande(int _fila){
        return primero.graficarGrande(_fila);
    }
}
