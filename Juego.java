package Juego;

import java.util.Scanner;

import players.Maquina;
import players.Player;

public class Juego {
	
	public static void main(String[] args) {
		
		System.out.println("****************** C U B I L E T E ***********************");
		System.out.println("Game mode:");
		System.out.println("1.- MAQUINA  VS   TU ");
		System.out.println("2.-PLAYERS");
		
		Scanner respuestas = new Scanner(System.in);
		int respuesta = respuestas.nextInt();
		
		switch(respuesta) {
			case 1:
				Player a=new Player("PLEYER");
				a.Lanzar();
				Maquina b=new Maquina();
				b.Lanzar();
				for (int i = 0; i < 2; i++) {
					System.out.println("*************************************");
					a.jugar();
					System.out.println("*************************************");
					
				}
				a.manoFinal();
				b.manoFinal();
			
			break;
			case 2: 
				System.out.println("Número de jugadores:");
				respuesta = respuestas.nextInt();
				Player c=new Player("PLAYER");
				for (int i = 0; i < respuesta; i++) {
					c.Lanzar();
					System.out.println("*************************************");
					c.jugar();
					System.out.println("*************************************");
					c.manoFinal();
				}
				
			break;
		}
		/*
		Player a=new Player();
		a.Lanzar();
		a.jugar();
		
		
		Maquina b=new Maquina();
		b.Lanzar();
		b.displayDados();
		*/
	}/*
	public void ronda() {
		for (int i = 0; i < 2; i++) {
			System.out.println("*************************************");
			a.jugar();
			System.out.println("*************************************");
			b.displayDados();
			System.out.println("*************************************");
		}
	}*/
}
