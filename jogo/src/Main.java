import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int pontuacao = 0;
        System.out.println("Jogo do Adivinha!");


        int numeroSorteado = random.nextInt(10) + 1;
        System.out.println(numeroSorteado);

        int palpite = getPalpite(scanner, 10);

        if (palpite == numeroSorteado) {
            pontuacao = pontuacao + 10;
            System.out.println("Acertou!");
        } else if (palpite + 1 == numeroSorteado || palpite - 1 == numeroSorteado) {
            System.out.println("Quase...");
            pontuacao = pontuacao + 5;
        }
        System.out.println("Sua pontuação atual:");
        System.out.println(pontuacao);
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