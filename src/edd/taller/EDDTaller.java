
package edd.taller;

import AVLArbol.ArbolAVL;
import MatrizDispersa.Encabezado;
import MatrizDispersa.Matriz;
import MatrizDispersa.NodoMatriz;
import abb.ArbolBinario;
import abb.NodoAbb;

public class EDDTaller {

    public static void main(String[] args) {
        /*
        ArbolBinario nodo = new ArbolBinario(10);
        nodo.insertar(20);
        nodo.insertar(30);
        nodo.insertar(40);
        nodo.insertar(50);
        nodo.insertar(25);
        
        //nodo.eliminar(15);
        System.out.println(nodo.graficar());
        
        
        
        
        ArbolAVL arbol2 = new ArbolAVL(); 
        arbol2.insertar(10);
        arbol2.insertar(20);
        arbol2.insertar(30);
        arbol2.insertar(40);
        arbol2.insertar(50);
        arbol2.insertar(25);
        System.out.println(arbol2.graficar());
        
        
        
        //matriz
        NodoMatriz lista1 = new NodoMatriz(2,'s');
        lista1.insertar(4, 'p');
        lista1.insertar(5, 'o');
        lista1.insertar(3, 'a');
        lista1.insertar(6, 'n');
        System.out.println(lista1.graficar());
        
        
        */
        
        Matriz enc = new Matriz(6);
        
        enc.insertar(2, 3, 's');
        enc.insertar(2, 5, 'p');
        
        enc.insertar(3, 3, 'p');
        enc.insertar(3, 5, 'n');
        System.out.println(enc.graficar());
    }
    
}
