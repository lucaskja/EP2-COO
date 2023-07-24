package src.Filtro;

import src.Produto.Produto;

public class FiltroCategoriaIgual implements EstrategiaFiltro{
    @Override
    public boolean estaSelecionado(Produto produto, String argFiltro) {
        return produto.getCategoria().equalsIgnoreCase(argFiltro);
    }
}
