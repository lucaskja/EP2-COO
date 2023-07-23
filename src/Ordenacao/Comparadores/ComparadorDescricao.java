package src.Ordenacao.Comparadores;

import src.Produto.Produto;

public class ComparadorDescricao implements ComparadorProduto {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getDescricao().compareToIgnoreCase(p2.getDescricao());
    }
}
