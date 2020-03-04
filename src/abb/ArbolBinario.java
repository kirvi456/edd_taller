
package abb;

public class ArbolBinario {
    NodoAbb raiz;
    
    public ArbolBinario(Integer _raiz){
        this.raiz = new NodoAbb(_raiz);
    }
    
    public void insertar(Integer _valor){
        this.raiz.insertar(_valor);
    }
    
    public String graficar(){
        return this.raiz.graficar();
    }
    
    public void printInOrden(){
        this.raiz.printInOrder();
    }
    
    public void eliminar(Integer _valor){
        this.raiz = raiz.borrar(_valor);
    }
}
