package Matrix;

public class NumberOfIslands {
    public static void main(String [] args){
        NumberOfIslands n = new NumberOfIslands();

        int [] [] matrix = new int [] [] {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,0,0,0,0},
                {0,0,1,0,1}
        };
        System.out.println("Number of islands: "+n.findIslands(matrix));
    }

    private int findIslands(int [][] matrix){
        int total =0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return total;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i <row; i++){
            for(int j =0; j< col; j++){

                if(matrix[i][j] == 1){
                    total++;
                    checkAdjacentNodes(matrix, i, j);
                }
            }
        }

        return total;
    }

    private void checkAdjacentNodes(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(i >= 0 && i <row && j >=0 && j < col && matrix[i][j] == 1){
            matrix[i][j] = 0;
            checkAdjacentNodes(matrix, i+1, j);
            checkAdjacentNodes(matrix, i-1, j);
            checkAdjacentNodes(matrix, i, j-1);
            checkAdjacentNodes(matrix, i, j+1);
        }
    }
}
