package Matrix;
/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Time Complexity: O(N)O(N), where NN is the number of pixels in the image. We might process every pixel.

Space Complexity: O(N)O(N), the size of the implicit call stack when calling dfs
 */
public class FloodFill {


    public static void main(String [] args){
        int [][] input = {{1,1,1},{1,1,0},{1,0,1}};
        int row = 1;
        int col = 1;
        int newColor = 2;
        FloodFill f = new FloodFill();
        input = f.floodFill(input, row, col, newColor);
        f.print(input);
    }

    private void print(int[][] input) {
        for(int i = 0 ; i < input.length; i++){
            for(int j=0; j <input[i].length; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || sr <0 || sc <0 || image.length == 0 || image[0].length == 0){
            return null;
        }

        if(image[sr][sc] != newColor){
            fillImage(image, image.length, image[0].length, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private int[][]  fillImage(int[][] image, int row, int col, int sr, int sc, int oldColor, int newColor) {

        if(sr<0 || sr>= row || sc <0 || sc>=col){
            return image;
        }

        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
            fillImage(image, row, col, sr+1, sc, oldColor, newColor);
            fillImage(image, row, col, sr-1, sc, oldColor, newColor);
            fillImage(image, row, col, sr, sc+1, oldColor, newColor);
            fillImage(image, row, col, sr, sc-1, oldColor, newColor);
        }
        return image;
    }

}
