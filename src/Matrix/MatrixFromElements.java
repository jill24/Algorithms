package Matrix;
/*
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order. For example, given n = 4,
[
[1,   2,  3, 4],
[12, 13, 14, 5],
[11, 16, 15, 6],
[10,  9,  8, 7]
]
 */
public class MatrixFromElements {

    public static void main(String[] args){
        MatrixFromElements m = new MatrixFromElements();
        int n = 4;
        int[][] matrix = m.generateMatrix(n);
        for(int i =0; i< matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        if(n <=0){
            return null;
        }
        int [][] matrix = new int [n][n];

        int num = 1;
        int endNum = n*n;

        int top = 0; int down = n-1;
        int left = 0; int right = n-1;

        while(top <=down && left <= right){

            for(int i = left ; i <= right && num <= endNum; i ++){
                matrix[top][i] = num;
                num++;
            }
            top++;


            for(int i = top ; i <= down && num <= endNum; i ++){
                matrix[i][right] = num;
                num++;
            }
            right--;

            if(top> down){
                break;
            }
            for(int i = right ; i >=left && num <= endNum; i--){
                matrix[down][i] = num;
                num++;
            }
            down--;

            if(left > right){
                break;
            }
            for(int i = down ; i >=top && num <= endNum; i--){
                matrix[i][left] = num;
                num++;
            }

            left++;

            if(num >= endNum++){
                break;
            }
        }

        return matrix;
    }
}
