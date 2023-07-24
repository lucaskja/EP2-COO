package src.Filtro;

import src.Produto.Produto;

public class FiltroEstoqueMenorOuIgual implements EstrategiaFiltro{
    @Override
    public boolean estaSelecionado(Produto produto, String argFiltro) {
        return produto.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}