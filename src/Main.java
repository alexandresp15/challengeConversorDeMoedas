import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        OpcaoMenu opcao = null;
        ConectaAPI cotacao = new ConectaAPI("c9ac2cedfa959c28352d38f6","USD", "BRL");
        cotacao.consultarCotacao();

        while (opcao != OpcaoMenu.SAIR) {
            System.out.println("===== MENU CONVERSOR DE MOEDAS =====");
            for (OpcaoMenu op : OpcaoMenu.values()) {
                System.out.println(op.getCodigo() + " - " + op.getDescricao());
            }

            System.out.println("Escolha um opção: ");
            int codigoEscolhido = sc.nextInt();

            opcao = OpcaoMenu.fromCodigo(codigoEscolhido);

            if (opcao == null) {
                System.out.println("Opção inválida! Tente novamente. \n");
                continue;
            }

            switch (opcao) {
                case USDTOBRL:
                    System.out.println(">>USDTOBRL selecionado");
                    break;
                case BRLTOUSD:
                    System.out.println(">>BRLTOUSD selecionado");
                    break;
                case USDTOARL:
                    System.out.println(">>USDTOARL selecionado");
                    break;
                case ARLTOUSD:
                    System.out.println(">>ARLTOUSD selecionado");
                    break;
                case BRLTOARL:
                    System.out.println(">>BRLTOARL selecionado");
                    break;
                case ARLTOBRL:
                    System.out.println(">>ARLTOBRL selecionado");
                    break;
                case SAIR:
                    System.out.println(">>SAIR selecionado");
                    break;
            }

            System.out.println();
        }
        sc.close();
    }
}
