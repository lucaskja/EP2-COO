package src.Formatacao;

public class FormatadorNegrito implements Formatador{
    private Formatador formatador;

    public FormatadorNegrito(Formatador formatador) {
        this.formatador = formatador;
    }
    @Override
    public String formato(String palavra) {
        return "<span style=\"font-weight:bold\">" + this.formatador.formato((palavra)) + "</span>";
    }
}
