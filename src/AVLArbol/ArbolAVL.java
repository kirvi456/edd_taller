
package AVLArbol;


public class ArbolAVL {
    AVLNodo root; 
  
    public int peso(AVLNodo N) { 
        if (N == null) 
            return 0;   
        return N.peso; 
    } 
  
    //Funcion que devuelve el numero maximo 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    //Funcion para rotar a la derecha
    private AVLNodo rightRotate(AVLNodo y) { 
        AVLNodo x   = y.hijoIzq; 
        AVLNodo T2  = x.hijoDer;   
        
        x.hijoDer = y; 
        y.hijoIzq = T2; 
        
        y.peso = max(peso(y.hijoIzq), peso(y.hijoDer)) + 1; 
        x.peso = max(peso(x.hijoIzq), peso(x.hijoDer)) + 1; 
        return x; 
    } 
  

    //Funcion para rotar a la izquierda
    AVLNodo leftRotate(AVLNodo x) { 
        AVLNodo y = x.hijoDer; 
        AVLNodo T2 = y.hijoIzq; 

        y.hijoIzq = x; 
        x.hijoDer = T2; 
  
        x.peso = max(peso(x.hijoIzq), peso(x.hijoDer)) + 1; 
        y.peso = max(peso(y.hijoIzq), peso(y.hijoDer)) + 1; 
        return y; 
    } 
  
    //Devolver el balance del arbol
    int getBalance(AVLNodo N) { 
        if (N == null) 
            return 0;   
        return peso(N.hijoIzq) - peso(N.hijoDer); 
    } 
  
    private AVLNodo insertar(AVLNodo nodo, int _valor) { 
  
        if (nodo == null) 
            return (new AVLNodo(_valor));   
        if (_valor < nodo.valor) 
            nodo.hijoIzq = insertar(nodo.hijoIzq, _valor); 
        else if (_valor > nodo.valor) 
            nodo.hijoDer = insertar(nodo.hijoDer, _valor); 
        else 
            return nodo; 
  
        // Actualizar el peso del nodo padre
        nodo.peso = 1 + max(peso(nodo.hijoIzq), peso(nodo.hijoDer)); 
  
        //Obtener el factor de balance para verificar si necesita arreglarse
        int balance = getBalance(nodo); 
  
        // Si es necesario el balance
        if (balance > 1 && _valor < nodo.hijoIzq.valor) 
            return rightRotate(nodo); 
  
        
        if (balance < -1 && _valor > nodo.hijoDer.valor) 
            return leftRotate(nodo); 
  
        if (balance > 1 && _valor > nodo.hijoIzq.valor) { 
            nodo.hijoIzq = leftRotate(nodo.hijoIzq); 
            return rightRotate(nodo); 
        } 
  
        if (balance < -1 && _valor < nodo.hijoDer.valor) { 
            nodo.hijoDer = rightRotate(nodo.hijoDer); 
            return leftRotate(nodo); 
        } 
  
        return nodo; 
    } 
  
    void preOrder(AVLNodo node) { 
        if (node != null) { 
            System.out.print(node.valor + " "); 
            preOrder(node.hijoIzq); 
            preOrder(node.hijoDer); 
        } 
    } 
  
    public void insertar(int _valor) {  
        this.root = this.insertar(this.root, _valor);   
    } 
    
    public String graficar(){
        return this.root.graficar();
    }
}
