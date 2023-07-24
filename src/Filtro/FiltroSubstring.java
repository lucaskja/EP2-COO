package src.Filtro;

import src.Produto.Produto;

public class FiltroSubstring implements EstrategiaFiltro{
    @Override
    public boolean estaSelecionado(Produto produto, String argFiltro) {
        return produto.getDescricao().toLowerCase().contains(argFiltro.toLowerCase());
    }
}
