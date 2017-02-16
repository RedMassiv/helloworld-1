
public class selectionSort {
static int berechnungen;
static int speicherzugriffe;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {5, 8, 3, 6, 8, 9, 4, 2,2342, 0, -1, 2}; //array definieren
		
		System.out.print("Das unsortierte Array: \n");output(list);    //array anzeigen
		System.out.print("Stellen den Arrays: " + list.length + "\n");
		selectionSort(list);
	}
	public static void selectionSort(int[] array){
		for (int i=0; i<array.length;i++){
			output(array);
			int minimum =findMinimum(array,i,array.length);
			if(i!=minimum)
				swap(array,i,minimum);
		}
		output(array);
		swap(array,3,5);
		output(array);
		if(isSorted(array)){
			System.out.print("Das Array ist sortiert!" + "\n");
		} else {
			System.out.print("Das Array ist noch nicht sortiert!" + "\n");
		}
		System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");
		System.out.print("Berechnungen: " + berechnungen + "\n");
	}
	
	
	public static void swap (int[] array, int position1, int position2){
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
	
	
	public static boolean isSorted(int[] array){
		boolean sorted=true;
		int i=0;
		int endIndex=array.length;
		//for (int i=0; sorted && i<endIndex; i++){
		while(sorted && i<endIndex){
			if(array[i]<array[i+1]){
				sorted=false;
			}
			i++;
		}
		return sorted;
	}
}