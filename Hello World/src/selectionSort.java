
public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {5, 8, 3, 6, 8, 9, 4, 2};
		for (int c=0; c<list.length; c++){
			System.out.print("["+list[c]+"]");
		}
		System.out.print("\n");
		swap(list,1,2);
		for (int c=0; c<list.length; c++){
			System.out.print("["+list[c]+"]");
		}
	}
	public static void swap (int[] array, int position1, int position2){
		int zwischenspeicher=array[position1];
		array[position1]=array[position2];
		array[position2]=zwischenspeicher;
	}
	public static int findMinimum(int[] array, int startIndex, int endIndex) {
		for 
		return //1
	}
}
