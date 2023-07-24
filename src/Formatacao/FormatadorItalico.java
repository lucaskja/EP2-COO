package src.Formatacao;

public class FormatadorItalico implements Formatador{
    private Formatador formatador;

    public FormatadorItalico(Formatador formatador) {
        this.formatador = formatador;
    }
    @Override
    public String formato(String palavra) {
        return "<span style=\"font-style:italic\">" + this.formatador.formato((palavra)) + "</span>";
    }
}
