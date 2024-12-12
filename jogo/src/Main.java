import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        final int FACIL = 10;
        int pontuacao = 0;
        boolean continua = true;
        System.out.println("Jogo do Adivinha!");

        do {
            int numeroSorteado = getNumeroSorteado(random, FACIL);
            int palpite = getPalpite(scanner, FACIL);

            if (palpite == numeroSorteado) {
                pontuacao = pontuacao + 10;
                System.out.println("Acertou!");
            } else if (palpite + 1 == numeroSorteado || palpite - 1 == numeroSorteado) {
                System.out.println("Quase...");
                pontuacao = pontuacao + 5;
            }
            System.out.println("Sua pontuação atual:");
            System.out.println(pontuacao);

            continua = verificaSeContinuaJogando(scanner);
        } while (continua);
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

    private static int getNumeroSorteado(Random random, int FACIL) {
        int numeroSorteado = random.nextInt(FACIL) + 1;
        System.out.println(numeroSorteado);
        return numeroSorteado;
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