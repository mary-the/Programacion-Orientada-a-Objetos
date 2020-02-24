package dados;
import java.util.ArrayList;

public class Lanzar extends Tiro{
	
	public ArrayList<dado> Lanzamiento () {
		ArrayList<dado> mano= new ArrayList<dado>();
		for (int i = 0; i <5; i++) {
			mano.add(Tiro.randomDado());	
		}
		/*for (int i = 0; i <5; i++) {
			System.out.println(mano.get(i));	
		}*/
		return mano;
		
	}

}
