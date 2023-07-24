package src.Ordenacao;

import src.Ordenacao.Comparadores.*;
import src.Produto.Produto;
import src.Enum.CriterioEnum;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort implements EstrategiaOrdenacao {
    @Override
    public void ordenar(ArrayList<Produto> produtos, String criterio) {
        CriterioEnum criterioEnum = CriterioEnum.escolheCriterio(criterio);
        Comparator<Produto> comparator = switch (criterioEnum) {
            case CRIT_ESTOQUE_CRESC -> new ComparadorEstoqueCresc();
            case CRIT_DESC_CRESC -> new ComparadorDescricaoCresc();
            case CRIT_PRECO_CRESC -> new ComparadorPrecoCresc();
            case CRIT_ESTOQUE_DEC -> new ComparadorEstoqueDec();
            case CRIT_DESC_DEC -> new ComparadorDescricaoDec();
            case CRIT_PRECO_DEC -> new ComparadorPrecoDec();
        };

        for (int i = 1; i < produtos.size(); i++) {
            Produto x = produtos.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(x, produtos.get(j)) < 0) {
                produtos.set(j + 1, produtos.get(j));
                j--;
            }

            produtos.set(j + 1, x);
        }
    }
}
