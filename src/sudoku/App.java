package sudoku;

import sudoku.core.Jogo;
import sudoku.ui.TerminalUi;
import sudoku.ui.UI;

public class App {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // Se houver argumentos, carrega um jogo específico
        if (args.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg).append(" ");
            }
            jogo.carregaJogo(sb.toString().trim());;
        } else {
            // Caso contrário, inicia um novo jogo com dificuldade média
            jogo.iniciaNovoJogo(30);
        }

        UI ui = new TerminalUi();
        ui.executa(jogo);
    }
}
