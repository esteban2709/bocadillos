package model;

import java.util.Random;

/**
 * 
 * @author 
 * 	Correspondiente a Recepcion, lavado y preparacion:
 *	Se utiliza sistema de colas para simular los tiempos 
 *	de los procesos mencionados.
 */
public class EstacionUno {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double time;
	Random random ;
	
	/**
	 * 
	 * @param numCajas Aleatorio (Depende del Clima por ejemplo)
	 */
	public EstacionUno(int numCajas){
		listAT = new double[numCajas];
		listAAT = new double[numCajas];
		listWT = new double[numCajas];
		listST = new double[numCajas];
		listET = new double[numCajas];
		random = new Random();
	}
	
	/**
	 * Comienza el proceso
	 */
	public void startStation() {
		fillLists();
	}
	
	/**
	 * Proceso repetitivo donde se tiene un rango de valores
	 * pseudoaleatorios entre un rango determinado por la complejidad del proceso
	 * en este caso lavar y preparar
	 */
	public void fillLists() {
		for (int i = 0; i < listAT.length; i++) {
			if(i==0) {
				//Lista arrival time
				//Se genera un numero pseudoaleatorio con una distribucion uniforme
				listAT[i] = (random.nextDouble()*30)+10;
				//Lista Arrivla time acumulada
				listAAT[i]=listAT[0];
				//Lista Wait Time
				listWT[i] = 0;
				//Lista Service time
				listST[i] = (Math.random()*25)+15;
				//Lista Exit time
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = (random.nextDouble()*30)+10;
				listAAT[i]= listAAT[i-1]+listAT[i];
				listWT[i] = (Math.max(listET[i-1], listAAT[i]))-listAAT[i];
				listST[i] = (Math.random()*25)+15;
				listET[i]= listAAT[i]+listWT[i]+listST[i];
			}
		}
		
		time = listET[listET.length-1];
	}
	
	public double getTime() {
		return time;
	}
}
