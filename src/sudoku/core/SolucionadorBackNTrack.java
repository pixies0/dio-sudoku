package sudoku.core;

public class SolucionadorBackNTrack implements Solucionador {
    @Override
    public boolean soluciona(Tabuleiro tabuleiro) {
        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                if (tabuleiro.eVazio(linha, coluna)) {
                    for (int num = 1; num <= 9; num++) {
                        if (tabuleiro.colocaoValida(linha, coluna, num)) {
                            tabuleiro.setCelula(linha, coluna, num);
                            if (soluciona(tabuleiro)) {
                                return true;
                            }
                            tabuleiro.setCelula(linha, coluna, 0); // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
