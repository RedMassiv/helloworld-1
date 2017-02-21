//import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class SortAlgorithms {
static int berechnungen;
static int speicherzugriffe;
	public static void main(String[] args) throws IOException {
		int[] selectionSort = prepareArray();
		int[] bubbleSort = Arrays.copyOf(selectionSort, selectionSort.length);
		//outputArray(bubbleSort);  //test ob der clonvorgang gelückt ist
		//if (check2ndLower(selectionSort,1,2)){ selectionSort[3]=10000; }  //der test ob die Methode geht
		//turnArray(selectionSort);  //ebenso der test ob die methode geht
		bubbleSortMethode(bubbleSort);
		selectionSortMethode(selectionSort); //selection sort anwenden
	}
	
	public static int[] prepareArray() throws IOException{   //ein Array erzeugen
		int n = getUserInput("Stellen den Arrays:");

		while (n<0){
			System.out.println("Die länge des Arrays muss über 0 sein!");
			n=getUserInput("Stellen den Arrays:");
		}
		
		int l=getUserInput("Anfang der Zufallszahlen:");
		
		int m=getUserInput("Ende der Zufallszahlen:");
		
		while (m<l){
			System.out.println("Das Ende muss über dem Anfang liegen!");
			m=getUserInput("Ende der Zufallszahlen:");
		}
	
		int[] list = new int[n];  	 //array definieren
		
		fill(list, l, m);  //array mit zufälligen werten füllen
		
		System.out.print("Das unsortierte Array: \n");outputArray(list);    //array anzeigen
		
		return list;
	}
	//langeweile
	public static void bubbleSortMethode(int[] array){
		for (int wieVieleSortiert=0; wieVieleSortiert<=array.length-1;wieVieleSortiert++){
			//System.out.println(wieVieleSortiert);
			if (array.length<20){		//bei kleinen arrays die einzelnen schritte anzeigen
				outputArray(array);
			} else {
				ladeBalken(wieVieleSortiert,array.length);		//bei großen einen ladebalken
			}
			for (int anWelcherStelleTauschen=0; anWelcherStelleTauschen<array.length-1-wieVieleSortiert;anWelcherStelleTauschen++){		//so oft alle einmal durchtauschen, wie das array lang ist
				//System.out.println(anWelcherStelleTauschen);
				//outputArray(array);
				if (anWelcherStelleTauschen<array.length-2){					//wenn es sich nicht um die letzten 2 werte handelt, ganz normal checken und tauschen
					if (check2ndLower(array,anWelcherStelleTauschen,anWelcherStelleTauschen+1)){
						swap(array,anWelcherStelleTauschen,anWelcherStelleTauschen+1);
						//outputArray(array);
					}
				} else {
					if (check2ndLower(array,anWelcherStelleTauschen,anWelcherStelleTauschen+1)){   //wenn die letzten beiden schon stimmen, dann kann man sich einmal durchrechnen sparen
						swap(array,anWelcherStelleTauschen,anWelcherStelleTauschen+1);
						//outputArray(array);
					} else {
						wieVieleSortiert=wieVieleSortiert+1;
						System.out.println("Letzter Wert übersprungen, da schon sortiert");
					}
				}
				
			}
		}
		outputArray(array);  			//das sortierte array anzeigen
		
		if(isSorted(array)){			//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");		//Statistiken zeigen
		System.out.print("Berechnungen: " + berechnungen + "\n");
		berechnungen = 0;
		speicherzugriffe = 0;
		
	}
	
	public static boolean check2ndLower (int[] array, int stelle1, int stelle2){
		berechnungen++;
		if (array[stelle1]>array[stelle2]){
			return true;
		}
		return false;
	}
	
	
	
	public static void selectionSortMethode(int[] array){  //SelectionSort Methode
		
		if(isSorted(array)){
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		for (int i=0; i<array.length;i++){
			int minimum =findMinimum(array,i,array.length);
			
			if(i!=minimum){              //nur tauschen bei zahlen die höher sind und nicht gleich
				swap(array,i,minimum);
			}
			
			
			if (array.length<20){		//bei kleinen arrays die einzelnen schritte anzeigen
				outputArray(array);
			} else {
				ladeBalken(i,array.length);		//bei großen einen ladebalken
			}
		}
		
		outputArray(array);  			//das sortierte array anzeigen
		
		if(isSorted(array)){			//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");		//Statistiken zeigen
		System.out.print("Berechnungen: " + berechnungen + "\n");
		berechnungen = 0;
		speicherzugriffe = 0;
	}
	
	
	public static void swap (int[] array, int position1, int position2){  //Swap methode
		int zwischenspeicher=array[position1];
		array[position1]=array[position2];
		array[position2]=zwischenspeicher;
		speicherzugriffe++;
	}
	
	
	public static int findMinimum(int[] array, int startIndex, int endIndex) { //find minimum
		int currentMinimum = array[startIndex];
		int position = startIndex;
		for (int i=startIndex;i<(endIndex);i++){
			if(array[i]<currentMinimum){
				position=i;
				currentMinimum = array[i];
				berechnungen++;
			}
		}
		return position;
	}
	
	
	public static void outputArray(int[] array){  //output methode
		for (int c=0; c<array.length; c++){
			System.out.print("["+array[c]+"]");
		}
		System.out.print("\n");
	}
	
	public static void fill(int[] array,int start,int ende){  //fill array with random numbers
		for (int c=0; c<array.length; c++){
			Random rand = new Random(); 
			array[c] = rand.nextInt(ende+1-start) + start;
		}
		System.out.print("\n");
	}
	
	public static boolean isSorted(int[] array){  //checken ob das array tatsächlich sortiert ist
		boolean sorted=true;
		int i=0;
		int endIndex=array.length;
		//for (int i=0; sorted && i<endIndex; i++){
		while(sorted && i<endIndex-1){
			if(array[i]>array[i+1]){
				sorted=false;
			}
			i++;
		}
		return sorted;
	}
	
	public static int getUserInput(String frage) throws IOException{  //user input auslesen
		System.out.print(frage + " ");
		BufferedReader r;
		r=new BufferedReader(new InputStreamReader(System.in));
		String aLine=r.readLine();
		return Integer.parseInt(aLine);
		/*Scanner scanner;
		do{
			scanner = new Scanner(System.in);
		}
		while (!scanner.hasNextInt());
		return scanner;*/
	}
	public static void turnArray(int[] array){
		int[] turnedArray = new int [array.length];
		int stelleRück;
		for (int i=0 ; i<array.length; i++){
			stelleRück = array.length-1-i;
			turnedArray[stelleRück] = array[i];
		}
		array = turnedArray;
		outputArray(array);
	}
	
	public static void ladeBalken(int geschafft, int vonMaximum){
		double prozent = geschafft*100/vonMaximum;
		int balken = 50;
		System.out.print("[");
		for (int i=0; i<prozent ; i++) {
			System.out.print("=");
			i=i+1;
			balken=balken-1;
		}

		while (balken>0) {
			System.out.print(" ");
			balken=balken-1;
		}
		System.out.print("] \n");
		
	}
}