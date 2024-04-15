package br.com.alura.tabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnosModelos(String nome, String codigo) {
}
