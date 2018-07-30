/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;


public class EightQueensProblem {

   boolean[][] BB; 
   int    size;

   EightQueensProblem(int n) {
       size = n;
       BB = new boolean[n][n];
   }
	    
   public static void main(String[] argv) {
	   int numberOfQueens = 8; 
	   EightQueensProblem chessBoard = new EightQueensProblem(numberOfQueens);
	   Random random = new Random();
	   int  position = random.nextInt(7) + 0;
	        
	   chessBoard.checkPosition(0, position);

	    }


	    public void dump() {

	        for (int i = 0; i < size ; i++) {
	            String l = "";
	            for (int j = 0; j < size; j++) {
	                if ( BB[i][j]) {
	                    l += " Q";
	                } else {
	                    l += " .";
	                }
	            }
	            System.out.println(l);
	        }
	    }

	    private boolean isValidPos(int x,  int y) {
	        int i, j0, j1, c;    
	        for (i = x-1, c = 1; i >= 0; i--, c++) {
	            // horizontal line check
	            if (BB[i][y]){
	            	
	                return false;
	            }

	            // diagonal1 check 
	            j0 = y - c;
	            if (j0 >= 0 && BB[i][j0]){
	            	
	                return false;
	            }

	            // diagonal2 check
	            j1 = y + c;
	            if (j1 < size && BB[i][j1]){
	            	
	                return false;
	            }
	        }
	        return true;
	    }

	    private boolean checkPosition(int x, int y) {
	        int j;
	        for ( j = y; j < size ; j++) {
	            if (isValidPos(x, j)) {
	                BB[x][j] = true;

	                if (x + 1 >= size ) {
	                    dump();
	                    BB[x][j] = false;

	                    return false;
	                }

	                if (!checkPosition(x+1, 0)) {
	                    return false;
	                }
	                BB[x][j] = false;
	            } 
	        }
	        return true;
	    }
	}
