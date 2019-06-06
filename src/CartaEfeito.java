public class CartaEfeito extends Carta{
    public String efeito;

    public CartaEfeito(String cor, String efeito) {
        super(cor);
        this.efeito = efeito;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    @Override
    public String toString() {
        return "CartaEfeito{" +
                "efeito='" + efeito + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
