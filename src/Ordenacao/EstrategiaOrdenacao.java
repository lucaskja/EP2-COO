package Ordenacao;

import java.util.ArrayList;

public interface EstrategiaOrdenacao {
    void ordenar(ArrayList<Produto> produtos, String criterio);
}
