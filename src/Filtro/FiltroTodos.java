package src.Filtro;

import src.Produto.Produto;

import javax.swing.*;
import java.util.ArrayList;

public class FiltroTodos implements EstrategiaFiltro{
    @Override
    public boolean estaSelecionado(Produto produto, String argFiltro) {
        return true;
    }
}
