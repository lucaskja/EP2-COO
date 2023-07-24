package src.Enum;

public enum FiltroEnum {
    FILTRO_TODOS("todos"),
    FILTRO_ESTOQUE_MENOR_OU_IQUAL_A("estoque_menor_igual"),
    FILTRO_CATEGORIA_IGUAL_A("categoria_igual"),
    FILTRO_INTERVALO("intervalo"),
    FILTRO_SUBSTRING("substring");

    private String filtro;

    FiltroEnum(String filtro) {
        this.filtro = filtro;
    }

    public String getFiltro() {
        return filtro;
    }
}
