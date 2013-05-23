import java.util.Date;
import java.util.ArrayList;

class Hlavni {
	public static void main(String args[]){
		long startCas = new Date().getTime();
		ArrayList pole = new ArrayList();
		boolean jePrvocislo = false;
		for(int i = 0;i < 100000;i++){
			jePrvocislo = true;
			for(int j = (int) Math.floor(Math.sqrt(i));j > 1;j--){
				if(i%j == 0){
					jePrvocislo = false;
				}
			}
			if(jePrvocislo){
				pole.add(i);
			}
		}
		long endCas = new Date().getTime();
		System.out.println(pole.toString());
		System.out.println("Cas vypoctu: ");
		System.out.println(endCas-startCas);
	}
}