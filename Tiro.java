package dados;
import java.util.Random;

public class Tiro {

	public static dado randomDado() { 
	    int pick = new Random().nextInt(dado.values().length); 
	    return dado.values()[pick]; 
		}
	}
