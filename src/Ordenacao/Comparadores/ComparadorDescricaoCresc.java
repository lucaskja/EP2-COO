package src.Ordenacao.Comparadores;

import src.Produto.Produto;

import java.util.Comparator;

public class ComparadorDescricaoCresc implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p2.getDescricao().compareToIgnoreCase(p1.getDescricao());
    }
}
