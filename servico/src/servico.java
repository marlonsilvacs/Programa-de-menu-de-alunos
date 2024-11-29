import java.util.ArrayList;
import java.util.Scanner;

public class servico {
    static class Aluno {
        String nome;
        ArrayList<Double> notas;

        public Aluno(String nome) {
            this.nome = nome;
            this.notas = new ArrayList<>();
        }

        public double calcularMedia() {
            if (notas.isEmpty()) return 0.0;
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }
    }
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos alunos sem notas");
            System.out.println("5 - Excluir aluno");
            System.out.println("6 - Excluir nota");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    cadastrarNota(scanner);
                    break;
                case 3:
                    calcularMedia(scanner);
                    break;
                case 4:
                    listarAlunosSemNotas();
                    break;
                case 5:
                    excluirAluno(scanner);
                    break;
                case 6:
                    excluirNota(scanner);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        alunos.add(new Aluno(nome));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void cadastrarNota(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            System.out.print("Digite a nota: ");
            double nota = scanner.nextDouble();
            aluno.notas.add(nota);
            System.out.println("Nota cadastrada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void calcularMedia(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            double media = aluno.calcularMedia();
            System.out.println("A média do aluno " + nome + " é: " + media);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void listarAlunosSemNotas() {
        System.out.println("Alunos sem notas:");
        for (Aluno aluno : alunos) {
            if (aluno.notas.isEmpty()) {
                System.out.println(aluno.nome);
            }
        }
    }

    public static void excluirAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno a ser excluído: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void excluirNota(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            System.out.println("Notas do aluno:");
            for (int i = 0; i < aluno.notas.size(); i++) {
                System.out.println((i + 1) + " - " + aluno.notas.get(i));
            }
            System.out.print("Digite o número da nota a ser deletada: ");
            int indice = scanner.nextInt() - 1;
            if (indice >= 0 && indice < aluno.notas.size()) {
                aluno.notas.remove(indice);
                System.out.println("Nota deletada com sucesso!");
            } else {
                System.out.println("Número inválido.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.nome.equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}

