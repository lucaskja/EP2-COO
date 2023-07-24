package src.Ordenacao.Comparadores;

import src.Produto.Produto;

import java.util.Comparator;

public class ComparadorEstoqueCresc implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Integer.compare(p2.getQtdEstoque(), p1.getQtdEstoque());
    }
}
