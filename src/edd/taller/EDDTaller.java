
package edd.taller;

import abb.ArbolBinario;
import abb.NodoAbb;

public class EDDTaller {

    public static void main(String[] args) {
        ArbolBinario nodo = new ArbolBinario(20);
        nodo.insertar(15);
        nodo.insertar(25);
        nodo.insertar(10);
        nodo.insertar(18);
        nodo.insertar(12);
        nodo.insertar(17);
        nodo.insertar(19);
        nodo.insertar(16);
        
        //nodo.eliminar(15);
        System.out.println(nodo.graficar());
    }
    
}
