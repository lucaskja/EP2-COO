package src.Relatorio;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

import src.Filtro.Filtragem;
import src.Formatacao.AplicadorFormatacao;
import src.Ordenacao.OrdenaProdutos;
import src.Produto.Produto;

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

	public ArrayList<String> getCores() {
		return cores;
	}

	public ArrayList<Boolean> getNegrito() {
		return negrito;
	}

	public ArrayList<Boolean> getItalico() {
		return italico;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

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
}
