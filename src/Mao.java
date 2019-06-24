import java.util.ArrayList;
import java.util.List;

public class Mao {
    List<Carta> mao  = new ArrayList();

    protected void compra(Carta carta){
        mao.add(carta);
    }
    protected void verMao(){
        for(int i = 0; i < mao.size();i++){
            System.out.println(mao.get(i));
        }
    }
    protected Carta jogaCarta(Carta carta){
        mao.remove(carta);
        return carta;
    }

    protected Carta jogaCarta(int index) {

        Carta aux = mao.get(index);
        mao.remove(index);
        return aux;
    }
}
