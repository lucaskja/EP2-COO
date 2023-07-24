package src.Relatorio;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

import src.Filtro.Filtragem;
import src.Formatacao.AplicadorFormatacao;
import src.Ordenacao.OrdenaProdutos;
import src.Produto.Produto;
import src.Enum.FormatoEnum;

public class GeradorDeRelatorios {
	private ArrayList<Produto> produtos;
	private final String algoritmo;
	private final String criterio;
	private final String filtro;
	private final String argFiltro;
	private final int format_flags;
	private final ArrayList<String> cores;
	private final ArrayList<Boolean> negrito;
	private final ArrayList<Boolean> italico;

	public GeradorDeRelatorios(
			ArrayList<Produto> produtos,
			String algoritmo,
			String criterio,
			String filtro,
			String argFiltro,
			int format_flags
	){
		this.produtos = (ArrayList<Produto>)produtos.clone();
		this.algoritmo = algoritmo;
		this.criterio = criterio;
		this.format_flags = format_flags;
		this.filtro = filtro;
		this.argFiltro = argFiltro;
		this.cores = new ArrayList<>();
		this.negrito = new ArrayList<>();
		this.italico = new ArrayList<>();
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

	public void geraRelatorioCsv(String arquivoSaida) throws IOException {

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
				out.print(
					AplicadorFormatacao.saidaFormatacaoCsv(
							p.formataParaImpressao(),
							this.negrito.get(count),
							this.italico.get(count),
							this.cores.get(count)
					)
				);
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

		GeradorDeRelatorios gdr = new GeradorDeRelatorios(
				CarregadorDeProdutos.carregaProdutos(),
				opcao_algoritmo,
				opcao_criterio_ord,
				opcao_criterio_filtro,
				opcao_parametro_filtro,
				formato
			);
		gdr.produtos = new CarregadorDeProdutosCsv().lerCsv("produtos.csv", gdr.cores, gdr.negrito, gdr.italico);
		try{
			gdr.geraRelatorioCsv("saida.html");
//			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}
