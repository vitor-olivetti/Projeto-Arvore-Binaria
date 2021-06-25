package br.mackenzie.ps2.cmdcrud;


public class Arvore {
    private Elemento ele;
    private Arvore dir;
    private Arvore esq;

    public Arvore(){
        this.ele = null;
        this.dir = null;
        this.esq = null;
    }

    public Arvore(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
    }

    // GETS E SETS
    public void setElemento(Elemento ele){this.ele = ele;}

    public void setNoDireita(Arvore dir){this.dir = dir;}

    public void setNoEsquerda(Arvore esq){this.esq = esq;}

    public Elemento getElemento(){return this.ele;}

    public Arvore getNoDireita(){return this.dir;}

    public Arvore getNoEsquerda(){return this.esq;}

    // CONTROLE
    public boolean isEmpty(){
        return (this.ele == null);
    }

    public int getAltura(Elemento ele){
        return getAltura(this.ele);
    }
    
    public int getQtdElemento(Elemento ele){
        return getQtdElemento(ele);
    }
    

    public void inserir(Elemento ele, long id) {
        if(this.ele == null){
            this.ele = new Elemento(id);
        } else {
            if (id < ele.getIdServico()) {
                if (ele.getNoEsquerda() != null) { 
                    inserir(ele.getNoEsquerda(), id); 
                } else { 
                    ele.setNoEsquerda(new Elemento(id)); 
                }  
            } else if (id > ele.getIdServico()) { 
                if (ele.getNoDireita() != null) { 
                    inserir(ele.getNoDireita(), id); 
                } else {
                    ele.setNoDireita(new Elemento(id)); 
                } 
            }
        }
    }
    
    public Elemento remover(long id) {
        return remover(this.ele, id);
    }
    
    private Elemento remover(Elemento ele, Long id){
        if(isEmpty()){
            System.out.println("");
            return null;
        } else {            
            if(id < ele.getIdServico()){
                ele.setNoEsquerda(remover(ele.getNoEsquerda(), id));
            } else if(id > ele.getIdServico()){
                ele.setNoDireita(remover(ele.getNoDireita(), id));
            } else if (ele.getNoEsquerda() != null && ele.getNoDireita() != null) { 
                System.out.println("  Removeu No " + ele.getIdServico());
                ele.setIdServico(encontraMinimo(ele.getNoDireita()).getIdServico());
                ele.setNoDireita(removeMinimo(ele.getNoDireita()));
            } else {  
                System.out.println("  Removeu No " + ele.getIdServico());  
                ele = (ele.getNoEsquerda() != null) ? ele.getNoEsquerda() : ele.getNoDireita();  
            }  
            return ele;
        }
    }
    
    private Elemento removeMinimo(Elemento ele) {  
        if (ele == null) {  
            System.out.println("  ERRO ");  
        } else if (ele.getNoEsquerda() != null) {  
            ele.setNoEsquerda(removeMinimo(ele.getNoEsquerda()));  
            return ele;  
        } else {  
            return ele.getNoDireita();  
        }  
        return null;  
    }  
  
    private Elemento encontraMinimo(Elemento ele) {  
        if (ele != null) {  
            while (ele.getNoEsquerda() != null) {  
                ele = ele.getNoEsquerda();  
            }  
        }  
        return ele;  
    }
}
