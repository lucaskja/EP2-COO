package src;

import src.Enum.FormatoEnum;
import src.Relatorio.CarregadorDeProdutos;
import src.Relatorio.CarregadorDeProdutosCsv;
import src.Relatorio.GeradorDeRelatorios;

import java.io.IOException;

public class Main {
    public static void main(String [] args) {

        if(args.length < 5){
            System.out.println("Uso:");
            System.out.println("\t java " + Main.class.getName() + " <opção de leitura> <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
            System.out.println("Onde:");
            System.out.println("\t opção de leitura: 'padrao' ou 'csv'");
            System.out.println("\t algoritmo: 'quick' ou 'insertion'");
            System.out.println("\t criterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou 'descricao_d' ou 'estoque_d'");
            System.out.println("\t criterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'intervalo' ou 'substring'");
            System.out.println("\t parâmetro de filtragem: argumentos adicionais necessários para a filtragem");
            System.out.println("\t opções de formatação: 'negrito' e/ou 'italico'");
            System.out.println();
            System.exit(1);
        }

        String opcao_leitura = args[0];
        String opcao_algoritmo = args[1];
        String opcao_criterio_ord = args[2];
        String opcao_criterio_filtro = args[3];
        String opcao_parametro_filtro = args[4];

        String [] opcoes_formatacao = new String[2];
        opcoes_formatacao[0] = args.length > 5 ? args[5] : null;
        opcoes_formatacao[1] = args.length > 6 ? args[6] : null;
        int formato = FormatoEnum.FORMATO_PADRAO.getFormato();

        for (String op : opcoes_formatacao) {
            formato |= (op != null ? op.equals("negrito") ? FormatoEnum.FORMATO_NEGRITO.getFormato() : (op.equals("italico") ? FormatoEnum.FORMATO_ITALICO.getFormato() : 0) : 0);
        }
        try{
            GeradorDeRelatorios gdr = new GeradorDeRelatorios(
                    CarregadorDeProdutos.carregaProdutos(),
                    opcao_algoritmo,
                    opcao_criterio_ord,
                    opcao_criterio_filtro,
                    opcao_parametro_filtro,
                    formato
            );
            if (opcao_leitura.equals("padrao")){
                gdr.geraRelatorio("saida.html");
            } else{
                gdr.setProdutos(new CarregadorDeProdutosCsv().lerCsv("produtos.csv", gdr.getCores(), gdr.getNegrito(), gdr.getItalico()));
                gdr.geraRelatorioCsv("saida.html");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
