package players;

import java.util.ArrayList;

import dados.Lanzar;
import dados.dado;

abstract class Players {

	protected ArrayList<dado> mano; //Todos los jugadores tienen que tener una mano
	//public abstract void Lanzar(int n); //Todos los jugadores tienen que lanzar
	protected int z=2;
	protected String name;
	protected int resultadoINT;
	protected String resultadoo;
	public void Lanzar() {
		Lanzar a=new Lanzar();
		this.mano=a.Lanzamiento();
    }
	
	public ArrayList<dado> getMano(){
		return this.mano;
	}
	
	public void displayDados() {
		System.out.println("Sus dados son estos:");
		System.out.println("0.-"+mano.get(0));
		System.out.println("1.-"+mano.get(1));
		System.out.println("2.-"+mano.get(2));
		System.out.println("3.-"+mano.get(3));
		System.out.println("4.-"+mano.get(4));	
	}

	   public void manoFinal() {

			System.out.println("--------------LA MANO FINAL DE "+this.name+" ES ESTA:-----------------");
			displayDados();
			resultado();
			System.out.println("SU MANO ES:"+this.resultadoo);
	   }
		
	
	public void resultado() {

		ArrayList<ArrayList<dado>> aList =  
                new ArrayList<ArrayList<dado> >(6);
		
		ArrayList<dado> PICAS= new ArrayList<dado>();
		ArrayList<dado> CORAZONES= new ArrayList<dado>();
		ArrayList<dado> JOCKER= new ArrayList<dado>();
		ArrayList<dado> QUEEN= new ArrayList<dado>();
		ArrayList<dado> KING= new ArrayList<dado>();
		ArrayList<dado> AS= new ArrayList<dado>();
		aList.add(PICAS);
		aList.add(CORAZONES);
		aList.add(JOCKER);
		aList.add(QUEEN);
		aList.add(KING);
		aList.add(AS);
		
		
		for (int i = 0; i <5; i++) {
			if(mano.get(i)==dado.PICAS) {
				PICAS.add(mano.get(i));
			}	
			if(mano.get(i)==dado.CORAZONES) {
				CORAZONES.add(mano.get(i));
			}	
			if(mano.get(i)==dado.JOCKER) {
				JOCKER.add(mano.get(i));
			}	
			if(mano.get(i)==dado.QUEEN) {
				QUEEN.add(mano.get(i));
			}	
			if(mano.get(i)==dado.KING) {
				KING.add(mano.get(i));
			}	
			if(mano.get(i)==dado.AS) {
				AS.add(mano.get(i));
			}	
		}
		int par=0; //Esto es para ver cuantos pares tengo
		int tercia=0;
		for (int i = 0; i < 6; i++) {
			if(aList.get(i).size()==5) {
				this.resultadoINT=7; 
				this.resultadoo="Quintilla";
			}
			if(aList.get(i).size()==4) {
				this.resultadoINT=6; 
				this.resultadoo="Pocker";
			}
			if(aList.get(i).size()==2) {
				par++;
			}
			if(aList.get(i).size()==3) {
				tercia++;
			}			
		}
		
		if((par==1)&&(tercia==0)) {
			this.resultadoINT=2;
			this.resultadoo="Par";
		}
		if(par==2) {
			this.resultadoINT=3;
			this.resultadoo="DOS";
		}
		if((tercia==1)&&(par==0)) {
			this.resultadoINT=4;
			this.resultadoo="Tercia";
		}
		if((tercia==1)&&(par==1)) {
			this.resultadoINT=5;
			this.resultadoo="FullHouse";
		}
		if((tercia==0)&&(par==0)) {
			this.resultadoINT=1;
			if(PICAS.size()>0) {
				this.resultadoo="1 PICA";
			}
			if(CORAZONES.size()>0) {
				this.resultadoo="1 CORAZON";
			}
			if(JOCKER.size()>0) {
				this.resultadoo="1 JOCKER";
			}
			if(QUEEN.size()>0) {
				this.resultadoo="1 QUEEN";
			}
			if(KING.size()>0) {
				this.resultadoo="1 KING";
			}
			if(AS.size()>0) {
				this.resultadoo="1 AS";
			}
		}
		
	
		
		
		
		
		
	}
		
		
	
	
}
