package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.DadosResultado;
import br.com.alura.literalura.service.ConsumoAPI;
import br.com.alura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);

    private final String URL = "https://gutendex.com/books?search=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();



    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n
                    Menu
                    -----------------

                    1 - Busca de livro por título
                    2 - Listagem de todos os livros

                    0 - Sair
                    """;

            System.out.println(menu);
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscaLivroPorTitulo();
                    break;
                case 2:

                    break;
                case 0:
                    System.out.println("Até logo!");
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public DadosResultado buscaDadosLivro() {
        System.out.println("Digite o título do livro: ");
        var nomeLivro = scanner.nextLine();
        var json = consumoAPI.obterDados(URL + nomeLivro.replace(" ", "%20"));

        DadosResultado dados = converteDados.obterDados(json, DadosResultado.class);
        return dados;
    }

    public void buscaLivroPorTitulo() {
        DadosResultado dados = buscaDadosLivro();
        System.out.println(dados);
    }
}
