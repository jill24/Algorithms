package Matrix;

public class SpiralMatrix {
    public static void main(String [] args){
        int [][] arr = {{1,2,3},
                      {4,5,6},
                      {7,8,9}};
        SpiralMatrix m = new SpiralMatrix();
        m.printSpiralMatrix(arr);

        int [][] arr1 = {{1,2,3},
                {4,5,6}};
        m.printSpiralMatrix(arr1);
    }

    private void printSpiralMatrix(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0){
            return;
        }

        int top = 0;
        int down = mat.length -1;
        int left = 0;
        int right = mat[0].length-1;

        while(left<= right && top <= down){

            for(int i = left; i<= right; i++){
                System.out.print(mat[top][i]+ " ");
            }
            top++;

            for(int i = top; i <= down; i ++){
                System.out.print(mat[i][right]+ " ");
            }
            right--;

            if(top> down){
                break;
            }

            for(int i = right; i >=left; i--){
                System.out.print(mat[down][i]+ " ");
            }

            down--;

            if(left > right) {
                break;
            }
            for(int i = down; i >= top; i--){
                System.out.print(mat[i][left]+ " ");
            }

            left++;
        }
        System.out.println();
    }
}
