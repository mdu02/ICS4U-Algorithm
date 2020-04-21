/**
 * Tests whether a 2D array of int is a Toeplitz matrix 
 *                 https://en.wikipedia.org/wiki/Toeplitz_matrix
 * @author ICS4U
 * @version Dec 2019
 */
public class ToeplitzTester{
    public static void main(String [] args){    
        int[][] matrix1 ={{1, 2, 3, 4, 5, 6},
                          {2, 1, 2, 3, 4, 5},
                          {3, 2, 1, 2, 3, 4},
                          {4, 3, 2, 1, 2, 3},
                          {5, 4, 3, 2, 1, 2},
                          {6, 5, 4, 3, 2, 1},
                          {7, 6, 5, 4, 3, 2},
                          {8, 7, 6, 5, 4, 3}};    

        int[][] matrix2 = {{1, 2, 3, 4, 5, 6},
                           {2, 9, 9, 9, 9, 9},
                           {3, 9, 9, 9, 9, 9},
                           {4, 9, 9, 9, 9, 9},
                           {5, 9, 9, 9, 9, 9},
                           {6, 9, 9, 9, 9, 9},
                           {7, 9, 9, 9, 9, 9},
                           {8, 9, 9, 9, 9, 9}};    

        printMatrix(matrix1);
        if (isToeplitz(matrix1))
            System.out.println("This is a Toeplitz matrix.\n");
        else
            System.out.println("This is not a Toeplitz matrix.\n");
        
        printMatrix(matrix2);
        if (isToeplitz(matrix2))
            System.out.println("This is a Toeplitz matrix.\n");
        else
            System.out.println("This is not a Toeplitz matrix.\n");        
    }
//------------------------------------------------------------------------------      
    public static void printMatrix(int[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){   
                System.out.print(matrix[i][j] +", ");
            }
            System.out.println();
        }
    }
//------------------------------------------------------------------------------         
    public static boolean isToeplitz(int[][] matrix){
        return true;    
    } //end of isToeplitz    
} //end of class
