package br.com.alura.tabelaFipe.model;

public class VeiculoDados {
    private String valor;
    private String marca;
    private String modelo;
    private Integer ano;
    private String combustivel;
    private String mesReferenciar;

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getMesReferenciar() {
        return mesReferenciar;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setMesReferenciar(String mesReferenciar) {
        this.mesReferenciar = mesReferenciar;
    }

    public VeiculoDados(String valor, Integer ano, String marca, String modelo, String combustivel, String mesReferenciar){
        this.ano = ano;
        this.marca = marca;
        this.valor =valor;
        this.combustivel =combustivel;
        this.mesReferenciar = mesReferenciar;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("""
Marca: %s  Modelo: %s  Valor: %s  Combustivel: %s  Ano: %d  Mês de Referencia: %s
""", getMarca(), getModelo(), getValor(), getCombustivel(), getAno(), getMesReferenciar());
    }
}
