import java.util.ArrayList;
import Enum.CriterioEnum;

public class QuickSort implements Ordenacao{
    private ArrayList<Produto> produtos;
    private String criterio;
    public QuickSort(ArrayList<Produto> produtos, String criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
    }

    @Override
    public void ordena(int ini, int fim) {
        for(int i = ini; i <= fim; i++){

            Produto x = produtos.get(i);
            int j = (i - 1);

            while(j >= ini){

                if(criterio.equals(String.valueOf(CriterioEnum.CRIT_DESC_CRESC))){

                    if(x.getDescricao().compareToIgnoreCase(produtos.get(j).getDescricao()) < 0 ){

                        produtos.set(j + 1, produtos.get(j));
                        j--;
                    }
                    else break;
                }
                else if(criterio.equals(String.valueOf(CriterioEnum.CRIT_PRECO_CRESC))){

                    if(x.getPreco() < produtos.get(j).getPreco()){

                        produtos.set(j + 1, produtos.get(j));
                        j--;
                    }
                    else break;
                }
                else if(criterio.equals(String.valueOf(CriterioEnum.CRIT_ESTOQUE_CRESC))){

                    if(x.getQtdEstoque() < produtos.get(j).getQtdEstoque()){

                        produtos.set(j + 1, produtos.get(j));
                        j--;
                    }
                    else break;
                }
                else throw new RuntimeException("Criterio invalido!");
            }

            produtos.set(j + 1, x);
        }
    }
}
