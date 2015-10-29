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
    
    public static void BubbleSort( int [] num )
    {
         int j;
         boolean flag = true;   // set flag to true to begin first pass
         int temp;   //holding variable

         while ( flag )
         {
                flag= false;    //set flag to false awaiting a possible swap
                for( j=0;  j < num.length -1;  j++ )
                {
                       if ( num[ j ] < num[j+1] )   // change to > for ascending sort
                       {
                               temp = num[ j ];                //swap elements
                               num[ j ] = num[ j+1 ];
                               num[ j+1 ] = temp;
                              flag = true;              //shows a swap occurred  
                      } 
                } 
          } 
    } 

    
    public static void main(String[] args) {
    	
        ArrayList<Long> timesheap1 = new ArrayList<Long>();
        ArrayList<Long> timesheap2 = new ArrayList<Long>();
        
        ArrayList<Long> timesbubble1 = new ArrayList<Long>();
        ArrayList<Long> timesbubble2 = new ArrayList<Long>();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of the first array you want to sort.");
    	int runs = keyboard.nextInt();
    	keyboard.close();
        
    	for (int j = 1; j<10; j++){
    	        
    		int myarray[] = new int [runs]; 
    		int bubblearray[] = new int[runs];

    		for (int i = 0 ; i < runs ; i++){ 
    			myarray [i] = (int) (Math.random () * runs); 
    		}
    		
    		bubblearray = myarray;
    		
    		
    		//Uncomment this to reveal the unsorted arrays.
//    		for(int i = 0; i < myarray.length; i++){
//    			System.out.println("Testing pass: " + i);
//    			if(myarray[i]!= bubblearray[i]){
//    				System.out.print("Uh oh");
//    			}
//            	//System.out.print(myarray[i] + " ");
//        	}
    		//System.out.println("");
        
    		long startTime1 = System.nanoTime();
    		sort(myarray);
    		long endTime1 = System.nanoTime();
        	long duration1 = (endTime1 - startTime1);
        	
    		long startTime2 = System.nanoTime();
    		BubbleSort(bubblearray);
    		long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);

        	
    		//Uncomment this to reveal the sorted arrays.
        	/*for(int i=0;i<myarray.length;i++){
            	System.out.print(myarray[i] + " ");
        	}*/
        
        	//System.out.println(" ");
        	
        	
        	timesheap1.add(duration1);
        	timesbubble1.add(duration2);
        
    		}
    	
    	//Calculating the average. 
    	//Based on code found at:
    	//http://stackoverflow.com/questions/10465989/calculate-average-or-take-in-an-arraylist-as-a-parameter-to-a-function
    	
    	long sum1heap = 0;
        int n = timesheap1.size();
        for (int i = 0; i < n; i++){
            sum1heap += timesheap1.get(i);
        }
        double avg1heap = ((double) sum1heap) / n;
    	System.out.println("It takes " + avg1heap + " to heap sort an array of size " + runs + "");
        
    
    	long sum1bubble = 0;
        for (int i = 0; i < n; i++){
            sum1bubble += timesbubble1.get(i);
        }
        double avg1bubble = ((double) sum1bubble) / n;
    	System.out.println("It takes " + avg1bubble + " to bubble sort an array of size " + runs + "");
    	
    	
    	
    	
    	for (int j = 1; j<10; j++){
	        
    		int myarray[] = new int [runs*2]; 
    		int bubblearray[] = new int[runs*2];


    		for (int i = 0 ; i < (runs*2) ; i++){ 
    			myarray [i] = (int) (Math.random () * (runs*2)); 
    		}
        
    		bubblearray = myarray;
    		
    		//Uncomment this to reveal the unsorted arrays.
//    		for(int i = 0; i < myarray.length; i++){
//            	System.out.print(myarray[i] + " ");
//        	}
//        
//    		System.out.println("");
    		 
    		        
    		long startTime1 = System.nanoTime();
    		sort(myarray);
    		long endTime1 = System.nanoTime();
        	long duration1 = (endTime1 - startTime1);
        	
    		long startTime2 = System.nanoTime();
    		BubbleSort(bubblearray);
    		long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);

        	
    		//Uncomment this to reveal the sorted arrays.
//        	for(int i=0;i<myarray.length;i++){
//            	System.out.print(bubblearray[i] + " ");
//        	}
//        
//        	System.out.println(" ");
        	
        	
        	timesheap2.add(duration1);
        	timesbubble2.add(duration2);
        
    		}
    	
    	//Calculating the average.
    	long sum2heap = 0;
        int n2 = timesheap2.size();
        for (int i = 0; i < n2; i++){
            sum2heap += timesheap2.get(i);
        }
        double avg2heap = ((double) sum2heap) / n2;
    	System.out.println("It takes " + avg2heap + " to heap sort an array of size " + (2*runs));
    	System.out.println("This is a difference of roughly " + (int)((avg1heap/avg2heap)*100) + "%");
    	
    	
    	long sum2bubble = 0;
        for (int i = 0; i < n2; i++){
            sum2bubble += timesbubble2.get(i);
        }
        double avg2bubble = ((double) sum2bubble) / n2;
    	System.out.println("It takes " + avg2bubble + " to bubble sort an array of size " + (2*runs));
    	System.out.println("This is a difference of roughly " + (int)((avg1bubble/avg2bubble)*100) + "%");


    }
}
