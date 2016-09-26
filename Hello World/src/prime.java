
public class prime {
	static int eintraegeProZeile = 0;

	public static void main(String[] args) {
		int n = 1000; 											//Grenze der Primzahlsuche
		for (int i = 2; i <= n; i++) {							//alle Primzahlen durchtestetn	
			
			if (isPrime(i)) { 									//wenn primzahl, dann Output
				if (eintraegeProZeile == 0){
					System.out.print("Primzahlen sind: ");
					eintraegeProZeile++;
				} else {
					if (eintraegeProZeile<10) {
						System.out.print(i + " ");
						eintraegeProZeile++;
					} else {
						System.out.print(i + " \n");
						eintraegeProZeile = 0;
					}
				}
			}
		}
	}
	
	public static boolean isPrime(int numberTest){  			//ist es eine Primzahl?
		if (numberTest>=2){
			for (int teiler = 2; teiler < numberTest/2; teiler++) { //Primzahl teilen
				if (numberTest%teiler == 0) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}