import java.util.Scanner;

class PokemonPersonalizado {
    private String nome;
    private int vidaAtual;
    private int vidaMax;

    public PokemonPersonalizado(String nome, int vida) {
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
    }

    public void receberDano(int quantidade) {
        this.vidaAtual -= quantidade;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }

    public boolean estaFaindo() {
        return this.vidaAtual <= 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMax() {
        return vidaMax;
    }
}

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONFIGURAÇÃO DA BATALHA ===");

        // Permitindo que o usuário escolha os nomes e a vida
        System.out.print("Digite o nome do 1º Pokémon: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite a vida máxima de " + nome1 + ": ");
        int vida1 = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("\nDigite o nome do 2º Pokémon: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite a vida máxima de " + nome2 + ": ");
        int vida2 = scanner.nextInt();
        scanner.nextLine();

        PokemonPersonalizado p1 = new PokemonPersonalizado(nome1, vida1);
        PokemonPersonalizado p2 = new PokemonPersonalizado(nome2, vida2);

        System.out.println("\n=== A BATALHA COMEÇOU! ===");
        System.out.println(p1.getNome() + " VS " + p2.getNome());
        System.out.println("-----------------------------------------\n");

        while (!p1.estaFaindo() && !p2.estaFaindo()) {
            // Status atual
            System.out.println("Status atual:");
            System.out.println("- " + p1.getNome() + " (HP: " + p1.getVidaAtual() + "/" + p1.getVidaMax() + ")");
            System.out.println("- " + p2.getNome() + " (HP: " + p2.getVidaAtual() + "/" + p2.getVidaMax() + ")");
            System.out.println();

            // Turno do Jogador 1 atacando o Jogador 2
            System.out.print("Turno de " + p1.getNome() + "! Quanto de dano ele vai causar em " + p2.getNome() + "? ");
            int dano1 = scanner.nextInt();
            scanner.nextLine();

            p2.receberDano(dano1);
            System.out.println(p1.getNome() + " causou " + dano1 + " de dano em " + p2.getNome() + "!");

            if (p2.estaFaindo()) {
                System.out.println("\n" + p2.getNome() + " desmaiou! " + p1.getNome() + " venceu a batalha!");
                break;
            }

            System.out.println("\n-----------------------------------------");

            // Turno do Jogador 2 atacando o Jogador 1
            System.out.print("Turno de " + p2.getNome() + "! Quanto de dano ele vai causar em " + p1.getNome() + "? ");
            int dano2 = scanner.nextInt();
            scanner.nextLine();

            p1.receberDano(dano2);
            System.out.println(p2.getNome() + " causou " + dano2 + " de dano em " + p1.getNome() + "!");

            if (p1.estaFaindo()) {
                System.out.println("\n" + p1.getNome() + " desmaiou! " + p2.getNome() + " venceu a batalha!");
                break;
            }

            System.out.println("=========================================\n");
        }

        scanner.close();
    }
}