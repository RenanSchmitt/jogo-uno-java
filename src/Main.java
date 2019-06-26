import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Pilha baralho = new Pilha();
        Pilha descarte = new Pilha();
        Carta topoDescarte = new Carta();
        Carta cartaEscolha = new Carta();
        Scanner entrada = new Scanner(System.in);
        int i, j = 0, escolha;
        baralho.criaBaralho();
        baralho.embaralhaBaralho();
        Jogador j1 = new Jogador("Jamelão");
        Jogador j2 = new Jogador("Juriscleison");

        for (i = 0; i < 7; i++) {
            j1.compra(baralho.pegaCarta());
            j2.compra(baralho.pegaCarta());
        }
        descarte.addCarta(baralho.pegaCarta());
    /* **** Reembaralha o baralho com as cartas que estão no descarte, e coloca a ultima no descarte
        cartaAux = descarte.pegaCarta(descarte.sizeoff() - 1);
        baralho.resetaBaralho();
        while (descarte.sizeoff() > 0){
            baralho.addCarta(descarte.pegaCarta(descarte.sizeoff()-1));
        }
        descarte.resetaBaralho();
        descarte.addCarta(cartaAux);
    */
        while(j1.maoSize() > 0 && j2.maoSize() > 0){
            System.out.println("***Sua vez " + j1.nome + "***");
            j1.verMao();
            System.out.println();
            System.out.println("Pilha de descarte");
            System.out.println(descarte.olhaCarta());1
            System.out.println("Escolha a carta pelo indice.");
            escolha = entrada.nextInt();
            cartaEscolha = j1.verCarta(escolha);
            topoDescarte = descarte.olhaCarta();

            if (cartaEscolha instanceof CartaEfeito){
                cartaEscolha = (CartaEfeito) j1.verCarta(escolha);
                if (topoDescarte instanceof  CartaEfeito) {
                    if (((CartaEfeito) cartaEscolha).getEfeito().equals(((CartaEfeito) topoDescarte).getEfeito())) {
                        descarte.addCarta(cartaEscolha);
                        j1.jogaCarta(escolha);
                    }
                }else..........

                if (cartaEscolha.getCor().equals(topoDescarte.getCor())){
                    descarte.addCarta(cartaEscolha);
                    j1.jogaCarta(escolha);
                }else if(((CartaEfeito) cartaEscolha).getEfeito().equals(((CartaEfeito) topoDescarte).getEfeito())){
                    descarte.addCarta(cartaEscolha);
                    j1.jogaCarta(escolha);
                }else{
                    System.out.println("n pode");
                }
            }else if (cartaEscolha instanceof  CartaNumerica){
                cartaEscolha = (CartaNumerica) j1.verCarta(escolha);
                topoDescarte = (CartaNumerica) descarte.olhaCarta();
                if (cartaEscolha.getCor().equals(topoDescarte.getCor())){
                    descarte.addCarta(cartaEscolha);
                    j1.jogaCarta(escolha);
                }else if(((CartaNumerica) cartaEscolha).getNumero() == ((CartaNumerica) topoDescarte).getNumero()){
                    descarte.addCarta(cartaEscolha);
                    j1.jogaCarta(escolha);
                }else{
                    System.out.println("n pode");
                }
            }else if (cartaEscolha instanceof  CartaCoringa){
                cartaEscolha = (CartaCoringa) j1.verCarta(escolha);
                topoDescarte = (CartaCoringa) descarte.olhaCarta();
                if (((CartaCoringa)cartaEscolha).getTipo().equals(((CartaCoringa) topoDescarte).getTipo())){
                    descarte.addCarta(cartaEscolha);
                    j1.jogaCarta(escolha);
                }else{
                    System.out.println("n pode");
                }
            }
            j1.jogaCarta(escolha);
            j1.verMao();

        }
        System.out.println("venceu************");
    }

}