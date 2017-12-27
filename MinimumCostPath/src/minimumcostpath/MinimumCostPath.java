package minimumcostpath;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class lowestwithindex {
	lowestwithindex(int l, int i){
		this.lowest = l;
		this.index = i;
		this.route += String.valueOf(i+1);//since the index is zero based
	}
	String route = "";
	int lowest;
	int index;
};
/**
 *
 * @author Parag
 */
public class MinimumCostPath {

    /**
     * @param args the command line arguments
     */
 //int value[][] = {{3,4,1,2,8,6} ,{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
 //int value[][] = {{9,9,5},{3,2,6},{1,2,3}};
 
 // 9,9,5
 // 3,2,6
 // 1,2,3
	
 
 int value[][] = {{3,4,1,2,8,6} ,{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};
 int toproutes[][] ;
 int lowestcostrt = 0;
 String LowestPath = "";
    public static void main(String[] args) {
        MinimumCostPath lcp = new MinimumCostPath();
        int scenario1[][] = {{3,4,1,2,8,6} ,{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
        int scenario2[][] = {{19,10,19,10,19} ,{21,23,20,19,12},{20,12,20,11,10}};
        int scenario3[][] = {{5},{8},{5},{3},{5}};
        int scenario4[][] = {{5,8,5,3,5}};
        int scenario5[][] = {{69,10,19,10,19} ,{51,23,20,19,12},{60,12,20,11,10}};
        int scenario6[][] = {{60,3,3,6} ,{6,3,7,9},{5,6,8,3}};
        int scenario7[][] = {{6,3,-5,9} ,{-5,2,4,10},{3,-2,6,10},{6,-1,-2,10}};
               
        lcp.toproutes = new int[3][7+1];   
        //initialize the top 3 routs to 0
        for (int i = 0; i < 3; i++)
            for (int j =0; j < lcp.value[0].length+1; j++)
              lcp.toproutes[i][j] = 0;
        int lowestrt = 0;

        String path = "";
        //int result = lcp.lowroute(0,2,5,6,50 );
        lowestwithindex result = new lowestwithindex(50, 0);
        for (int r = 0; r < 5; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,5,6,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Sample 1");
        System.out.println(result.lowest);
        System.out.println(result.route);
        //scenario 1
        lcp.value = scenario1;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < 3; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 1: Sample 2");
        System.out.println(result.lowest);
        System.out.println(result.route);

        //scenario 2
        lcp.value = scenario2;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < 3; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 2: Sample 3");
        System.out.println(result.lowest);
        System.out.println(result.route);
        
        //scenario 3
        lcp.value = scenario3;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < lcp.value.length; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 3: Sample 5");
        System.out.println(result.lowest);
        System.out.println(result.route);
        
        //scenario 4
        //this failes cause my aglo takes from behind to find the lowest
        lcp.value = scenario4;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < lcp.value.length; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 4: Sample 4");
        System.out.println(result.lowest);
        System.out.println(result.route);
        //System.out.println(path);
        //scenario 5
        lcp.value = scenario5;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < lcp.value.length; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 5: Sample 8");
        System.out.println(result.lowest);
        System.out.println(result.route);
        
        //scenario 6
        lcp.value = scenario6;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < lcp.value.length; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest && temp.route.length() == (lcp.value[0].length * 2) -1)
        		result = temp;
        }
        System.out.println("Scenario 6: Sample 9");
        System.out.println(result.lowest);
        System.out.println(result.route);
        //scenario 7
        lcp.value = scenario7;
        result = new lowestwithindex(50, 0);
        for (int r = 0; r < lcp.value.length; r++){
        	lowestwithindex temp = lcp.lowroute(0,r,lcp.value.length,lcp.value[0].length,50, 0 );
        	if (result.lowest > temp.lowest)
        		result = temp;
        }
        System.out.println("Scenario 7:Sample 10");
        System.out.println(result.lowest);
        System.out.println(result.route);
        //String LowestPath = "";
//        int result1 = lcp.lowestCostRec(value, 6, 5);
//        System.out.println(result1);
    }

    
    public lowestwithindex lowroute(int col, int r, int rows,int cols, int maxval, int depth){
     
    
     

     
    // String path = "";
    	//if (value[r][col] < 0)
    		//return new lowestwithindex(maxval, r);
    
     //for (int r = 0; r < rows; r++){
      //for each item in row we need to check 3 items in the next col
	      if(col < cols -1){
	    	  int previndex = r == 0 ? rows-1: r-1;
	    	  
	          int nextindex = r==rows-1? 0 : r+1;
	          lowestwithindex temp;
	          lowestwithindex tempprev = lowroute(col+1, previndex, rows, cols, maxval, depth+1);
	          lowestwithindex tempsame = lowroute(col+1, r, rows, cols, maxval, depth+1);
	          lowestwithindex tempnext = lowroute(col+1, nextindex, rows, cols, maxval, depth+1);
	          int cost1 = value[r][col] + tempprev.lowest;
	          int cost2 = value[r][col] + tempsame.lowest;
	          int cost3 = value[r][col] + tempnext.lowest;
	          //System.out.println("Evaluating :" + String.valueOf(r) + "," + String.valueOf(col) + "= " + String.valueOf(value[r][col]) );
	          int lowest = cost1;
	          int lowestindex = previndex;
	          temp = tempprev;
	          if (lowest >= cost2){
	        	  lowestindex = r;
	        	  lowest = cost2;
	        	  temp = tempsame;
	          }	        	  
	          if (lowest >= cost3){
	        	  lowestindex = nextindex;
	        	  lowest = cost3;
	        	  temp = tempnext;
	          }
        	  if (lowest > maxval){
        		  return temp;
        	  }
        	  temp.lowest = lowest;
        	  temp.index = r;
        	  temp.route = String.valueOf(r+1) +"," +temp.route;
          
	          return temp;
	          /*
	          if (cost1 <= cost2 && cost1 <= cost3)
	          {  
	        	  //System.out.print(String.valueOf(previndex) + " ");
	        	  path+=  " " +String.valueOf(previndex);
	        	  System.out.println(path + " " + String.valueOf(cost1));  
	        	 // System.out.println(String.valueOf(previndex) + "," + String.valueOf(col) +  " " + String.valueOf(cost1));
	        	 return cost1;
	          }
	          if (cost2 <= cost1 && cost2 <= cost3){
	        	  path +=  " " +  String.valueOf(r);
	        	  //System.out.println(String.valueOf(r) + "," + String.valueOf(col) +  " " + String.valueOf(cost2));
	        	  System.out.println(path + " " + String.valueOf(cost2));
	        	  return cost2;
	          }
	        	 
	          if (cost3 <= cost1 && cost3 <=cost2){
	        	  path +=  " " +  String.valueOf(nextindex);      	 
	        	 System.out.println(path + " " + String.valueOf(cost3));
	        	  //System.out.println(String.valueOf(nextindex) + "," + String.valueOf(col) +  " " + String.valueOf(cost3));
	        	 return cost3;  
	          }
	          */
	      }
          //System.out.println("Exiting point :" + String.valueOf(r) + "," + String.valueOf(col) + "= "  );
          //System.out.println("Path :" + path  + "Cost : ");

	      return new lowestwithindex(value[r][col], r);
    }
    
    
    public int lowestCost(int [][]value,int m,int n){

        int temp[][] = new int[m][n];

        int sum = 0;

        for(int i=0; i < n; i++){

            temp[0][i] = sum + value[0][i];

            sum = temp[0][i];

        }

        sum = 0;

        for(int i=0; i < m; i++){

            temp[i][0] = sum + value[i][0];

            sum = temp[i][0];

        }

        

        for(int i=1; i < m; i++){

            for(int j=0; j < n; j++){
             int previndex = j == 0 ? n-1: j-1;
             int nextindex = j==n-1? 0 : j+1;
                temp[i][j] = value[i][j] + min(temp[i-1][previndex], temp[i-1][j],temp[i][nextindex]);

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