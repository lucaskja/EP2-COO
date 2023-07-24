package src.Enum;

public enum OrdenacaoEnum{
    ALG_INSERTIONSORT("insertion"),
    ALG_QUICKSORT("quick");

    private String ordenacao;

    OrdenacaoEnum(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public String getOrdenacao() {
        return ordenacao;
    }
}
