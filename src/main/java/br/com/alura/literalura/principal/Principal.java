package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.DadosResultado;
import br.com.alura.literalura.model.Idioma;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoAPI;
import br.com.alura.literalura.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);

    private final String URL = "https://gutendex.com/books?search=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();

    private List<Livro> livros = new ArrayList<>();

    @Autowired
    private LivroRepository repositorio;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n
                    Menu
                    -----------------

                    1 - Busca de livro por título
                    2 - Listagem de todos os livros
                    3 - Listagem com base no idioma
                    4 - Listagem de todos os autores

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
                    listagemDeTodosOsLivros();
                    break;
                case 3:
                    listagemPorIdioma();
                    break;
                case 4:
                    listagemDeTodosOsAutores();
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
        Livro livro = new Livro(dados.resultado().get(0));
        //livros.add(livro);

        repositorio.save(livro);
        var autor = livro.getAutor().get(0).getNome();
        System.out.println("\n");
        System.out.println("-----------------------------------------------");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + autor);
        System.out.println("Idioma: " + livro.getIdioma());
        System.out.println("Downloads: " + livro.getNumeroDownloads());
        System.out.println("-----------------------------------------------");
    }

    public void listagemDeTodosOsLivros() {
        System.out.println("Lista de livros");
        System.out.println("--------------------------------");

        repositorio.findAll().forEach(l ->
                        System.out.println(
                                "\n------------------------------------------" +
                                "\nTítulo: " + l.getTitulo() + "\n" +
                                "Autor: " + l.getAutor().get(0).getNome() + "\n" +
                                "Idioma: " + l.getIdioma() + "\n" +
                                "Downloads: " + l.getNumeroDownloads() +
                                "\n------------------------------------------"
                                )
                );
    }

    public void listagemPorIdioma() {
        System.out.println("Escolha o idioma: ");
        var idioma = scanner.nextLine();
        List<Livro> livroIdioma = repositorio.findByIdioma(idioma);
        livroIdioma.forEach(l ->
                System.out.println(
                        "\n------------------------------------------" +
                                "\nTítulo: " + l.getTitulo() + "\n" +
                                "Autor: " + l.getAutor().get(0).getNome() + "\n" +
                                "Idioma: " + l.getIdioma() + "\n" +
                                "Downloads: " + l.getNumeroDownloads() +
                                "\n------------------------------------------"
                )
        );
    }

    public void listagemDeTodosOsAutores() {
        System.out.println("Lista de autores");
        System.out.println("--------------------------------");
        repositorio.findAll().forEach(l -> l.getAutor().forEach(a -> System.out.println("\n" + a.getNome())));
    }
}
