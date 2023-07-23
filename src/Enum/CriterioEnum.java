package Enum;

public enum CriterioEnum {
    CRIT_DESC_CRESC("descricao_c"),
    CRIT_PRECO_CRESC("preco_c"),
    CRIT_ESTOQUE_CRESC("estoque_c");

    private String criterio;

    CriterioEnum(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }
}
