package br.com.alura.tabelaFipe.model;

public class Marcas {
    private String nome;
    private Integer codigo;

    public Marcas(Integer codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("""
                
                Código: %d   Descrição: %s""", getCodigo(), getNome());
    }
}

