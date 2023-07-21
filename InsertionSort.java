import java.util.ArrayList;

public class InsertionSort implements Ordenacao{
    private ArrayList<Produto> produtos;
    private String criterio;
    public InsertionSort(ArrayList<Produto> produtos, String criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
    }

    @Override
    public void ordena(int ini, int fim) {

    }
}
