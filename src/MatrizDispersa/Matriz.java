
package MatrizDispersa;


public class Matriz {
    int noFilas;
    int noColumnas;
    Encabezado encabezado;
    
    
    
    public Matriz(int tamaño){
        this.noFilas = tamaño;
        this.noColumnas = tamaño;
    }
    
    public void insertar(int _fila, int _columna, char _valor){
        if(_fila >= this.noFilas || _columna >= this.noColumnas){
            System.out.println("No se puede insertar.");
        } 
        
        if(encabezado == null)
            this.encabezado = new Encabezado(_fila, _columna, _valor);
        else
            this.encabezado.insertar(_fila, _columna, _valor);
    }
    
    public String graficar(){
        String str = "digraph G{\n";
        str += "\trankdir = LR;\n";
        str += "\tnode [fontsize = \"16\" shape = \"record\" fillcolor = turquoise3 style = filled  ];\n";        
        str += this.encabezado.graficar();        
        str += "}";
        return str;
    }

}
