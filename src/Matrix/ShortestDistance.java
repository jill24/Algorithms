package Matrix;

import java.util.LinkedList;
import java.util.Queue;

/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7
 */
public class ShortestDistance {
    public static void main(String [] args){
        ShortestDistance s = new ShortestDistance();
        int [][] grid = {{1,0,2,0,1},
                            {0,0,0,0,0},
                            {0,0,1,0,0}};

        System.out.println(" shortest amount of distance :"+ s.shortestDistance(grid));

    }

    private int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        // maintain grid to check which position is reachable from all bldgs
        int[][] bldgReach = new int[row][col];
        // maintain grid for computing distance from every building
        int[][] distance = new int[row][col];
        //calculate all the bldgs
        int numOfBuildings = 0;

        for(int r =0; r < row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    numOfBuildings++;
                    boolean[][]visited = new boolean[row][col];
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{r, c});
                    int dist = 0;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int i = 0; i <size; i++){
                            int[] node = queue.poll(); // building coordinates
                            int x = node[0];
                            int y = node[1];
                            distance[x][y] +=dist;
                            bldgReach[x][y] ++;

                            if(x>0 && grid[x-1][y] == 0 && !visited[x-1][y]){
                                queue.offer(new int[]{x-1, y});
                                visited[x-1][y] = true;
                            }

                            if(x+1 < row && grid[x+1][y] == 0  && !visited[x+1][y]){
                                queue.offer(new int[]{x+1, y});
                                visited[x+1][y] = true;
                            }

                            if(y>0 && grid[x][y-1] == 0 && !visited[x][y-1]){
                                queue.offer(new int[]{x, y-1});
                                visited[x][y-1] = true;
                            }

                            if(y+1 < col && grid[x][y+1] == 0  && !visited[x][y+1]){
                                queue.offer(new int[]{x, y+1});
                                visited[x][y+1] = true;
                            }
                        }

                        dist++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;

        for(int i = 0; i <row; i ++){
            for(int j=0; j <col; j++){
                if(grid[i][j] == 0 && bldgReach[i][j] == numOfBuildings && distance[i][j] < result ){
                    result = distance[i][j];
                }
            }
        }

        return result == Integer.MAX_VALUE? -1 : result;
    }
}
