
package abb;


public class NodoAbb {
    private Integer valor;
    private NodoAbb hijoDer;
    private NodoAbb hijoIzq;
    private Integer indiceAux; //este solo sirve para graficar
    
    public NodoAbb(Integer _valor){
        this.valor = _valor;
    }
    
    private Integer getIndice(){
        return this.indiceAux;
    }
    
    private Integer getValor(){
        return this.valor;
    }
    
    private NodoAbb getHijoIzq(){
        return this.hijoIzq;
    }
    
    private void setHijoDer(NodoAbb _hijoDer){
        this.hijoDer = _hijoDer;
    }
    
    private void setHijoIzq(NodoAbb _hijoIzq){
        this.hijoIzq = _hijoIzq;
    }
    
    /////////////////////////////////////////////// SECCION DE INSERCION /////////////////////
    
    public void insertar (Integer _valor){
        if (_valor < valor) {
            if (hijoIzq != null) 
                hijoIzq.insertar(_valor);
            else
                hijoIzq = new NodoAbb(_valor);        
        } else {
           if (hijoDer != null) 
                hijoDer.insertar(_valor);
           else
                hijoDer = new NodoAbb(_valor); 
        }
    }

    //////////////////////////////////////////// SECCION PARA BUSCAR ////////////////////////////
    public NodoAbb buscar(Integer _valor) {
        if (_valor == valor) {
            return this;            
        } else if (_valor < valor) {
            if (this.hijoIzq != null) 
                return hijoIzq.buscar(_valor); 
        } else {
            if (hijoDer != null) 
                return hijoDer.buscar(_valor);
        }
        return null;
    }
    
    //////////////////////////////////////////// SECCION DE ELIMINACION /////////////////////////////////
    
    private NodoAbb extraerMasPequeño(){
        if( hijoIzq != null)
            return hijoIzq.extraerMasPequeño();
        return this;
    }
    
    private NodoAbb borrarMasPequeño(){
        if( hijoIzq != null ){
            hijoIzq = hijoIzq.borrarMasPequeño();
            return this;
        }
        return null;
    }
    
    public NodoAbb borrar(Integer _valor) {
        if (valor == _valor) {
            if(hijoIzq == null && hijoDer == null)
                return null;
            if(hijoIzq != null && hijoDer == null)
                return hijoIzq;
            if(hijoIzq == null && hijoDer != null)
                return hijoDer;
            if(hijoIzq != null && hijoDer != null){
                NodoAbb masPequeño = hijoDer.extraerMasPequeño();
                hijoDer = hijoDer.borrarMasPequeño();
                masPequeño.setHijoDer(hijoDer);
                masPequeño.setHijoIzq(hijoIzq);
                return masPequeño;
            }            
        } else if (_valor < valor) {
            if (this.hijoIzq != null) 
                hijoIzq = hijoIzq.borrar(_valor);
        } else {
            if (hijoDer != null) 
                hijoDer = hijoDer.borrar(_valor);
        }
        return this;
    }
    
    
    //////////////////////////////////////// IMPRESIONES DEL ARBOL ///////////////////////////////////
    
    
    public void printInOrder(){
        if(hijoIzq != null){
            hijoIzq.printInOrder();
        }
        System.out.println(valor);
        if(hijoDer != null){
            hijoDer.printInOrder();
        }
    }
    
    
    ///////////////////////////////////// SECCION DE GRAFICAR ////////////////////////////////////////
    
    
    private void setIndicesManager(){
        statics.indiceAbb = 1;
        this.setIndices();
    }    
    
    private void setIndices(){
        this.indiceAux = statics.indiceAbb++;
        if(hijoIzq != null)
            hijoIzq.setIndices();
        if(hijoDer != null)
            hijoDer.setIndices();
    }
    
    private String escribirNodo(){
        String str = "\tnode" + indiceAux + "[label = \"<f0> | <f1> " + this.valor + "| <f2> \"];\n";
        if(hijoIzq != null){
            str += hijoIzq.escribirNodo();
            str += "\tnode" + this.indiceAux + ":f0 -> node" + hijoIzq.getIndice()+ ";\n"; 
        }
        if(hijoDer != null){
            str += hijoDer.escribirNodo();
            str += "\tnode" + this.indiceAux + ":f2 -> node" + hijoDer.getIndice()+ ";\n"; 
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
