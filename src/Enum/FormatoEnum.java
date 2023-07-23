package Enum;

public enum FormatoEnum {
    FORMATO_PADRAO(0b0000),
    FORMATO_NEGRITO(0b0001),
    FORMATO_ITALICO(0b0010);

    private int formato;

    FormatoEnum(int formato) {
        this.formato = formato;
    }

    public int getFormato() {
        return this.formato;
    }
}
