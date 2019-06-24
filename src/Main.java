public class Main {

    public static void main(String[] args){
        Pilha baralho = new Pilha();
        Pilha descarte = new Pilha();
        int i, j = 0;
        baralho.criaBaralho();
        baralho.embaralhaBaralho();
        for (i = 0; i < baralho.sizeoff(); i++){
            System.out.println("[" + i + "]" + baralho.olhaCarta(i));
        }
        Jogador j1 = new Jogador("Jamelão");
        for (i=0; i <7; i++){
            j1.compra(baralho.pegaCarta());
            j++;
        }
        System.out.println();
        j1.verMao();

        j1.compra(baralho.pegaCarta());

        System.out.println();
        j1.verMao();
        System.out.println();

        for (i = 0; i < baralho.sizeoff(); i++){
            System.out.println("[" + i + "]" + baralho.olhaCarta(i));
        }
        descarte.addCarta(j1.jogaCarta(0));

        j1.verMao();
        System.out.println();
        for (i = 0; i < descarte.sizeoff(); i++){
            System.out.println("[" + i + "]" + descarte.olhaCarta(i));
        }
        System.out.println();
        baralho = descarte;
        for (i = 0; i < baralho.sizeoff(); i++){
            System.out.println("[" + i + "]" + baralho.olhaCarta(i));
        }

    }
}
