import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
//import java.io.*;

public class selectionSort {
static int berechnungen;
static int speicherzugriffe;
	public static void main(String[] args) throws IOException {
		//class GetUserInput{}
		System.out.print("Stellen den Arrays: ");
		BufferedReader r;
		r=new BufferedReader(new InputStreamReader(System.in));
		String aLine=r.readLine();
		int n=Integer.parseInt(aLine);
		
		System.out.print("Anfang der Zufallszahlen: ");
		BufferedReader c;
		c=new BufferedReader(new InputStreamReader(System.in));
		String bLine=c.readLine();
		int l=Integer.parseInt(bLine);
		
		System.out.print("Ende der Zufallszahlen: ");
		BufferedReader d;
		d=new BufferedReader(new InputStreamReader(System.in));
		String cLine=d.readLine();
		int m=Integer.parseInt(cLine);
		
		int[] list = new int[n];  	 //array definieren
		fill(list, l, m);
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
	
	
	public static void output(int[] array){  //output methode
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
}