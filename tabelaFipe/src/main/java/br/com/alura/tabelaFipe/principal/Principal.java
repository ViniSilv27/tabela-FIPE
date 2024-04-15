package br.com.alura.tabelaFipe.principal;

import br.com.alura.tabelaFipe.model.Marcas;
import br.com.alura.tabelaFipe.model.VeiculoDados;
import br.com.alura.tabelaFipe.records.AnosModelos;
import br.com.alura.tabelaFipe.records.Dados;
import br.com.alura.tabelaFipe.records.Modelos;
import br.com.alura.tabelaFipe.records.Veiculo;
import br.com.alura.tabelaFipe.service.ConsumoApi;
import br.com.alura.tabelaFipe.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import static java.util.Comparator.*;
public class Principal {
    Scanner scanner = new Scanner(System.in);
    ConsumoApi consumo = new ConsumoApi();

    ConverteDados conversor = new ConverteDados();
    private String veiculo;
    private String mensagem = """
            TABELA FIPE: 
            
            
            Escolha entre as opções: 
                1- Carros
                2- Caminhões
                3- Motos
                Digite um número ou digete uma opção:
            """;

    private String endereco;
    private String chave = "https://parallelum.com.br/fipe/api/v1/";
    private String marcas = "/marcas";


    public void exibeMenu(){
        System.out.println(mensagem);
        String opcao = scanner.nextLine();
        veiculo =opcao.toLowerCase();
        if (veiculo.contains("carr") || veiculo.contains("1")){
            veiculo = "carros";
        } else if (veiculo.contains("cami") || veiculo.contains("2")){
            veiculo = "caminhoes";
        } else if (veiculo.contains("mot") || veiculo.contains("3")){
            veiculo = "motos";
        } else {
            System.out.println("opção não encontrada, tente denovo");
        }

        endereco = chave + veiculo + "/marcas";

        // Codigo referente a lista de Marcas
        var json = consumo.obterJson(endereco);
        var marcas = conversor.obterLista(json, Dados.class);
        System.out.println(marcas);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .map(d-> new Marcas(d.codigo(), d.nome()))
                .forEach(System.out::println);

        // Codigo referente a lista de Modelos
        System.out.println("""
                        
                        Agora digite o codigo referente a marca:
                        
                        """ );
        opcao = scanner.nextLine();
        veiculo = opcao.toLowerCase();
        endereco = endereco + "/" + veiculo + "/modelos";
        json = consumo.obterJson(endereco);
        var modelos = conversor.obterDados(json, Modelos.class);


        List<Dados> modelosFiltrados = modelos.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                        .collect(Collectors.toList());
        modelosFiltrados.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .map(d-> new Marcas(d.codigo(),d.nome()))
                .forEach(System.out::println);


        System.out.println("""
                
                Agora digite o codigo referente ao modelo escolhido: 
                
                """);

        opcao = scanner.nextLine();
        veiculo = opcao.toLowerCase();
        endereco = endereco + "/" + veiculo + "/anos";
        json = consumo.obterJson(endereco);
        var anos = conversor.obterLista(json, AnosModelos.class);
        List<String> enderecos = new ArrayList<>();
        json = consumo.obterJson(endereco + "/2019-1");

        List<String> anosFiltrados = anos.stream()
                .sorted(Comparator.comparing(AnosModelos::codigo))
                .map(AnosModelos::codigo)
                .collect(Collectors.toList());
        for (int i = 0; i < anosFiltrados.size(); i++) {
            String enderecoLoop = endereco;
            enderecoLoop = endereco + "/" + anosFiltrados.get(i);
            json = consumo.obterJson(enderecoLoop);
            var dadosVeiculo = conversor.obterDados(json, Veiculo.class);
            VeiculoDados dados = new VeiculoDados(dadosVeiculo.Valor(), dadosVeiculo.AnoModelo(), dadosVeiculo.Marca(), dadosVeiculo.Modelo(), dadosVeiculo.Combustivel(), dadosVeiculo.MesReferencia());
            System.out.println(dados);
        }

    }
}
