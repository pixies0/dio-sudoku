package sudoku.core;

public class Jogo {
    private Tabuleiro tabuleiro;
    private final Gerador gerador;
    private final Solucionador solucionador;

    public Jogo() {
        this.gerador = new GeradorPadrao();
        this.solucionador = new SolucionadorBackNTrack();
        this.tabuleiro = new Tabuleiro();
    }

    public void iniciaNovoJogo(int dificuldade) {
        this.tabuleiro = gerador.gerar(dificuldade);
    }

    public void carregaJogo(String dados) {
        this.tabuleiro = new Tabuleiro();
        tabuleiro.inicializa(dados);
    }

    public boolean realizaMovimento(int linha, int coluna, int valor) {
        if (linha < 0 || linha >= 9 || coluna < 0 || coluna >= 9 || valor < 0 || valor > 9)
            return false; // Movimento inválido

        if (tabuleiro.eFixado(linha, coluna)){
            System.out.println("Esta célula é fixa e não pode ser alterada!");
            return false; // Não pode alterar uma célula fixada
        }

        if (valor != 0 && !tabuleiro.colocaoValida(linha, coluna, valor)){
            System.out.println("Este número viola as regras do Sudoku!");
            return false; // Colocação inválida
        }

        tabuleiro.setCelula(valor, coluna, linha);
        return true;
    }

    public boolean eCompleto() {
        return tabuleiro.eCompleto();
    }

    public void soluciona() {
        solucionador.soluciona(tabuleiro);
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
