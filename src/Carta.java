public class Carta {
    protected String cor;

    public Carta() {
    }
    public Carta(String cor){
        this.cor = cor;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "cor='" + cor + '\'' +
                '}';
    }
}
