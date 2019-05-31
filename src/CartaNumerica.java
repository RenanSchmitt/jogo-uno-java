public class CartaNumerica extends Carta {
    public int numero;

    public CartaNumerica(String cor, int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "CartaNumerica{" +
                "numero=" + numero +
                ", cor='" + cor + '\'' +
                '}';
    }
}
