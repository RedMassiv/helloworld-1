import java.util.Random;
//import java.io.*;

public class selectionSort {
static int berechnungen;
static int speicherzugriffe;
	public static void main(String[] args) {
		//class GetUserInput{}
		int[] list = new int[50];  	 //array definieren
		fill(list);
		System.out.print("Das unsortierte Array: \n");output(list);    //array anzeigen
		System.out.print("Stellen den Arrays: " + list.length + "\n");
		selectionSortMethode(list);
	}
	
	public static void selectionSortMethode(int[] array){  //SelectionSort Methode
		if(isSorted(array)){
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		
		for (int i=0; i<array.length;i++){
			output(array);
			int minimum =findMinimum(array,i,array.length);
			if(i!=minimum)
				swap(array,i,minimum);
		}
		output(array);
		if(isSorted(array)){
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");
		System.out.print("Berechnungen: " + berechnungen + "\n");
	}
	
	
	public static void swap (int[] array, int position1, int position2){  //Swap methode
		int zwischenspeicher=array[position1];
		array[position1]=array[position2];
		array[position2]=zwischenspeicher;
		speicherzugriffe++;
	}
	
	
	public static int findMinimum(int[] array, int startIndex, int endIndex) {
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
	
	
	public static void output(int[] array){
		for (int c=0; c<array.length; c++){
			System.out.print("["+array[c]+"]");
		}
		System.out.print("\n");
	}
	
	public static void fill(int[] array){
		for (int c=0; c<array.length; c++){
			Random rand = new Random(); 
			array[c] = rand.nextInt(101) - 50;
		}
		System.out.print("\n");
	}
	
	
	public static boolean isSorted(int[] array){
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
	
	/*public static int GetUserInput(){ 
		//the data that will be entered by the user String name; 
		//an instance of the BufferedReader class 
		//will be used to read the data 
		BufferedReader reader; 
		//specify the reader variable 
		//to be a standard input buffer 
		reader = new BufferedReader(new InputStreamReader(System.in)); 
		//ask the user for their name 
		System.out.print("What is your name? "); 
		//read the data entered by the user using 
		//the readLine() method of the BufferedReader cimport java.io.*;lass 
		//and store the value in the name variable 
		name = reader.readLine(); 
		return name;
		} 
	} */
}