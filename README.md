# Documentação do Projeto Sudoku em Java

## Visão Geral
Implementação do jogo Sudoku em Java com:
- Geração de tabuleiros aleatórios
- Solução automática
- Interface de terminal interativa
- Validação de jogadas

## Estrutura do Projeto

```
src/
├── main/
│ ├── java/
│ │ ├── sudoku/
│ │ │ ├── core/ # Lógica principal
│ │ │ ├── ui/ # Interface do usuário
│ │ │ └── App.java # Ponto de entrada
```


## Classes Principais

### `Board`
- Representa o tabuleiro 9x9
- Gerencia células (valores e estado fixo)
- Valida jogadas

### `Game`
- Controla fluxo do jogo
- Coordena geração e solução
- Gerencia estado do jogo

### `TerminalUI`
- Interface de usuário via terminal
- Processa comandos
- Exibe tabuleiro formatado

## Comandos Disponíveis

| Comando         | Descrição                          |
|-----------------|------------------------------------|
| `linha col num` | Insere número na posição especificada |
| `soluciona`     | Revela a solução completa do tabuleiro |
| `novo`          | Inicia um novo jogo                |
| `sair`          | Encerra o programa                 |
| `ajuda`         | Mostra esta lista de comandos      |

## Exemplo de Saída

```
    0 1 2   3 4 5   6 7 8
   -----------------------
0 | 1 . . | . . 6 | . . . |
1 | . . 6 | . . . | . 2 3 |
2 | . . 9 | . 2 . | 4 . 6 |
   -----------------------
...
```

## Melhorias Futuras

* Interface gráfica

* Temporizador