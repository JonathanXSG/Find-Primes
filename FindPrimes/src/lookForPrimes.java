import java.util.ArrayList;

public class lookForPrimes {

	private static long start;
	private static long end;
	private static int counterAr =0;
	private static int counterPrimes=0;
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		start= 7870000000L;
		end= 7879999999L;
		System.out.print("All the primes from 1 to 7,870,000,000)");
		primeNum(start,end,1);
		System.out.println(counterPrimes);

		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	
	public static  void primeNum(long firstNum, long lastNum, int countPrime){
		long i;
		int k;
		int counter;
		ArrayList<Long> primes = new ArrayList<Long>();
		System.out.println("Start");
		primes.add(2L);
		
		for(i=firstNum; i <= lastNum ;i++){
			counter=0;	
			if(i%2==0);
			else{
				for(k=0;k<=(counterAr);k++){
					if(i%primes.get(k)==0){
						counter++;
					}
				}
				if(counter==0){
					counterAr++;				
					
					primes.add((long) i);
					if(countPrime==1){
						counterPrimes++;
					}
					System.out.print(i);
					System.out.print("   ");
					System.out.print(counterAr);
					System.out.print("      ");
					if(counterPrimes%5==0){
						System.out.println();
					}
				}
				
			}		
		}
	}
}
