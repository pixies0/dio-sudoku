package sudoku.ui;

import sudoku.core.Jogo;
import java.util.Scanner;

public class TerminalUi implements UI{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void executa(Jogo jogo) {
        System.out.println("Bem-vindo ao Sudoku em Java!");
        imprimiAjuda();

        boolean executando = true;
        while (executando) {
            jogo.getTabuleiro().imprimi();

            if (jogo.eCompleto()) {
                System.out.println("\u001B[32mParabéns! Você completou o Sudoku!\u001B[0m");
                break;
            }

            System.out.print("\nDigite um comando: ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            switch (entrada) {
                case "sair":
                    executando = false;
                    break;
                case "ajuda":
                    imprimiAjuda();
                    break;
                case "soluciona":
                    jogo.soluciona();
                    System.out.println("Sudoku resolvido!");
                    break;
                case "novo":
                    comecaNovoJogo(jogo);
                    break;
                default:
                    processaMovimento(jogo, entrada);
                    break;
            }
        }

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }

    private void imprimiAjuda() {
        System.out.println("\nComandos disponíveis:");
        System.out.println("  linha coluna num - Insere 'num' na posição (linha, coluna)");
        System.out.println("  soluciona       - Mostra a solução");
        System.out.println("  novo         - Inicia um novo jogo");
        System.out.println("  sair        - Sai do jogo");
        System.out.println("  ajuda        - Mostra esta ajuda\n");
    }

    private void comecaNovoJogo(Jogo jogo) {
        System.out.print("Escolha a dificuldade (20-60, onde 20 é mais fácil): ");
        try {
            int dificuldade = Integer.parseInt(scanner.nextLine());
            jogo.iniciaNovoJogo(dificuldade);
            System.out.println("Novo jogo iniciado!");
        } catch (NumberFormatException e) {
            System.out.println("Dificuldade inválida. Usando padrão (30).");
            jogo.iniciaNovoJogo(30);
        }
    }

    private void processaMovimento(Jogo jogo, String entrada) {
        String[] partes = entrada.split(" ");
        if (partes.length == 3) {
            try {
                int linha = Integer.parseInt(partes[0]);
                int coluna = Integer.parseInt(partes[1]);
                int num = Integer.parseInt(partes[2]);

                if (jogo.realizaMovimento(linha, coluna, num)) {
                    System.out.println("Número " + num + " colocado em (" + linha + ", " + coluna + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Use: linha coluna num");
            }
        } else {
            System.out.println("Comando não reconhecido. Digite 'ajuda' para ajuda.");
        }
    }
}
