package model;

public class EstacionUno {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double time;
	
	public EstacionUno(int numCajas){
		listAT = new double[numCajas];
		listAAT = new double[numCajas];
		listWT = new double[numCajas];
		listST = new double[numCajas];
		listET = new double[numCajas];
	}
	
	public void startStation() {
		fillLists();
	}
	
	public void fillLists() {
		for (int i = 0; i < listAT.length; i++) {
			if(i==0) {
				listAT[i] = (Math.random()*30)+10;
				listAAT[i]=listAT[0];
				listWT[i] = 0;
				listST[i] = (Math.random()*25)+15;
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = (Math.random()*30)+10;
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
