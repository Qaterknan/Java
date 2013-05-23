import java.util.Date;

class Hlavni {
	public static void main(String args[]){
		long startCas = new Date().getTime();
		boolean jePrvocislo = false;
		for(int i = 0;i < 1000;i++){
			jePrvocislo = true;
			for(int j = i-1;j > 1;j--){
				if(i%j == 0){
					jePrvocislo = false;
				}
			}
			if(jePrvocislo){
				System.out.println(i);
			}
		}
		long endCas = new Date().getTime();
		System.out.println("Cas vypoctu: ");
		System.out.println(endCas-startCas);
	}
}