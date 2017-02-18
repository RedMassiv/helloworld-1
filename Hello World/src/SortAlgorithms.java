import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
//import java.io.*;

public class SortAlgorithms {
static int berechnungen;
static int speicherzugriffe;
	public static void main(String[] args) throws IOException {
		selectionSortMethode(prepareArray()); //selection sort anwenden
	}
	
	public static int[] prepareArray() throws IOException{
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
	
	public static int getUserInput(String frage, Scanner Scanner) throws IOException{  //user input auslesen
		/*System.out.print(frage + " ");
		BufferedReader r;
		r=new BufferedReader(new InputStreamReader(System.in));
		String aLine=r.readLine();*/
		Scanner scanner = (Scanner);
		do{
			scanner = new Scanner(System.in);
		}
		while (!scanner.hasNextInt());
		return Integer.parseInt(scanner);
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