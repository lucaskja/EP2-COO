package src.Ordenacao;

import src.Enum.OrdenacaoEnum;
import src.Produto.Produto;

import java.util.ArrayList;

public class OrdenaProdutos {
    private EstrategiaOrdenacao algoritmoDeOrdenacao;

    public OrdenaProdutos(EstrategiaOrdenacao algoritmoDeOrdenacao) {
        this.algoritmoDeOrdenacao = algoritmoDeOrdenacao;
    }

    public void ordenarProdutos (ArrayList<Produto> produtos, String criterio) {
        algoritmoDeOrdenacao.ordenar(produtos, criterio);
    }
}
