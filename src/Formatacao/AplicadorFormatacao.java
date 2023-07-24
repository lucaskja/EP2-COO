package src.Formatacao;

import src.Enum.FormatoEnum;

public class AplicadorFormatacao {
    public static String saidaFormatacao(int format_flags, String palavra) {
        Formatador formatador = new FormatadorPadrao();

        if ((format_flags & FormatoEnum.FORMATO_ITALICO.getFormato()) > 0 && (format_flags & FormatoEnum.FORMATO_NEGRITO.getFormato()) > 0) {
            formatador = new FormatadorItalico(formatador);
            formatador.formato(palavra);
            formatador = new FormatadorNegrito(formatador);
            return formatador.formato(palavra);
        }

        if ((format_flags & FormatoEnum.FORMATO_ITALICO.getFormato()) > 0) {
            formatador = new FormatadorItalico(formatador);
            return formatador.formato(palavra);
        }

        if ((format_flags & FormatoEnum.FORMATO_NEGRITO.getFormato()) > 0) {
            formatador = new FormatadorNegrito(formatador);
            return formatador.formato(palavra);
        }

        return formatador.formato(palavra);
    }

    public static String saidaFormatacaoCsv(String palavra, Boolean ehNegrito, Boolean ehItalico, String cor) {
        Formatador formatador = new FormatadorPadrao();

        if (ehNegrito && ehItalico) {
            formatador = new FormatadorItalico(formatador);
            formatador.formato(palavra);
            formatador = new FormatadorNegrito(formatador);
            formatador.formato(palavra);
            formatador =  new FormatadorCor(formatador, cor);
            return formatador.formato(palavra);
        }

        if (ehNegrito) {
            formatador = new FormatadorNegrito(formatador);
            formatador.formato(palavra);
            formatador =  new FormatadorCor(formatador, cor);
            return formatador.formato(palavra);
        }

        if (ehItalico) {
            formatador = new FormatadorItalico(formatador);
            formatador.formato(palavra);
            formatador =  new FormatadorCor(formatador, cor);
            return formatador.formato(palavra);
        }

        return formatador.formato(palavra);
    }
}
