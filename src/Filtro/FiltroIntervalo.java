package src.Filtro;

import src.Produto.Produto;

public class FiltroIntervalo implements EstrategiaFiltro{
    @Override
    public boolean estaSelecionado(Produto produto, String argFiltro) {
        String[] values = argFiltro.split("-");
        return (produto.getPreco() >= Integer.parseInt(values[0])) && (produto.getPreco() <= Integer.parseInt(values[1]));
    }
}
