package src.Relatorio;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

import src.Filtro.Filtragem;
import src.Formatacao.AplicadorFormatacao;
import src.Ordenacao.OrdenaProdutos;
import src.Produto.Produto;
import src.Enum.FormatoEnum;
import src.Produto.ProdutoPadrao;

public class GeradorDeRelatorios {
	private final ArrayList<Produto> produtos;
	private final String algoritmo;
	private final String criterio;
	private final String filtro;
	private final String argFiltro;
	private final int format_flags;

	public GeradorDeRelatorios(ArrayList<Produto> produtos, String algoritmo, String criterio, String filtro, String argFiltro, int format_flags){

		this.produtos = (ArrayList<Produto>)produtos.clone();
		this.algoritmo = algoritmo;
		this.criterio = criterio;
		this.format_flags = format_flags;
		this.filtro = filtro;
		this.argFiltro = argFiltro;
	}

	public void debug(){
		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'"); 
	}

	public void geraRelatorio(String arquivoSaida) throws IOException {

		debug();

		new OrdenaProdutos(this.algoritmo, this.produtos, this.criterio);

		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for (Produto p : produtos) {

			boolean selecionado = Filtragem.filtrar(p, this.filtro, this.argFiltro);

			if (selecionado) {
				out.print("<li>");
				out.print(AplicadorFormatacao.saidaFormatacao(this.format_flags, p.formataParaImpressao()));
				out.println("</li>");
				count++;
			}
		}

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public static ArrayList<Produto> carregaProdutos(){
		ArrayList<Produto> novosProdutos = new ArrayList<>();
		novosProdutos.add(new ProdutoPadrao(1, "O Hobbit", "Livros", 2, 34.90));
		novosProdutos.add(new ProdutoPadrao(2, "Notebook Core i7", "Informatica", 5, 1999.90));
		novosProdutos.add(new ProdutoPadrao(3, "Resident Evil 4", "Games", 7, 79.90));
		novosProdutos.add(new ProdutoPadrao(4, "iPhone", "Telefonia", 8, 4999.90));
		novosProdutos.add(new ProdutoPadrao(5, "Calculo I", "Livros", 20, 55.00));
		novosProdutos.add(new ProdutoPadrao(6, "Power Glove", "Games", 3, 499.90));
		novosProdutos.add(new ProdutoPadrao(7, "Microsoft HoloLens", "Informatica", 1, 19900.00));
		novosProdutos.add(new ProdutoPadrao(8, "OpenGL Programming Guide", "Livros", 4, 89.90));
		novosProdutos.add(new ProdutoPadrao(9, "Vectrex", "Games", 1, 799.90));
		novosProdutos.add(new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90));
		novosProdutos.add(new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00));
		novosProdutos.add(new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00));
		novosProdutos.add(new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00));
		novosProdutos.add(new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99));
		novosProdutos.add(new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00));
		novosProdutos.add(new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00));
		novosProdutos.add(new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0));
		novosProdutos.add(new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90));
		novosProdutos.add(new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90));
		novosProdutos.add(new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90));
		novosProdutos.add(new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90));
		novosProdutos.add(new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00));
		novosProdutos.add(new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00));
		novosProdutos.add(new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90));
		novosProdutos.add(new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00));
		novosProdutos.add(new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90));
		novosProdutos.add(new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00));
		novosProdutos.add(new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00));
		novosProdutos.add(new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00));
		novosProdutos.add(new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00));
		novosProdutos.add(new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00));
		novosProdutos.add(new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00));
		return novosProdutos;
	} 

	public static void main(String [] args) {

		if(args.length < 4){

			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c'");
			System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual'"); 
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem"); 
			System.out.println("\topções de formatação: 'negrito' e/ou 'italico'");
			System.out.println();
			System.exit(1);
		}

		String opcao_algoritmo = args[0];
		String opcao_criterio_ord = args[1];
		String opcao_criterio_filtro = args[2];
		String opcao_parametro_filtro = args[3];
		
		String [] opcoes_formatacao = new String[2];
		opcoes_formatacao[0] = args.length > 4 ? args[4] : null;
		opcoes_formatacao[1] = args.length > 5 ? args[5] : null;
		int formato = FormatoEnum.FORMATO_PADRAO.getFormato();

		for (String op : opcoes_formatacao) {
			formato |= (op != null ? op.equals("negrito") ? FormatoEnum.FORMATO_NEGRITO.getFormato() : (op.equals("italico") ? FormatoEnum.FORMATO_ITALICO.getFormato() : 0) : 0);
		}
		
		GeradorDeRelatorios gdr = new GeradorDeRelatorios(	carregaProdutos(), 
									opcao_algoritmo,
									opcao_criterio_ord,
									opcao_criterio_filtro,
									opcao_parametro_filtro,
									formato 
								 );

		try{
			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}
