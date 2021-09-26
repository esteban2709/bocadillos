package model;

public class EstacionTres {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double tiempo;
	public int tamanioMoldes=6;
	public int numMoldes;

	public EstacionTres(double producto){
		numMoldes= (int)producto/tamanioMoldes;
		listAT = new double[numMoldes];
		listAAT = new double[numMoldes];
		listWT = new double[numMoldes];
		listST = new double[numMoldes];
		listET = new double[numMoldes];
	}

	public void startStation(double producto) {
		puntear(producto);
		fillLists();
	}

	public void fillLists() {
		for (int i = 0; i < numMoldes; i++) {
			if(i==0) {
				listAT[i] = 5+(Math.random()*10);
				listAAT[i]= listAT[0];
				listWT[i] = 0;
				listST[i] = 8+(Math.random()*12);
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = 5+(Math.random()*10);
				listAAT[i]= listAAT[i-1]+listAT[i];
				listWT[i] = (Math.max(listET[i-1], listAAT[i]))-listAAT[i];
				listST[i] = 8+(Math.random()*12);
				listET[i]= listAAT[i]+listWT[i]+listST[i];
			}
		}
	}

	public void puntear(double producto) {
		int veces = (int)producto/7;//7 = tamanio de paila
		for (int i = 0; i < veces; i++) {
			if(Math.random() < 0.6) {
				System.out.println("Aun no ha llegado a su punto optimo");
				tiempo+=5;
			}else {
				System.out.println("Llego a su punto optimo despues de "+i +" intentos");
			}
		}
	}

	
	public double getTime() {
		double time = 0;
		try {
			return (tiempo+listET[listET.length-1]);
		} catch (Exception e) {
			System.out.println("#######Error######3");
		}
		
		return time;
	}
}
