package src.Ordenacao.Comparadores;

import src.Produto.Produto;

import java.util.Comparator;

public class ComparadorPrecoCresc implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
