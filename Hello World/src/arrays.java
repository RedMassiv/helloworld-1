
public class arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] teilnehmer1 = new int[20];
		
		int[] teilnehmer1 = {1,3,5,762,1,243,5,345,1,45,34,6,123,43,578887,16};
		teilnehmer1[1]=1234;
		/*for (int i=0; i<teilnehmer1.length; i++){
			System.out.println(teilnehmer1[i]);
		} */
		for (int element: teilnehmer1){
			System.out.println(element);
		}
		
		int[][] matrix = new int[3][3];
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		
		for (int i=0; i<3; i++){
			for (int b=0; b<3; i++){
				System.out.println(matrix[i][b]);
			}
			
		}
	
	}
 
}
