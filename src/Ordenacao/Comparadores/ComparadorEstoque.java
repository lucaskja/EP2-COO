package src.Ordenacao.Comparadores;

import src.Produto.Produto;

public class ComparadorEstoque implements ComparadorProduto {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Integer.compare(p1.getQtdEstoque(), p2.getQtdEstoque());
    }
}
