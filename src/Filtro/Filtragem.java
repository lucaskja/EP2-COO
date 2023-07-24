package src.Filtro;

import src.Enum.FiltroEnum;
import src.Produto.Produto;

public class Filtragem {

    public static Boolean filtrar(Produto produto, String filtro, String argFiltro) {
        if (filtro.equals(FiltroEnum.FILTRO_TODOS.getFiltro())) {
            return new FiltroTodos().estaSelecionado(produto, argFiltro);
        }

        if (filtro.equals(FiltroEnum.FILTRO_ESTOQUE_MENOR_OU_IQUAL_A.getFiltro())) {
            return new FiltroEstoqueMenorOuIgual().estaSelecionado(produto, argFiltro);
        }

        if (filtro.equals(FiltroEnum.FILTRO_CATEGORIA_IGUAL_A.getFiltro())) {
            return new FiltroCategoriaIgual().estaSelecionado(produto, argFiltro);
        }

        throw new RuntimeException("Filtro invalido!");
    }
}
