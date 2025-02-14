import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random RANDOM = new Random();
    private static final int FACIL = 10;
    private static final int MEDIO = 50;
    private static final int DIFICIL = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pontuacao = 0;
        int dificuldade;
        List<Integer> numerosErrados = new ArrayList<>();
        List<Integer> numerosAcertados = new ArrayList<>();
        boolean continua;

        System.out.println("\n-------Jogo do Adivinha!-------\n");

        dificuldade = getDificuldade(scanner);

        do {
            int numeroSorteado = getNumeroSorteado(dificuldade);
            int palpite = getPalpite(scanner, dificuldade);

            pontuacao = verificaPalpite(palpite, numeroSorteado, pontuacao, numerosAcertados, numerosErrados);
            System.out.println("Sua pontuação atual:");
            System.out.println(pontuacao);

            continua = verificaSeContinuaJogando(scanner);
        } while (continua);

        System.out.println("Fim de jogo!");
        System.out.println("Pontuação final: " + pontuacao);
        System.out.println("Números acertados: " + numerosAcertados);
        System.out.println("Números errados: " + numerosErrados);
    }

    private static int verificaPalpite(int palpite, int numeroSorteado, int pontuacao, List<Integer> numerosAcertados, List<Integer> numerosErrados) {
        if (palpite == numeroSorteado) {
            pontuacao = pontuacao + 10;
            numerosAcertados.add(numeroSorteado);
            System.out.println("Acertou!");
        } else if (palpite + 1 == numeroSorteado || palpite - 1 == numeroSorteado) {
            System.out.println("Quase...");
            pontuacao = pontuacao + 5;
            numerosErrados.add(numeroSorteado);
        } else{
            System.out.println("Errou...");
            numerosErrados.add(numeroSorteado);
        }
        return pontuacao;
    }

    private static int getDificuldade(Scanner scanner) {
        int opcaoDificuldade;
        boolean valido;
        int dificuldade = 0;

        do {
            System.out.println("Escolha a dificuldade do jogo:");
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 = Difícil");
            opcaoDificuldade = scanner.nextInt();
            if (opcaoDificuldade < 1 || opcaoDificuldade > 3) {
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);

        switch (opcaoDificuldade) {
            case 1:
                dificuldade = FACIL;
                break;
            case 2:
                dificuldade = MEDIO;
                break;
            case 3:
                dificuldade = DIFICIL;
                break;
        }

        return dificuldade;
    }

    private static boolean verificaSeContinuaJogando(Scanner scanner) {
        boolean valido = false;
        boolean continua = false;
        scanner.nextLine();

        do {
            System.out.println("Deseja jogar novamente? (S ou N)");
            String inputContinua = scanner.nextLine().trim().toUpperCase();
            if (inputContinua.equals("S")) {
                valido = true;
                continua = true;
            } else if (inputContinua.equals("N")) {
                valido = true;
            }
        } while (!valido);

        return continua;
    }

    private static int getNumeroSorteado(int dificuldade) {
        return RANDOM.nextInt(dificuldade) + 1;
    }

    private static int getPalpite(Scanner scanner, int dificuldade) {
        int palpite;
        boolean valido;

        do {
            System.out.println("Digite o seu palpite (1 a " + dificuldade + "):");
            palpite = scanner.nextInt();
            if (palpite < 1 || palpite > dificuldade) {
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);

        return palpite;
    }
}