package AVLArbol;

class AVLNodo { 
    int valor;     
    int peso; 
    int indiceAux;
    AVLNodo hijoIzq;
    AVLNodo hijoDer; 
  
    AVLNodo(int _valor) { 
        valor   = _valor; 
        peso    = 1; 
    } 
    
    
  ///////////////////////////////////// SECCION DE GRAFICAR ////////////////////////////////////////
    
    
    private void setIndicesManager(){
        abb.statics.indiceAbb = 1;
        this.setIndices();
    }    
    
    private void setIndices(){
        this.indiceAux = abb.statics.indiceAbb++;
        if(hijoIzq != null)
            hijoIzq.setIndices();
        if(hijoDer != null)
            hijoDer.setIndices();
    }
    
    private String escribirNodo(){
        String str = "\tnode" + indiceAux + "[label = \"<f0> | <f1> " + this.valor + "| <f2> \"];\n";
        if(hijoIzq != null){
            str += hijoIzq.escribirNodo();
            str += "\tnode" + this.indiceAux + ":f0 -> node" + hijoIzq.indiceAux + ";\n"; 
        }
        if(hijoDer != null){
            str += hijoDer.escribirNodo();
            str += "\tnode" + this.indiceAux + ":f2 -> node" + hijoDer.indiceAux + ";\n"; 
        }
        return str;
    }
    
    public String graficar(){
        this.setIndicesManager();
        String str  = "digraph G{\n";
        str += "\tnode [fontsize = \"16\" shape = \"record\" fillcolor = turquoise3 style = filled ];\n";
        str += this.escribirNodo();
        str += "}\n";
        return str;
    }
} 
