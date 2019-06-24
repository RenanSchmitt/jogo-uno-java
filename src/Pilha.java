import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pilha {
    List<Carta> pilha = new ArrayList();

    protected void criaBaralho(){
        int num = 0, i, cont = 0;
        for (i = 0; i < 100; i++){
            if(i < 23) {
                if(num<=9){
                    pilha.add( new CartaNumerica("Verde",num ));
                }else{
                    pilha.add( new CartaEfeito("Verde","+2" ));
                    i++;
                    pilha.add( new CartaEfeito("Verde","Pular" ));
                    cont++;
                }
                cont++;
                if (num == 0) {
                    num = 1;
                    cont = 0;
                } else if (cont == 2) {
                    num++;
                    cont = 0;
                }
            }else if(i < 46){
                if (i == 23){
                    num = 0;
                }
                if(num<=9){
                    pilha.add( new CartaNumerica("Amarelo",num ));
                }else{
                    pilha.add( new CartaEfeito("Amarelo","+2" ));
                    i++;
                    pilha.add( new CartaEfeito("Amarelo","Pular" ));
                    cont++;
                }
                cont++;
                if (num == 0) {
                    num++;
                    cont = 0;
                } else if (cont == 2) {
                    num++;
                    cont = 0;
                }
            }else if(i < 69 ){
                if (i == 46){
                    num = 0;
                }
                if(num<=9){
                    pilha.add( new CartaNumerica("Vermelho",num ));
                }else{
                    pilha.add( new CartaEfeito("Vermelho","+2" ));
                    i++;
                    pilha.add( new CartaEfeito("Vermelho","Pular" ));
                    cont++;
                }
                cont++;
                if (num == 0) {
                    num++;
                    cont = 0;
                } else if (cont == 2) {
                    num++;
                    cont = 0;
                }
            }else if(i < 92){
                if (i == 69){
                    num = 0;
                }
                if(num<=9){
                    pilha.add( new CartaNumerica("Azul",num ));
                }else{
                    pilha.add( new CartaEfeito("Azul","+2" ));
                    i++;
                    pilha.add( new CartaEfeito("Azul","Pular" ));
                    cont++;
                }
                cont++;
                if (num == 0) {
                    num++;
                    cont = 0;
                } else if (cont == 2) {
                    num++;
                    cont = 0;
                }
            }else{
                if(cont < 4){
                    pilha.add( new CartaCoringa("MudaCor"));
                    cont++;
                }else{
                    pilha.add( new CartaCoringa("+4"));
                }
            }

        }
    }
    public void addCarta(Carta carta){
        pilha.add(carta);
    }
    public void resetaBaralho(){
        pilha.clear();
    }
    protected void embaralhaBaralho(){
        Carta aux, aux2;
        int x, i;
        Random sort = new Random();
        int size = pilha.size();
        for(i= 0; i < size; i++){

            x = sort.nextInt(size);
            aux = pilha.get(x);
            aux2 = pilha.get(i);
            pilha.set(i, aux);
            pilha.set(x, aux2);
        }
    }
    public Carta pegaCarta(int num){
        int size = pilha.size();
        if(size <= 0){
            return null;
        }else if( num < size ){

        }
        Carta aux = pilha.get(num);
        pilha.remove(num);
        return aux;
    }

    public Carta pegaCarta(){
        int size = pilha.size();
        if( size <= 0){
            return null;
        }
        Carta aux = pilha.get(size - 1);
        pilha.remove(size - 1);
        return aux;
    }

    public int sizeoff(){
        return pilha.size();
    }

    public String olhaCarta(int num){
        return pilha.get(num).toString();
    }
}
