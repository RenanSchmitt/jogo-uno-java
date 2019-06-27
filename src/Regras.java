import java.util.List;

public class Regras {

    public int compara(Carta cartaEscolha, Carta topoDescarte){
        if (cartaEscolha instanceof CartaEfeito) {
            cartaEscolha = (CartaEfeito) cartaEscolha;
            if (topoDescarte instanceof CartaEfeito) {
                if (((CartaEfeito) cartaEscolha).getEfeito().equals(((CartaEfeito) topoDescarte).getEfeito())) {
                    return 0;
                } else if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                    return 0;
                } else {
                    return 1;
                }
            }else if (topoDescarte instanceof CartaNumerica) {
                if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                    return 0;
                } else {
                    return 2;
                }
            }else{
                if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                    return 0;
                }else{
                    return 3;
                }
            }
        }else if (cartaEscolha instanceof  CartaNumerica){
            cartaEscolha = (CartaNumerica) cartaEscolha;
            if (topoDescarte instanceof CartaNumerica) {
                if (((CartaNumerica) cartaEscolha).getNumero() == ((CartaNumerica) topoDescarte).getNumero()) {
                  return 0;
                } else if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                    return 0;
                } else {
                    return 4;
                }
            } else if (topoDescarte instanceof CartaEfeito) {
                if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                   return 0;
                } else {
                    return 5;
                }
            }else{
                if ((cartaEscolha).getCor().equals(topoDescarte.getCor())) {
                    return 0;
                }
                else{
                    return 6;
                }
            }
        }else if (cartaEscolha instanceof  CartaCoringa){
            if (!((CartaCoringa) cartaEscolha).getTipo().equals("+4")){
                return 7;
            }else {
                return 8;
            }

        }
        return -1;
    }
    public boolean EscolheCor(Carta cartaEscolha, int vCor){
        if (vCor >3 ||  vCor < 0){
            return false;
        }
        switch (vCor){
            case 0:
                cartaEscolha.setCor("Vermelho");
                break;
            case 1:
                cartaEscolha.setCor("Amarelo");
                break;
            case 2:
                cartaEscolha.setCor("Azul");
                break;
            case 3:
                cartaEscolha.setCor("Verde");
                break;
        }
        return true;

    }
    public boolean primeiraCarta(Carta carta){
        if(carta instanceof CartaEfeito || carta instanceof CartaCoringa){
            return false;
        }
        return true;
    }
    public int ganhou(List<Jogador> jogadores){
        int i;
        for (i=0; i < jogadores.size(); i++){
            if(jogadores.get(i).maoSize() == 0){
                return i;
            }
        }
        return -1;
    }
    protected boolean consegueJogar(Mao mao, Carta topoDescarte){
        int i, aux;
        for(i = 0; i < mao.maoSize(); i++){
            aux = this.compara(mao.verCarta(i), topoDescarte);
            if(aux == 0 || aux >= 7){
                return true;
            }
        }
        return false;
    }
    protected int efeitos(Carta carta){
        if(carta instanceof CartaEfeito){
            if(((CartaEfeito) carta).getEfeito().equals("Pular")){
                return 1;
            }else if(((CartaEfeito) carta).getEfeito().equals("+2")){
                return 2;
            }
        }else if(carta instanceof CartaCoringa){
            if(((CartaCoringa) carta).getTipo().equals("+4")){
                return 3;
            }
        }
        return 0;
    }
    protected boolean isCoringa(Carta carta){
        if (carta instanceof CartaCoringa && ((CartaCoringa) carta).getTipo().equals("+4")){
            return true;
        }
        return false;
    }
    protected boolean podeJogarCoringa(Mao mao, Carta topoDescarte){
        int i, aux;
        for(i = 0; i < mao.maoSize(); i++){
            aux = this.compara(mao.verCarta(i), topoDescarte);
            if(aux == 0 || aux == 7){
                return false;
            }
        }
        return true;
    }
    protected boolean uno(String uno){
        if(uno.toLowerCase().equals("uno")){
            return true;
        }
        return false;
    }


}
