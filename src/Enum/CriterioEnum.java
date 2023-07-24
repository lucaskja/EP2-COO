package src.Enum;

public enum CriterioEnum {
    CRIT_DESC_CRESC("descricao_c"),
    CRIT_PRECO_CRESC("preco_c"),
    CRIT_ESTOQUE_CRESC("estoque_c"),
    CRIT_ESTOQUE_DEC("estoque_d"),
    CRIT_PRECO_DEC("preco_d"),
    CRIT_DESC_DEC("descricao_d");

    private String criterio;

    CriterioEnum(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public static CriterioEnum escolheCriterio(String texto) {
        for (CriterioEnum crit : CriterioEnum.values()) {
            if (crit.criterio.equalsIgnoreCase(texto)) {
                return crit;
            }
        }
        throw new RuntimeException("Criterio: inválido!");
    }
}
