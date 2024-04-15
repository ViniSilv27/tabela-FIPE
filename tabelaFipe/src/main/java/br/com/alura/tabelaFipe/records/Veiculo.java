package br.com.alura.tabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(String Valor, String Marca, String Modelo, Integer AnoModelo, String Combustivel, String MesReferencia) {
}
