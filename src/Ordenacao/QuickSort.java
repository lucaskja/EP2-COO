package src.Ordenacao;

import src.Enum.CriterioEnum;
import src.Ordenacao.Comparadores.*;
import src.Produto.Produto;

import java.util.ArrayList;

public class QuickSort implements EstrategiaOrdenacao {

    @Override
    public void ordenar(ArrayList<Produto> produtos, String criterio) {
        if (produtos.size() > 0) {
            particiona(produtos, 0, produtos.size() - 1, criterio);
        }
    }

    private void particiona(ArrayList<Produto> produtos, int ini, int fim, String criterio) {
        if (ini < fim) {
            int q = particao(produtos, ini, fim, criterio);
            particiona(produtos, ini, q, criterio);
            particiona(produtos, q + 1, fim, criterio);
        }
    }

    private int particao(ArrayList<Produto> produtos, int ini, int fim, String criterio) {
        Produto x = produtos.get(ini);
        int i = ini - 1;
        int j = fim + 1;

        while (true) {
            do {
                j--;
            } while (compara(produtos.get(j), x, criterio) > 0);

            do {
                i++;
            } while (compara(produtos.get(i), x, criterio) < 0);

            if (i < j) {
                Produto temp = produtos.get(i);
                produtos.set(i, produtos.get(j));
                produtos.set(j, temp);
            } else {
                return j;
            }
        }
    }

    private int compara(Produto p1, Produto p2, String criterio) {
        CriterioEnum criterioEnum = CriterioEnum.escolheCriterio(criterio);
        return switch (criterioEnum) {
            case CRIT_ESTOQUE_CRESC -> new ComparadorEstoqueCresc().compare(p1, p2);
            case CRIT_DESC_CRESC -> new ComparadorDescricaoCresc().compare(p1, p2);
            case CRIT_PRECO_CRESC -> new ComparadorPrecoCresc().compare(p1, p2);
            case CRIT_ESTOQUE_DEC -> new ComparadorEstoqueDec().compare(p1, p2);
            case CRIT_DESC_DEC -> new ComparadorDescricaoDec().compare(p1, p2);
            case CRIT_PRECO_DEC -> new ComparadorPrecoDec().compare(p1, p2);
        };
    }
}
