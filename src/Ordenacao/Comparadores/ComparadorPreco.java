package src.Ordenacao.Comparadores;

import src.Produto.Produto;

public class ComparadorPreco implements ComparadorProduto {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
