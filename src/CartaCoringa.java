public class CartaCoringa extends Carta {
    public String tipo;

    public CartaCoringa(String tipo){
        super("null");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CartaCoringa{" +
                "tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
