package src.Ordenacao;

import src.Enum.OrdenacaoEnum;
import src.Produto.Produto;

import java.util.ArrayList;

public class OrdenaProdutos {
    private String algoritmo;

    public OrdenaProdutos(String algoritmo, ArrayList<Produto> produtos, String criterio) {
        this.algoritmo = algoritmo;
        this.ordenarProdutos(produtos, criterio);
    }

    public void ordenarProdutos (ArrayList<Produto> produtos, String criterio) {
        if (algoritmo.equals(OrdenacaoEnum.ALG_INSERTIONSORT.getOrdenacao())) {
            new InsertionSort().ordenar(produtos, criterio);
            return;
        }

        if (algoritmo.equals(OrdenacaoEnum.ALG_QUICKSORT.getOrdenacao())) {
            new QuickSort().ordenar(produtos, criterio);
            return;
        }

        throw new RuntimeException("Algoritmo invalido!");
    }
}
