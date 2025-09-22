package Projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        int opcao;
        do {
            limparTela();
            mostrarMenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    buscarEvento();
                    break;
                case 4:
                    inscreverPessoa();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao != 5) {
                System.out.println("\nPressione ENTER para continuar...");
                sc.nextLine(); // pausa para o usuário ver o resultado
            }

        } while (opcao != 5);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENU AGENDA ===");
        System.out.println("1. Cadastrar evento");
        System.out.println("2. Listar eventos");
        System.out.println("3. Buscar evento");
        System.out.println("4. Inscrever pessoa em evento");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarEvento() {
        Evento evento = new Evento();
        System.out.print("Nome do evento: ");
        evento.setNomeEvento(sc.nextLine());

        System.out.print("Local do evento: ");
        evento.setLocal(sc.nextLine());

        System.out.print("Quantidade máxima de pessoas: ");
        evento.setQtdMaxPessoas(sc.nextInt());
        sc.nextLine(); // limpa o buffer

        System.out.print("Data (DD-MM-AAAA): ");
        String dataStr = sc.nextLine();

        System.out.print("Hora (HH:MM): ");
        String horaStr = sc.nextLine();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataStr + " " + horaStr, formato);
        evento.setData(dataHora);

        agenda.cadastrarEvento(evento);
    }

    public static void listarEventos() {
        agenda.listarEventos();
    }

    public static void buscarEvento() {
        System.out.print("Digite o nome do evento: ");
        String nomeBusca = sc.nextLine();
        Evento buscado = agenda.buscarEvento(nomeBusca);
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado.getNomeEvento() + " em " + buscado.getLocal());
        }
    }

    private static void inscreverPessoa() {
        Pessoa pessoa = new Pessoa();

        System.out.print("Nome da pessoa: ");
        pessoa.setNome(sc.nextLine());

        System.out.print("CPF: ");
        pessoa.setCpf(sc.nextLine());

        System.out.print("Data de nascimento (DD-MM-AAAA): ");
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        pessoa.setDtNascimento(LocalDate.parse(sc.nextLine(), formatoData));

        System.out.print("Telefone: ");
        pessoa.setTelefone(sc.nextLine());

        System.out.print("Email: ");
        pessoa.setEmail(sc.nextLine());

        System.out.print("Evento para inscrição: ");
        String nomeEvento = sc.nextLine();
        Evento eventoEscolhido = agenda.buscarEvento(nomeEvento);

        if (eventoEscolhido != null) {
            pessoa.setEvento(eventoEscolhido);
            System.out.println("Pessoa " + pessoa.getNome() + " inscrita no evento " + eventoEscolhido.getNomeEvento());
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
