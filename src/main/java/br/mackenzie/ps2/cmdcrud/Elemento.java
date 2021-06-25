package br.mackenzie.ps2.cmdcrud;

public class Elemento {
    private long id;
    private Elemento noEsquerda;
    private Elemento noDireita;  
    public Elemento() { }

   public Elemento(Long id) {
        super();
        this.id = id;
    }

    // GETS E SETS
    public long getIdServico() {
        return id;
    }
    public void setIdServico(long id) {
        this.id = id;
    }
    
    public Elemento getNoEsquerda() {
       return noEsquerda;
    }
    public void setNoEsquerda(Elemento noEsquerda) {
        this.noEsquerda = noEsquerda;
    }
    public Elemento getNoDireita() {
        return noDireita;
    }
    public void setNoDireita(Elemento noDireita) {
        this.noDireita = noDireita;
    }
}