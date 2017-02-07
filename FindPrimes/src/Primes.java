import java.util.ArrayList;

public class Primes {
	//Start Program Primes
	//Global variables are created for the start and end of the range desired.
	//Also variables for global counters and arrays are created.
	private static long start;
	private static long end;
	private static int counterAr =0;
	private static int counterPrimes;
	private static ArrayList<Long> primes = new ArrayList<Long>();
	private static ArrayList<Long> primes787 = new ArrayList<Long>();
	private static ArrayList<Long> primes939 = new ArrayList<Long>();
	
	public static void main(String[] args) {
		//Main method is started.
		//Values for the start and end variables are stated for the first iteration.
		start = 7870000000L;
		end = 7879999999L;
	
		//The primeCalc method is called with the argument variable end.
		primeCalc(end);
		//Back in the main method, now that these primes are found print the number of primes in counterAr global variable
		System.out.println("Finished finding primes for ceil of sqrt of "+end);
		System.out.println(counterAr);
		
		//The current time is recorded in the startTime variable for later use.
		long startTime = System.currentTimeMillis();
		//The primeNum method is called with the arguments start and end variables.
		primeNum(start,end);
		System.out.println("Finished finding primes from "+start+" to "+end);
		//Back in the main method the counterPrimes is saved in the prime787 variable, the time is saved in endTime and the change in time is calculated and saved 
		int counter787=counterPrimes;
		
		long endTime   = System.currentTimeMillis();
		float time787=(endTime - startTime)/1000;
		
		//The start and end variables are changed for the next iteration.
		start = 9390000000L;
		end = 9399999999L;
		
		//The primeCalc method is called again but now the arguments end variable will be different. Then the counterPrimes variable is printed.
		primeCalc(end);
		System.out.println("Finished finding primes for ceil of sqrt of "+end);
		System.out.println(counterAr);
		
		//The time is taken again and the method primeNum is called again with the arguments start and end variables. Then counterPrimes is saved to counter969.
		startTime = System.currentTimeMillis();
		primeNum(start,end);
		System.out.println("Finished finding primes from "+start+" to "+end);
		int counter939=counterPrimes;
		
		//The time is saved again to endTime and the change in time is calculated and saved in time939.
		endTime   = System.currentTimeMillis();
		float time939=(endTime - startTime)/1000;
		
		//Now that all the calculations are done the program prints the arrays of primes prime787 and prime939, prints the number of primes
		System.out.println("");
		System.out.println(primes787.toString());
		System.out.println("");
		System.out.println(primes939.toString());
		System.out.println("Number of primes between 7870000000 and 7879999999 are :"+counter787);
		System.out.println("In: "+time787+"seconds");
		System.out.println("Number of primes between 9390000000 and 9399999999 are :"+counter939);
		System.out.println("In: "+time939+"seconds");
		System.out.println("Total time for computing both: "+(time787+time939)+"seconds");

	}
	
	public static void primeCalc(long lastNum){
		//This method takes the ceiling of the square root of the last number in the range desired and finds the primes up to that number.
		//Variables for the for loops are defined as well as counter variables.
		long i,j;
		int counter;
		//Add the number 2 to the array list of primes.
		primes.add(2L);
		//For each number from i=0 to the ceiling of the square root of end, add 2 to i.
		for(i=3;i<=Math.ceil(Math.sqrt(lastNum));i+=2){
			//Make counter variable 0.
			counter =0;			
			//For every number from j=3 to the ceiling of the square root of i, add 2 to j
			for(j=3;j<=Math.ceil(Math.sqrt(i));j+=2){
				//If the remainder of i divided by j equal 0
				if(i%j==0){
					//Then add 1 to counter variable and break.
					counter++;
					break;
				}
			}
			//If counter variable equals 0.
			if(counter==0){	
				//Then add 1 counterAR global variable.
				counterAr++;
				primes.add(i);
			}	
		}
	}
	
	public static  void primeNum(long firstNum, long lastNum){
		//This method takes the full range desired and using the array of primes found it looks through the numbers in the range to find the prime numbers.
		//Variables are initialized for the for loops and the counter variables.
		counterPrimes=0;
		long i;
		int k;
		int counter;
		
		//For every number from i=first number of the range to the last number of the array, add 1 to i
		for(i=firstNum; i<= lastNum ;i++){
			//Make counter variable 0.
			counter=0;
			//If the i is not even.
			if(!(i%2==0)){
				//Then for every number from k= 0 to the counterAr variable, add 1 to k.
				for(k=0;k<=counterAr;k++){	
					//If the remainder of i divided by the number in the array list primes in the position k is equal to 0
					if(i%primes.get(k)==0){	
						//Then add 1 to counter variable and break.
						counter++;
						break;
					}
				}
				//If counter variable is equal to 0
				if(counter==0){
					//Then Add 1 to counterPrimes variable, print the i since it is a prime and add 1 to counter2
					counterPrimes++;
					//Checks which of the iterations it is doing and saves the prime found to the respective array list
					if(start==7870000000L){
						primes787.add(i);
					}
					else{
						primes939.add(i);
					}
				}
			}
		}
	}

	
}
