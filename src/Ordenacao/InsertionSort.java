package Ordenacao;
import Produto;
import static Enum.CriterioEnum.*;

public class InsertionSort implements EstrategiaOrdenacao {
    @Override
    public void ordenar(ArrayList<Produto> produtos, String criterio) {
        for(int i = 1; i < produtos.size(); i++){

            Produto x = produtos.get(i);
            int j = (i - 1);

            while(j >= 0){

                if(criterio.equals(CRIT_DESC_CRESC.getCriterio())){

                    if(x.getDescricao().compareToIgnoreCase(produtos.get(j).getDescricao()) < 0 ) {

                        produtos.set(j + 1, produtos.get(j));
                        j--;
                    }
                    else break;
                }
                else if(criterio.equals(CRIT_PRECO_CRESC.getCriterio())) {

                    if(x.getPreco() < produtos.get(j).getPreco()){

                        produtos.set(j + 1, produtos.get(j));
                        j--;
                    }
                    else break;
                }
                else if(criterio.equals(CRIT_ESTOQUE_CRESC.getCriterio())) {

                    if(x.getQtdEstoque() < produtos.get(j).getQtdEstoque()) {

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
