package sudoku.core;

public class Tabuleiro {
    private final Celula[][] celulas;

    public Tabuleiro() {
        celulas = new Celula[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                celulas[i][j] = new Celula(0, false);
            }
        }
    }

    public void inicializa(String dados) {
        String[] entradas = dados.split(" ");
        for (String entrada : entradas) {
            String[] partes = entrada.split(";");
            if(partes.length == 3) {
                String[] coordenadas = partes[0].split(",");
                int linha = Integer.parseInt(coordenadas[0]);
                int coluna = Integer.parseInt(coordenadas[1]);
                int valor = Integer.parseInt(partes[1]);
                boolean fixado = Boolean.parseBoolean(partes[2]);

                if (linha >= 0 && linha < 9 && coluna >= 0 && coluna < 9) {
                    celulas[linha][coluna] = new Celula(valor, fixado);
                }
            }
        }
    }

    public boolean eVazio(int linha, int coluna) {
        return celulas[linha][coluna].eVazia();
    }

    public boolean colocaoValida(int linha, int coluna, int num) {
        // Verifica linha
        for (int c = 0; c < 9; c++) {
            if (celulas[linha][c].getValor() == num && c != coluna) {
                return false;
            }
        }

        // Verifica coluna
        for (int r = 0; r < 9; r++) {
            if (celulas[r][coluna].getValor() == num && r != linha) {
                return false;
            }
        }

        // Verifica bloco 3x3
        int blockLinha = linha / 3 * 3;
        int blockColuna = coluna / 3 * 3;
        for (int r = blockLinha; r < blockLinha + 3; r++) {
            for (int c = blockColuna; c < blockColuna + 3; c++) {
                if (celulas[r][c].getValor() == num && !(r == linha && c == coluna)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean eCompleto() {
        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                if (eVazio(linha, coluna) || !colocaoValida(linha, coluna, celulas[linha][coluna].getValor())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setCelula(int linha, int coluna, int valor) {
        celulas[linha][coluna].setValor(valor);
    }

    public int getCelula(int linha, int coluna) {
        return celulas[linha][coluna].getValor();
    }

    public boolean eFixado(int linha, int coluna) {
        return celulas[linha][coluna].eFixado();
    }

    public void imprimi() {
        System.out.println("   " + " 0 1 2   3 4 5   6 7 8");
        System.out.println("   " + "-----------------------");

        for (int linha = 0; linha < 9; linha++) {
            System.out.print(linha + " |");
            for (int coluna = 0; coluna < 9; coluna++) {
                if (celulas[linha][coluna].eVazia()) {
                    System.out.print(" .");
                } else {
                    if (celulas[linha][coluna].eFixado()) {
                        System.out.print(" \u001B[1m" + celulas[linha][coluna].getValor() + "\u001B[0m");
                    } else {
                        System.out.print(" " + celulas[linha][coluna].getValor());
                    }
                }

                if (coluna == 2 || coluna == 5) {
                    System.out.print(" |");
                }
            }
            System.out.println(" |");

            if (linha == 2 || linha == 5) {
                System.out.println("   " + "-----------------------");
            }
        }
        System.out.println("   " + "-----------------------");
    }
}
