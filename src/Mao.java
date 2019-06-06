import java.util.ArrayList;
import java.util.List;

public class Mao {
    List<Carta> mao  = new ArrayList<Carta>();

    protected void compra(Carta carta){
        mao.add(carta);
    }
    protected void verMao(){
        for(int i = 0; i < mao.size();i++){
            System.out.println(mao.get(i));
        }
    }
    protected void jogaCarta(Carta carta){
        mao.remove(carta);
    }
}
