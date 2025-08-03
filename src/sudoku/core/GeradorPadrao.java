package sudoku.core;

import java.util.Random;

public class GeradorPadrao implements Gerador {
    private final Random aleatorio = new Random();
    private final Solucionador solucionador = new SolucionadorBackNTrack();

    @Override
    public Tabuleiro gerar(int dificuldade) {
        Tabuleiro tabuleiro = new Tabuleiro();
        solucionador.soluciona(tabuleiro);

        // Remove números para criar o puzzle
        int celulasRemover = 81 - Math.min(Math.max(dificuldade, 20), 60);
        while (celulasRemover > 0) {
            int linha = aleatorio.nextInt(9);
            int coluna = aleatorio.nextInt(9);
            if (!tabuleiro.eVazio(linha, coluna)) {
                tabuleiro.setCelula(linha, coluna, 0);
                celulasRemover--;
            }
        }

        return tabuleiro;
    }
}
