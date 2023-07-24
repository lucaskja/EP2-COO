package src.Filtro;

import src.Produto.Produto;

public interface EstrategiaFiltro {
    boolean estaSelecionado(Produto produto, String argFiltro);
}
