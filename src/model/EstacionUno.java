package model;

import java.util.Random;

public class EstacionUno {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double time;
	Random random ;
	
	public EstacionUno(int numCajas){
		System.out.println("------------------------------------------------------------- " + numCajas);
		listAT = new double[numCajas];
		listAAT = new double[numCajas];
		listWT = new double[numCajas];
		listST = new double[numCajas];
		listET = new double[numCajas];
		random = new Random();
	}
	
	public void startStation() {
		fillLists();
		
		random.nextInt();
	}
	
	public void fillLists() {
		for (int i = 0; i < listAT.length; i++) {
			if(i==0) {
				listAT[i] = (random.nextDouble()*30)+10;
				listAAT[i]=listAT[0];
				listWT[i] = 0;
				listST[i] = (Math.random()*25)+15;
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
