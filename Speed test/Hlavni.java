// import java.util.Date;
import java.util.List;
import java.util.ArrayList;

class Hlavni {
	public static void main(String args[]){
		boolean jePrvocislo = true;
		int maxPrvo = 400000;
		List<Integer> prvocisla = new ArrayList<Integer>();
		prvocisla.add(2);

		for(int i = 3; i < maxPrvo; i+=2){
			jePrvocislo = true;
			double sq = Math.sqrt(i);
			for(int p: prvocisla){
				// System.out.println(p);
				if(p > sq){
					break;
				}
				if(i%p == 0){
					jePrvocislo = false;
				}
			}
			if(jePrvocislo){
				prvocisla.add(i);
			}
		}
		System.out.println(prvocisla);
	}
}