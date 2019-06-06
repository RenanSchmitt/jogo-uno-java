import java.util.Random;

public class BaralhoUno {
    Carta baralho[] = new Carta[100];

    protected void criaBaralho(){
        int num = 0, i, cont = 0;
        for (i = 0; i < 100; i++){
            if(i < 23) {
                if(num<=9){
                    baralho[i] = new CartaNumerica("Verde",num );
                }else{
                    baralho[i] = new CartaEfeito("Verde","+2" );
                    i++;
                    baralho[i] = new CartaEfeito("Verde","Pular" );
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
                    baralho[i] = new CartaNumerica("Amarelo",num );
                }else{
                    baralho[i] = new CartaEfeito("Amarelo","+2" );
                    i++;
                    baralho[i] = new CartaEfeito("Amarelo","Pular" );
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
                    baralho[i] = new CartaNumerica("Vermelho",num );
                }else{
                    baralho[i] = new CartaEfeito("Vermelho","+2" );
                    i++;
                    baralho[i] = new CartaEfeito("Vermelho","Pular" );
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
                    baralho[i] = new CartaNumerica("Azul",num );
                }else{
                    baralho[i] = new CartaEfeito("Azul","+2" );
                    i++;
                    baralho[i] = new CartaEfeito("Azul","Pular" );
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
                    baralho[i] = new CartaCoringa("MudaCor");
                    cont++;
                }else{
                    baralho[i] = new CartaCoringa("+4");
                }
            }

        }
    }

    protected void embaralhaBaralho(){
        Carta aux, aux2;
        int x, i;
        Random sort = new Random();

        for(i= 0; i < 100; i++){

            x = sort.nextInt(100);
            aux = baralho[x];
            aux2 = baralho[i];
            baralho[i] = aux;
            baralho[x] = aux2;
        }
    }
    public Carta pegaCarta(int num){
        return baralho[num];
    }

    public String olhaCarta(int num){
        return baralho[num].toString();
    }
}
