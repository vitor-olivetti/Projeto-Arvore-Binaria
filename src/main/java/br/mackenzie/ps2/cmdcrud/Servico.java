package br.mackenzie.ps2.cmdcrud;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="servicos")
public class Servico {
    @Id
    private long IdServico;
    private String endereco;
    private String horario;
    private int preco;
    public Servico() {}
    public Servico(long id, String e, String h, int p) {
        IdServico = id;
        endereco = e;
        horario = h;
        preco = p;
    }
    public long getIdServico() {
        return IdServico;
    }
    public void setIdServico(long IdServico) {
        this.IdServico = IdServico;
    }
    public String getEndereco() { return endereco; }
    public void setEndereco(String e) { endereco = e; }
    public String getHorario() { return horario; }
    public void setHorario(String h) { horario = h; }
    public int getPreco() { return preco; }
    public void setPreco(int p) { preco = p; }    
}
