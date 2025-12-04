import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instância inicial — valores serão trocados depois conforme o menu
        ConectaAPI cotacao = new ConectaAPI("c9ac2cedfa959c28352d38f6","USD", "BRL");

        OpcaoMenu opcao = null;

        while (opcao != OpcaoMenu.SAIR) {

            System.out.println("===== MENU CONVERSOR DE MOEDAS =====");

            for (OpcaoMenu op : OpcaoMenu.values()) {
                System.out.println(op.getCodigo() + " - " + op.getBase() + " para " + op.getTarget());
            }

            System.out.println("Escolha um opção: ");
            int codigoEscolhido = sc.nextInt();

            opcao = OpcaoMenu.fromCodigo(codigoEscolhido);

            if (opcao == null) {
                System.out.println("Opção inválida! Tente novamente. \n");
                continue;
            }
            if (opcao == OpcaoMenu.SAIR) {
                System.out.println("Encerrando...");
                break;
            }

            // Atualiza automaticamente a moeda base e a moeda destino
            System.out.println(">> " + opcao.getBase() + " selecionado");

            cotacao.setBaseCurrency(opcao.getBase());
            cotacao.setTargetCurrency(opcao.getTarget());

            // Efetua requisição à API
            String resposta = cotacao.consultarCotacao();

            // Processa e imprime o JSON
            cotacao.resultJson(resposta);

            System.out.println();

        }
        sc.close();
    }
}
