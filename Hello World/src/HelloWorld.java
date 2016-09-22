
public class HelloWorld {
	public static void main(String[] args) {
		int n = 1000000; //Grenze der Primzahlsuche
		for (int i = 2; i <= n; i++) {
			boolean isPrimzahl = true; //ist es eine Primzahl?
			for (int j = 2; j < i/2 && isPrimzahl; j++) { //Primzahl teilen
				if ((i % j) == 0) {
					isPrimzahl = false;
				}
			}
			if (isPrimzahl) {
				System.out.println(i + " ist eine Primzahl!");
			}
		}
	}

}
