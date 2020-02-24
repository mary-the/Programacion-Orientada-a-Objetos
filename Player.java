package players;

import java.util.ArrayList;
import java.util.Scanner;

import dados.Lanzar;
import dados.Tiro;
import dados.dado;


public class Player extends Players {
		
	public Player(String n) {
		this.name=n;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
	public void jugar() {
		if(z>0) {
			super.displayDados();
			Pregunta();		
		}
	}
	

	
	
	public void Pregunta() {
			z=z-1;
			Scanner respuestas = new Scanner(System.in);
			System.out.println("Desea cambiar dados?");
			System.out.println("1._Sí");
			System.out.println("2._No");
			int respuesta = respuestas.nextInt(); 
				if(respuesta==1) {
					System.out.println("¿Cuantos?");
					respuesta = respuestas.nextInt();
					int c=respuesta;
					System.out.println("qué dados desea cambiar?");
						for (int i = 0; i < c; i++) {
							respuesta = respuestas.nextInt();
							mano.set(respuesta,Tiro.randomDado());
						}
				}
			
}	
	
	}

	
	
	
	

