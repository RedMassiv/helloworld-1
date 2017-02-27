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
		int[] bubbleSort = Arrays.copyOf(selectionSort, selectionSort.length);			//das array clonen, damit jeder algorithmus das unsortierte array sortiert
		int[] shellSort = Arrays.copyOf(selectionSort, selectionSort.length);
		int[] mergeSort = Arrays.copyOf(selectionSort, selectionSort.length);
		mergeSortMethod(mergeSort);
		shellsortMethode(shellSort,shellSort.length);
		selectionSortMethode(selectionSort); 				//selection sort anwenden
		bubbleSortMethode(bubbleSort);	
		turnArray(bubbleSort);
	}
	
	public static int[] prepareArray() throws IOException{   				//ein Array erzeugen
		int n = getUserInput("Stellen den Arrays:");		

		while (n<0){														//errorhadling falls ein geringerer Wert als Endwert eingegeben wird
			System.out.println("Die länge des Arrays muss über 0 sein!");
			n=getUserInput("Stellen den Arrays:");
		}
		
		int l=getUserInput("Anfang der Zufallszahlen:");
		
		int m=getUserInput("Ende der Zufallszahlen:");
		
		while (m<l){
			System.out.println("Das Ende muss über dem Anfang liegen!");
			m=getUserInput("Ende der Zufallszahlen:");
		}
	
		int[] list = new int[n];  	 										//array definieren
		
		fill(list, l, m);  													//array mit zufälligen werten füllen
		
		//System.out.print("Das unsortierte Array: \n");
		//outputArray(list);    //array anzeigen
		
		return list;
	}
	
	public static void mergeSortMethod(int[] array){
		System.out.println("---DualPivotQuickSort/MergeSort Methode---");
		long startTime = System.nanoTime();
		Arrays.sort(array);
		long estimatedTime = System.nanoTime() - startTime;
		if(isSorted(array)){								//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		System.out.println(array.length + " Stellen sortiert in: " + estimatedTime/1000 + "qs");
		
	}
	//langeweile
	public static void bubbleSortMethode(int[] array){
		System.out.println("--------Bubblesort Methode--------");
		long startTime = System.nanoTime();       
		for (int wieVieleSortiert=0; wieVieleSortiert<=array.length-1;wieVieleSortiert++){
			//System.out.println(wieVieleSortiert);
			
			/*if (array.length<20){											//bei kleinen arrays die einzelnen schritte anzeigen
				outputArray(array);
			} else {
				ladeBalken(wieVieleSortiert,array.length);					//bei großen einen ladebalken
			}*/
			
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
		long estimatedTime = System.nanoTime() - startTime;
		//outputArray(array);  								//das sortierte array anzeigen
		
		if(isSorted(array)){								//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");		//Statistiken zeigen
		System.out.print("Berechnungen: " + berechnungen + "\n");
		berechnungen = 0;
		speicherzugriffe = 0;
		
		System.out.println(array.length + " Stellen sortiert in: " + estimatedTime/1000 + "qs");
		
	}
	
	
	static void shellsortMethode (int[] array, int n){
		System.out.println("--------Shellsort Methode--------");
		long startTime = System.nanoTime();
	    int einzusortierendeStelle, j, spaltenAnzahlStelleImSpaltenArray, aktuelleSpalten, einzusortierenderWert;

	    int[] spalten = {2147483647, 1131376761, 410151271, 157840433,			//definieren der verschiedenen Spaltenanzahlen
	    58548857, 21521774, 8810089, 3501671, 1355339, 543749, 213331,
	    84801, 27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};

	    for (spaltenAnzahlStelleImSpaltenArray = 0; spaltenAnzahlStelleImSpaltenArray < spalten.length; spaltenAnzahlStelleImSpaltenArray++){									//alle spaltenanzahlen durchgehen bis am ende nur 1 spalte bleibt
	        aktuelleSpalten = spalten[spaltenAnzahlStelleImSpaltenArray];													//die aktuellen spalten sortieren
	        
	        for (einzusortierendeStelle = aktuelleSpalten; einzusortierendeStelle < n; einzusortierendeStelle++){			// Sortiere die "Spalten" mit Insertionsort
	            einzusortierenderWert = array[einzusortierendeStelle];
	            j = einzusortierendeStelle;
	            while (j >= aktuelleSpalten && array[j-aktuelleSpalten] > einzusortierenderWert){
	                array[j] = array[j-aktuelleSpalten];
		    		speicherzugriffe++;
	                j = j - aktuelleSpalten;									//wer soll das bitte verstehen
	            }
	            berechnungen++;
	            array[j] = einzusortierenderWert;
	    		speicherzugriffe++;
	        }
	    }
	    long estimatedTime = System.nanoTime() - startTime;
	    //outputArray(array);
	    if(isSorted(array)){								//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");		//Statistiken zeigen
		System.out.print("Berechnungen: " + berechnungen + "\n");
		berechnungen = 0;
		speicherzugriffe = 0;
		
		System.out.println(array.length + " Stellen sortiert in: " + estimatedTime/1000 + "qs");
	}

	
	
	public static boolean check2ndLower (int[] array, int stelle1, int stelle2){
		berechnungen++;
		if (array[stelle1]>array[stelle2]){
			return true;
		}
		return false;
	}
	
	
	
	public static void selectionSortMethode(int[] array){  //SelectionSort Methode
		System.out.println("--------Selectionsort Methode--------");
		long startTime = System.nanoTime();

		if(isSorted(array)){
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		for (int i=0; i<array.length;i++){
			int minimum =findMinimum(array,i,array.length);
			
			if(i!=minimum){              					//nur tauschen bei zahlen die höher sind und nicht gleich
				swap(array,i,minimum);
			}
			
			/*
			if (array.length<20){							//bei kleinen arrays die einzelnen schritte anzeigen
				outputArray(array);
			} else {
				ladeBalken(i,array.length);					//bei großen einen ladebalken
			}*/
		}
		long estimatedTime = System.nanoTime() - startTime;
		//outputArray(array);  								//das sortierte array anzeigen
		
		if(isSorted(array)){								//checken ob das array auch tatsächlich soriert ist
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");					//Statistiken zeigen
		System.out.print("Berechnungen: " + berechnungen + "\n");
		berechnungen = 0;
		speicherzugriffe = 0;
		
		System.out.println(array.length + " Stellen sortiert in: " + estimatedTime/1000 + "qs");
	}
	
	
	public static void swap (int[] array, int position1, int position2){  				//Swap methode
		int zwischenspeicher=array[position1];
		array[position1]=array[position2];
		array[position2]=zwischenspeicher;
		speicherzugriffe++;
	}
	
	
	public static int findMinimum(int[] array, int startIndex, int endIndex) { 			//find minimum
		//int currentMinimum = array[startIndex];											
		int position = startIndex;
		for (int i=startIndex;i<(endIndex);i++){										//f
			if(array[i]<array[startIndex]){
				position=i;
				array[startIndex] = array[i];
				berechnungen++;
			}
		}
		return position;
	}
	
	public static void outputArray(int[] array){  							//output methode
		for (int c=0; c<array.length; c++){									//gehe jede stelle im array durch
			System.out.print("["+array[c]+"]");								// und zeige den wert in eckigen klammern an
		}
		System.out.print("\n");
	}
	
	public static void fill(int[] array,int start,int ende){  				//fill array with random numbers
		for (int c=0; c<array.length; c++){									//für jede stelle des arrays
			Random rand = new Random(); 									//wird ein wert generiert
			array[c] = rand.nextInt(ende+1-start) + start;					//zwischen 0 und dem wert in den klammern, und um den anfangswert zu bestimmen werden die zahlen noch mit einem wert addiert
		}
	}
	
	public static boolean isSorted(int[] array){  							//checken ob das array tatsächlich sortiert ist
		boolean sorted=true;												
		int i=0;
		int endIndex=array.length;											
		while(sorted && i<endIndex-1){										//solange alle werte kleiner sind als der darauffolgende, dann ist alles gut und es wird true zurückgegeben
			if(array[i]>array[i+1]){
				sorted=false;												//wenn nicht dann ist das array noch nicht sortiert und es wird false zuzückgegben
			}
			i++;
		}
		return sorted;
	}
	
	public static int getUserInput(String frage) throws IOException{  		//user input auslesen
		System.out.print(frage + " ");										//zeige die übergebene frage an
		BufferedReader r;													//lese den input aus
		r=new BufferedReader(new InputStreamReader(System.in));
		String aLine=r.readLine();											//
		return Integer.parseInt(aLine);										//hier wird der imput in einen Integer umgewandelt und zurückgegeben
	}
	
	public static void turnArray(int[] array){								//methode um das gesamte array zu drehen
		int[] turnedArray = new int [array.length];							//erstelle ein neues leeres array mit derselben länge wie das zu drehende array
		for (int i=0 ; i<array.length; i++){
			turnedArray[array.length-1-i] = array[i];						//gehe in dem vollen array von vorne nach hinten durch und schreibe die Inhalte von hinten anfangend in das leere array
		}
		array = turnedArray;												//überschreibe das alte, übergebene array mit dem neuen sortierten array
		outputArray(array);
	}
	
	public static void ladeBalken(int geschafft, int vonMaximum){			//methode um anzuzeigen wie weit der sortiervorgang schon gerechnet ist
		double prozent = geschafft*100/vonMaximum;						//berechne die Prozent die schon geschafft sind
		int balken = 50;
		System.out.print("[");
		for (int i=0; i<prozent ; i++) {								//für jede 2% zeichne 1 = als ladebalkenanimation
			System.out.print("=");
			i=i+1;
			balken=balken-1;
		}

		while (balken>0) {												//für alle restlichen 2% zeichne ein leerzeichen
			System.out.print(" ");
			balken=balken-1;
		}
		System.out.print("] \n");
		
	}
}