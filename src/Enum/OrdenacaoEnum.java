package Enum;

public enum OrdenacaoEnum{
    ALG_INSERTIONSORT("quick"),
    ALG_QUICKSORT("insertion");

    private String ordenacao;

    OrdenacaoEnum(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public String getOrdenacao() {
        return ordenacao;
    }
}
