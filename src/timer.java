//@author Vincent Fiore
//This is a program that tests the efficiency of HeapSort.
//
//This project uses code from http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html?m=1 
//for the actual sorting implementation. The code for the main method is my own.

import java.util.*;

public class timer
{
	private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    public static void main(String[] args) {
    	
        ArrayList<Long> times = new ArrayList<Long>();
        ArrayList<Long> times2 = new ArrayList<Long>();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of the first array you want to sort.");
    	int runs = keyboard.nextInt();
    	keyboard.close();
        
    	for (int j = 1; j<10; j++){
    	        
    		int myarray[] = new int [runs]; 

    		for (int i = 0 ; i < runs ; i++){ 
    			myarray [i] = (int) (Math.random () * runs); 
    		}
    		
    		
    		//Uncomment this to reveal the unsorted arrays.
    		/*for(int i = 0; i < myarray.length; i++){
            	System.out.print(myarray[i] + " ");
        	}*/
        
    		//System.out.println("");
        
    		long startTime = System.nanoTime();
    		sort(myarray);
    		long endTime = System.nanoTime();
        	long duration = (endTime - startTime);

        	
    		//Uncomment this to reveal the sorted arrays.
        	/*for(int i=0;i<myarray.length;i++){
            	System.out.print(myarray[i] + " ");
        	}*/
        
        	//System.out.println(" ");
        	
        	
        	times.add(duration);
        
    		}
    	
    	//Calculating the average. 
    	//Based on code found at:
    	//http://stackoverflow.com/questions/10465989/calculate-average-or-take-in-an-arraylist-as-a-parameter-to-a-function
    	
    	long sum = 0;
        int n = times.size();
        for (int i = 0; i < n; i++){
            sum += times.get(i);
        }
        
        double avg1 = ((double) sum) / n;
        
        double avg3 = avg1/1000000;
    	
    	System.out.println("It takes " + avg3 + " milliseconds to sort an array of size " + runs + "");
    	
    	
    	
    	
    	for (int j = 1; j<10; j++){
	        
    		int myarray[] = new int [runs*2]; 

    		for (int i = 0 ; i < (runs*2) ; i++){ 
    			myarray [i] = (int) (Math.random () * (runs*2)); 
    		}
        
    		
    		//Uncomment this to reveal the unsorted arrays.
    		/*for(int i = 0; i < myarray.length; i++){
            	System.out.print(myarray[i] + " ");
        	}
        
    		//System.out.println("");
    		 * 
    		 */
    		        
    		long startTime2 = System.nanoTime();
    		sort(myarray);
    		long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	
    		//Uncomment this to reveal the sorted arrays.
        	/*for(int i=0;i<myarray.length;i++){
            	System.out.print(myarray[i] + " ");
        	}*/
        
        	//System.out.println(" ");
        	
        	
        	times2.add(duration2);
        
    		}
    	
    	//Calculating the average.
    	long sum2 = 0;
        int n2 = times2.size();
        for (int i = 0; i < n2; i++){
            sum2 += times2.get(i);
        }
        
        double avg2 = ((double) sum2) / n2;
        
        double avg4 = avg2/1000000;

    	
    	System.out.println("It takes " + avg4 + " milliseconds to sort an array of size " + (2*runs));
    	
    	System.out.println("This is a difference of roughly " + (int)((avg1/avg2)*100) + "%");

    }
}
