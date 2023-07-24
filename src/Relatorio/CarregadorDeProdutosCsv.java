package src.Relatorio;

import src.Produto.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarregadorDeProdutosCsv {
    public ArrayList<Produto> lerCsv(String nomeDoArquivo, ArrayList<String> cores, ArrayList<Boolean> negrito, ArrayList<Boolean> italico) {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            String linha = "";
            String divisor = ",";
            BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo));

            br.readLine();

            LerProdutosCsv lerCsv = new LerProdutoPadraoCsv();

            while ((linha = br.readLine()) != null) {
                String[] produto = linha.split(divisor);
                produtos.add(lerCsv.ler(produto));
                negrito.add(Boolean.parseBoolean(produto[5].trim()));
                italico.add(Boolean.parseBoolean(produto[6].trim()));
                cores.add(produto[7].trim());
            }
            System.out.println(cores.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
