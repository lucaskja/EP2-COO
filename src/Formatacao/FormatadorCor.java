package src.Formatacao;

public class FormatadorCor implements Formatador{
    private Formatador formatador;
    private String cor;

    public FormatadorCor(Formatador formatador, String cor) {
        this.formatador = formatador;
        this.cor = cor;
    }
    @Override
    public String formato(String palavra) {
        return "<span style=\"color:" + this.cor + "\">" + this.formatador.formato((palavra)) + "</span>";
    }
}