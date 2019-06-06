public class Main {

    public static void main(String[] args){
        BaralhoUno baralho = new BaralhoUno();
        int i, j = 0;
        baralho.criaBaralho();
        baralho.embaralhaBaralho();
        for (i = 0; i < 100; i++){
            System.out.println("[" + i + "]" + baralho.olhaCarta(i));
        }
        Jogador j1 = new Jogador("Jamelão");
        for (i=0; i <7; i++){
            j1.compra(baralho.pegaCarta(j));
            j++;
        }
        System.out.println();
        j1.verMao();

        j1.compra(baralho.pegaCarta(10));

        System.out.println();
        j1.verMao();

    }
}
