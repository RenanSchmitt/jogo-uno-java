import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Pilha baralho = new Pilha();
        Pilha descarte = new Pilha();
        Regras regras = new Regras();
        Carta topoDescarte = new Carta();
        Carta cartaEscolha = new Carta();
        Carta cartaAux = new Carta();
        Scanner entrada = new Scanner(System.in);
        String uno;
        boolean terminou = false;
        int i, j = 0, escolha, vCor,aux=-1;
        baralho.criaBaralho();
        baralho.embaralhaBaralho();
        List<Jogador> jogadores = new ArrayList();
        jogadores.add(new Jogador("Jamelão"));
        jogadores.add(new Jogador("Juriscleison")) ;

        for (i = 0; i < 7; i++) {
            for(j = 0; j < jogadores.size(); j++){
                jogadores.get(j).compra(baralho.pegaCarta());
            }
        }
        while(!regras.primeiraCarta(baralho.olhaCarta())){
            baralho.embaralhaBaralho();
        }
        descarte.addCarta(baralho.pegaCarta());
        while(!terminou) {
            for (i = 0; i < jogadores.size(); i++) {
                System.out.println("***Sua vez " + jogadores.get(i).nome + "***");
                if(regras.consegueJogar(jogadores.get(i).verMao(), descarte.olhaCarta())){
                    jogadores.get(i).printMao();
                    System.out.println();
                    System.out.println("Pilha de descarte");
                    System.out.println(descarte.olhaCarta());
                    System.out.println("Escolha a carta pelo indice.");
                    if(jogadores.get(i).maoSize() == 2){
                        uno = entrada.next();
                        if(!regras.uno(uno)){
                            System.out.println("Você não digitou uno!!!");
                            System.out.println("Comprará 1 cartas e  passará a vez");
                            entrada.next();
                            jogadores.get(i).compra(baralho.pegaCarta());
                            continue;
                        }else{
                            System.out.println("Boa " + jogadores.get(i).getNome() + " você falou uno");
                            entrada.next();
                            System.out.println("Pilha de descarte");
                            System.out.println(descarte.olhaCarta());
                            System.out.println("Escolha a carta pelo indice.");
                        }
                    }
                    escolha = entrada.nextInt();
                    while((escolha >= jogadores.get(i).maoSize() || escolha < 0)) {
                        System.out.println("Esse indice è invalido para você");
                        System.out.println("Pilha de descarte");
                        System.out.println(descarte.olhaCarta());
                        System.out.println("Escolha a carta pelo indice.");
                        escolha = entrada.nextInt();
                    }
                    cartaEscolha = jogadores.get(i).verCarta(escolha);
                    topoDescarte = descarte.olhaCarta();
                    if (regras.isCoringa(cartaEscolha)) {
                        while(!regras.podeJogarCoringa(jogadores.get(i).verMao(), topoDescarte)) {
                            System.out.println("Você não pode jogar o +4 agora");
                            System.out.println("Pilha de descarte");
                            System.out.println(descarte.olhaCarta());
                            System.out.println("Escolha a carta pelo indice.");
                            escolha = entrada.nextInt();
                            if(regras.efeitos(jogadores.get(i).verCarta(escolha)) != 3){
                                break;
                            }
                        }
                    }
                    cartaEscolha = jogadores.get(i).verCarta(escolha);
                    topoDescarte = descarte.olhaCarta();
                    while((escolha >= jogadores.get(i).maoSize() || escolha < 0)) {
                        System.out.println("Esse indice è invalido para você");
                        System.out.println("Pilha de descarte");
                        System.out.println(descarte.olhaCarta());
                        System.out.println("Escolha a carta pelo indice.");
                        escolha = entrada.nextInt();
                    }



                    while ((aux = regras.compara(cartaEscolha, topoDescarte)) != 0 && aux < 7) {
                        if (aux >= 0) {
                            switch (aux) {
                                case 1:
                                    System.out.println("Essas cartas não tem a mesma cor nem o mesmo efeito");

                                    break;
                                case 2:
                                    System.out.println("Essas cartas não tem a mesma cor e não são duas cartas de efeito");
                                    break;
                                case 3:
                                    System.out.println("Essa carta numérica não é da mesma cor que a carta coringa");
                                    break;
                                case 4:
                                    System.out.println("Essas Cartas não tem a mesma cor nem o mesmo número");
                                    break;
                                case 5:
                                    System.out.println("Essas cartas não tem a mesma cor e não são duas cartas numéricas");

                                    break;
                                case 6:
                                    System.out.println("Essa carta efeito não é da mesma cor que a carta coringa");
                                    break;
                            }
                            System.out.println("Pilha de descarte");
                            System.out.println(descarte.olhaCarta());
                            System.out.println("Escolha a carta pelo indice.");
                            escolha = entrada.nextInt();
                            cartaEscolha = jogadores.get(i).verCarta(escolha);
                            topoDescarte = descarte.olhaCarta();
                            if (regras.isCoringa(cartaEscolha)) {
                                while(!regras.podeJogarCoringa(jogadores.get(i).verMao(), topoDescarte)) {
                                    System.out.println("Você não pode jogar o +4 agora");
                                    System.out.println("Pilha de descarte");
                                    System.out.println(descarte.olhaCarta());
                                    System.out.println("Escolha a carta pelo indice.");
                                    escolha = entrada.nextInt();
                                    if(regras.efeitos(jogadores.get(i).verCarta(escolha)) != 3){
                                        break;
                                    }
                                }
                            }
                            cartaEscolha = jogadores.get(i).verCarta(escolha);
                            topoDescarte = descarte.olhaCarta();
                            while((escolha >= jogadores.get(i).maoSize() || escolha < 0)) {
                                System.out.println("Esse indice è invalido para você");
                                System.out.println("Pilha de descarte");
                                System.out.println(descarte.olhaCarta());System.out.println("Escolha a carta pelo indice.");
                                escolha = entrada.nextInt();
                            }
                            jogadores.get(i).printMao();
                        }
                    }
                    if (aux >= 7) {
                        System.out.println("Digite a cor que vc deseja pelo indice");
                        System.out.println("[0]Vermelho[0]\n[1]Amarelo[1]\n[2]Azul[2]\n[3]Verde[3]");
                        vCor = entrada.nextInt();
                        while (!regras.EscolheCor(cartaEscolha, vCor)) {
                            System.out.println("Digitou um indice invalido digite novamente");
                            System.out.println("[0]Vermelho[0]\n[1]Amarelo[1]\n[2]Azul[2]\n[3]Verde[3]");
                            vCor = entrada.nextInt();
                        }
                        System.out.println("A cor agora é " + cartaEscolha.getCor());
                    }
                    aux = regras.efeitos(cartaEscolha);
                    descarte.addCarta(cartaEscolha);
                    jogadores.get(i).jogaCarta(escolha);
                    switch (aux){
                        case 0:

                        break;
                        case 1:
                            i++;
                        break;
                        case 2:
                            if (i == jogadores.size() - 1){
                                System.out.println(jogadores.get(0).getNome() + " Comprou 2 cartas!!!");
                            }else{
                                System.out.println(jogadores.get(i + 1).getNome() + " Comprou 2 cartas!!!");
                            }
                            for(j=0;j <=2;j++) {
                                if(j == jogadores.size() - 1){
                                    jogadores.get(0).compra(baralho.pegaCarta());
                                }else{
                                    jogadores.get(i + 1).compra(baralho.pegaCarta());
                                }
                            }
                            i++;
                            break;
                        case 3:
                            if (i == jogadores.size() - 1){
                                System.out.println(jogadores.get(0).getNome() + " Comprou 4 cartas!!!");
                            }else{
                                System.out.println(jogadores.get(i + 1).getNome() + " Comprou 4 cartas!!!");
                            }
                            for(j=0;j <=4;j++){
                                if(j == jogadores.size() - 1){
                                    jogadores.get(0).compra(baralho.pegaCarta());
                                }else{
                                    jogadores.get(i + 1).compra(baralho.pegaCarta());
                                }

                            }
                            i++;
                        break;

                    }
                    if(regras.ganhou(jogadores) >= 0){
                        terminou = true;
                        break;
                    }
                }else{
                    jogadores.get(i).printMao();
                    System.out.println();
                    System.out.println("Pilha de descarte");
                    System.out.println(descarte.olhaCarta());
                    System.out.println("Você não tem cartas que possam ser jogadas no momento :( ");
                    System.out.println("Compre uma carta!");
                    entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Você comprou a carta:");
                    System.out.println(baralho.olhaCarta());
                    jogadores.get(i).compra(baralho.pegaCarta());
                }
                if(baralho.sizeoff() == 0){
                    cartaAux = descarte.pegaCarta(descarte.sizeoff() - 1);
                    baralho.resetaBaralho();
                    while (descarte.sizeoff() > 0){
                        baralho.addCarta(descarte.pegaCarta(descarte.sizeoff()-1));
                    }
                    descarte.resetaBaralho();
                    descarte.addCarta(cartaAux);
                }
            }
        }
        System.out.println("***" + jogadores.get(i).getNome() +" Venceu***");
    }
}