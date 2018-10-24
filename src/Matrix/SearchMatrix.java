package Matrix;
/*
Search (find position of) a given key in 2D matrix. All rows and columns are sorted.
 */
public class SearchMatrix {
    public static void main(String [] args){
        SearchMatrix s = new SearchMatrix();
        int [] [] matrix = new int [] [] {
                {1, 5, 45, 80, 81},
                {6, 7, 48, 82, 83},
                {20, 22, 49, 85, 86},
                {21, 23, 50, 90, 92}
        };

        int key = 22;
        int []  result = s.searchMatrix(matrix, key);
        if(result != null){
            System.out.println("value "+key + " exists at position ("+result[0]+","+ result[1]+")");
        }
        matrix = new int [] [] {
                {2,4,9,13},
                {3,5,11,18},
                {6,8,16,21},
                {9,11,20,25}
        };

        key = 16;
        result = s.searchMatrix(matrix, key);
        if(result != null){
            System.out.println("value "+key + " exists at position ("+result[0]+","+ result[1]+")");
        }
    }

    private int [] searchMatrix(int [][] matrix, int key){
        int [] result = new int [2];
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        for(int i = 0 ;i < row -1; i++){
            if(matrix[i][0] == key){
                result[0] = i;
                result[1] = 0;
                return result;
            }
            if (matrix[i][0] < key && matrix[i+1][0] > key) {
                startRow = i;
            }
        }

        for(int i = 0 ;i < col -1; i++){
            if(matrix[0][i] == key){
                result[0] = 0;
                result[1] = i;
                return result;
            }
            if (matrix[0][i] < key && matrix[0][i+1] > key) {
                startCol = i;
            }
        }
        for(int i = startRow ; i < row; i ++){
            for(int j = startCol ; j < col; j++){

                if(matrix[i][j] == key){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }


        return result;
    }
}
