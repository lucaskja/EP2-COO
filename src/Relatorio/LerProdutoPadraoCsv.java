package src.Relatorio;

import src.Produto.Produto;
import src.Produto.ProdutoPadrao;

public class LerProdutoPadraoCsv implements LerProdutosCsv{
    @Override
    public Produto ler(String[] produto) {
        return new ProdutoPadrao(
                Integer.parseInt(produto[0]),
                produto[1].trim(),
                produto[2].trim(),
                Integer.parseInt(produto[3].replaceAll("\\s","")),
                Double.parseDouble(produto[4])
        );
    }
}
