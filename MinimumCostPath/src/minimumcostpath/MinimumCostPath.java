/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumcostpath;

/**
 *
 * @author Parag
 */
public class MinimumCostPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinimumCostPath lcp = new MinimumCostPath();
        int value[][] = {{3,4,1,2,8,6} ,{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
        int result = lcp.lowestCost(value, 4, 5);
        System.out.println(result);
        
//        int result1 = lcp.lowestCostRec(value, 6, 5);
//        System.out.println(result1);
    }
    
    public int lowestCost(int [][]value,int m,int n){

        int temp[][] = new int[m+1][n+1];

        int sum = 0;

        for(int i=0; i <= n; i++){

            temp[0][i] = sum + value[0][i];

            sum = temp[0][i];

        }

        sum = 0;

        for(int i=0; i <= m; i++){

            temp[i][0] = sum + value[i][0];

            sum = temp[i][0];

        }

        

        for(int i=1; i <= m; i++){

            for(int j=1; j <= n; j++){

                temp[i][j] = value[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);

            }

        }
        
        if (temp[m][n] < 50)

        return temp[m][n];
        else
            return 0;

    }
    
     public int lowestCostRec(int value[][], int m, int n){

        return lowestCostRec(value, m, n, 0 , 0);

    }

    public int lowestCostRec(int value[][], int m, int n, int x, int y){

        if(x > m || y > n){

            return Integer.MAX_VALUE;

        }

        if(x == m && y == n){

            return value[m][n];

        }

        int t1 = lowestCostRec(value, m , n, x+1, y);

        int t2 = lowestCostRec(value, m , n, x+1, y+1);

        int t3 = lowestCostRec(value, m , n, x, y+1);

        

        return value[x][y] + min(t1,t2,t3);

    }

    
     private int min(int a,int b, int c){

        int l = Math.min(a, b);

        return Math.min(l, c);

    }
    
    
}
