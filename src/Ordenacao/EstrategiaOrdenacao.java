package src.Ordenacao;

import java.util.ArrayList;
import src.Produto.Produto;

public interface EstrategiaOrdenacao {
    void ordenar(ArrayList<Produto> produtos, String criterio);
}
