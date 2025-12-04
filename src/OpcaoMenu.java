public enum OpcaoMenu {

    USDTOBRL(1, "UsdToBrl"),
    BRLTOUSD(2,"BrlToUsd"),
    USDTOARL(3,"ArlToUsd"),
    ARLTOUSD(4,"ArlToUsd"),
    BRLTOARL(5,"BrltoArl"),
    ARLTOBRL(6,"ArltoBrl"),
    SAIR(7, "Sair");

    private final int codigo;
    private final String descricao;

    OpcaoMenu(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }

    public static OpcaoMenu fromCodigo(int codigo) {
        for (OpcaoMenu opcao : OpcaoMenu.values()) {
            if (opcao.codigo == codigo) {
                return opcao;
            }
        }
        return null;
    }
}
