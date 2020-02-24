package polinomios;

public class Polinomios {
	Monomios inicio=null;
    Monomios fin = null;
    
    //static? 
    private void simplificar(){
    	Monomios aux = inicio;
		Monomios aux2 =inicio.siguiente;
		Monomios ant = inicio;
		if(aux2!=null){
			while(aux!=null){
			while(aux2!=null){
				if(aux2.exponente==aux.exponente){
					aux.coeficiente=aux.coeficiente+aux2.coeficiente;
					if(aux.coeficiente<0){
						aux.signo=45;
					}else{
						aux.signo=43;
					}
					if(aux2==fin){
						fin=ant;
					}else{
						ant.siguiente=aux2.siguiente;
					}
					aux2=ant.siguiente;
				}else{
					aux2=aux2.siguiente;
                                        ant=ant.siguiente;
				}
			}
			aux=aux.siguiente;
			if(aux==null){
			aux2=ant=null;	
			}else{
			aux2=aux.siguiente;
		    	ant=aux;
			}
		}
		}
	
    }
    
    private void unir(Polinomios p2){
    	Monomios aux;
    	if(p2.inicio!=null){
    		aux=p2.inicio;
    		while(p2.inicio!=null){
    			p2.inicio=p2.inicio.siguiente;
    			aux.siguiente=inicio;
    			inicio=aux;
    		    aux=p2.inicio;
    	    }
    	}
        }

					    public void add(int coe, int exp){
					    	Monomios nuevo= nuevoElemento(/*insertar el coeficiente y exponente*/coe,exp);
					    	if((inicio==null)&&(fin == null)){
					    		inicio=nuevo;
					    		fin=nuevo;
					    	}else{
					    		nuevo.siguiente=inicio;
					    		inicio=nuevo;
					    	} 
					        }
    
    private Monomios nuevoElemento(int coe,int exp){
    	Monomios q= new Monomios();
            q.coeficiente=coe;
    	if(q.coeficiente<0){
    		q.coeficiente=q.coeficiente;
    		q.signo=45;
    	}else{
    		q.signo=43;
    	}
    	q.exponente =exp;
    	q.siguiente=null;
    	return q;
        }
    
    public void recorrer (){
    	if(inicio != null){
    		Monomios aux = inicio;
    		while(aux != null){
    			if(aux.coeficiente!=0){
    					if(aux!=inicio){
    				System.out.print(aux.signo);
    			}else if(aux.signo==45){
    			    System.out.print(aux.signo);
    			}
    			if((aux.coeficiente!=1) && (aux.coeficiente!=-1)){
    				if(aux.coeficiente<0){
    					System.out.print(aux.coeficiente*-1);
    				}else{
    					System.out.print(aux.coeficiente);
    				}
    			}else if(aux.exponente==0){
    				if(aux.coeficiente<0){
    					System.out.print(aux.coeficiente*-1);
    				}else{
    					System.out.print(aux.coeficiente);
    				}
    			}
    			if(aux.exponente!=1){
    				if(aux.exponente!=0){
    					System.out.print("x^");
    		    	System.out.print(aux.exponente);
    		    }
    		    
    			}else{
    				System.out.print("x");
    			}
    			}
    			aux=aux.siguiente;
    		}
            }
        }
        
        public void cambiarSigno(){
    		Monomios aux=inicio;
    		while(aux!=null){
    			aux.coeficiente=aux.coeficiente*-1;
    			if(aux.coeficiente<0){
    				aux.signo=45;
    			}else{
    				aux.signo=43;
    			}
    			aux=aux.siguiente;
    		}
    	
        }
        
				        public Polinomios multiplicar(Polinomios lista2){
				    	Monomios aux2=lista2.buscarFinal();
				    	Polinomios multiplo = new Polinomios();
				            Polinomios resultado = new Polinomios();
				    	multiplo.inicio=resultado.inicio=null;
				    	multiplo.fin=resultado.fin=null;
				    	while(aux2!=null){
				    		Monomios aux1=buscarFinal();
				    		while(aux1!=null){
				    		Monomios nuevo=nuevoMonomio(aux1,aux2);
				    		if(multiplo.inicio==null){
				    			multiplo.inicio=nuevo;
				    			multiplo.fin=nuevo;
				    		}else{
				    			nuevo.siguiente=multiplo.inicio;
				    			multiplo.inicio=nuevo;
				    		}
				    		aux1=buscarAuxiliar(aux1);
				    	    }
				    	    
				    	    eliminarYagregar(multiplo,resultado);
				    	    aux2=lista2.buscarAuxiliar(aux2);
				    	}
				    	resultado.simplificar();
				    	//resultado.ordenar();
				            resultado.ordenarBien();
				            return resultado;
				        }
        
        private Monomios nuevoMonomio(Monomios aux1,Monomios aux2){
    	Monomios nuevo = new Monomios();
            nuevo.coeficiente=aux1.coeficiente*aux2.coeficiente;
    	nuevo.exponente=aux1.exponente+aux2.exponente;
    	if(nuevo.coeficiente>0){
    		nuevo.signo=43;
    	}else{
    		nuevo.signo=45;
    	}
    	nuevo.siguiente=null;
    	return nuevo;
        }
        
        private Monomios buscarAuxiliar(Monomios aux){
    	 Monomios prev= new Monomios();
    	if(inicio!=null){
    		if(aux!=inicio){
    		  prev=inicio;
    		  while(prev.siguiente!=aux){
    		  prev=prev.siguiente;
    		  }
    		}else{
    			prev=null;
    		}
    	}
    	return prev;
        }
        
        private Monomios buscarFinal(){
    	Monomios aux = new Monomios();
    	if(inicio!=null){
    		aux=inicio;
    		while(aux.siguiente!=null){
    			aux=aux.siguiente;
    		}
    	}
    	return aux;
        }
        
           
		private void eliminarYagregar(Polinomios lista1,Polinomios lista2){
    	Monomios aux=lista1.inicio;
    	while(aux!=null){
    		lista1.inicio=lista1.inicio.siguiente;
    		aux.siguiente=null;
    		if(lista2==null){
    			lista2.inicio=aux;
    			lista2.fin=aux;
    		}else{
    			aux.siguiente=lista2.inicio;
    			lista2.inicio=aux;
    		}
    		aux=lista1.inicio;
    	}

        }
        
				        public void suma (Polinomios Lista2){
				         unir(Lista2);
				         simplificar();
				         //ordenar();
				         ordenarBien();
				        
				        }
				         
				        public void division (Polinomios Lista2,int CR){
				            ordenarBien();
				            Lista2.ordenarBien();
				            
				            Monomios aux1=inicio;
				            Monomios aux2=Lista2.inicio;
				            Polinomios cociente=new Polinomios();
				            Polinomios jokeC=new Polinomios();
				            Polinomios resto=new Polinomios();
				            //while(aux2.exponente>=aux1.exponente){
				          for(int i=1 ; i<=3;i++){
				                Lista2.ordenarBien();
				                aux2=Lista2.inicio;
				                if(aux2.coeficiente==0){
				                    Lista2.ordenarBien();
				                    System.out.println(aux2.coeficiente);
				                Lista2.cambiarSigno();
				                aux2=Lista2.inicio;
				                aux2=aux2.siguiente;
				                cociente.insertarFinal((aux2.coeficiente/aux1.coeficiente)*-1,(aux2.exponente-aux1.exponente));
				                Lista2.cambiarSigno();
				                }else{
				                cociente.insertarFinal((aux2.coeficiente/aux1.coeficiente),(aux2.exponente-aux1.exponente));}
				                jokeC.insertarFinal((aux2.coeficiente/aux1.coeficiente),(aux2.exponente-aux1.exponente));
				                resto=multiplicar(jokeC);
				                jokeC.inicio=null;
				                resto.cambiarSigno();
				                Lista2.suma(resto);   
				           }
				                if(CR==1){
				                cociente.recorrer();
				                }else{
				                Lista2.recorrer();
				                }    
				        }
				           
				        
       public void insertarFinal (int coe,int exp){
       Monomios nuevo= nuevoElemento(coe,exp);
       if(inicio==null){
         inicio=nuevo;
        } else{
       Monomios aux= inicio;
       while(aux.siguiente!=null){
       aux=aux.siguiente;
       }
       aux.siguiente=nuevo;
       }
       }
       
       private void ordenarBien(){
       Monomios aux=inicio;
       Monomios aux2=inicio.siguiente;
       while(aux2!=null){
       aux2=aux.siguiente;
       while ((aux2!=null)&&(aux.exponente>aux2.exponente)){
       aux=aux2;
       aux2=aux2.siguiente;
       }
       if(aux2!=null){
       aux.siguiente=aux2.siguiente;
       aux2.siguiente=null;
       Monomios aux4=inicio; 
       Monomios aux3=null;
       while((aux4!=null)&&(aux4.exponente>aux2.exponente)){ 
       aux3=aux4;
       aux4=aux4.siguiente;
       }
       if(aux3==null){
       aux2.siguiente=aux4;
       inicio=aux2;
       }else{
       aux2.siguiente=aux4;
       aux3.siguiente=aux2;
       }}}
       }
    


}
