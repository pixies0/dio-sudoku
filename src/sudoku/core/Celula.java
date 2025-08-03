package sudoku.core;

public class Celula {
    private int valor;
    private final boolean fixado;

    public Celula(int valor, boolean fixado) {
        this.valor = valor;
        this.fixado = fixado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (!fixado) {
            this.valor = valor;
        }
    }

    public boolean eFixado() {
        return fixado;
    }

    public boolean eVazia() {
        return valor == 0;
    }
}
