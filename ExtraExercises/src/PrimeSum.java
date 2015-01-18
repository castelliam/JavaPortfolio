/**
 * 
 * @author a_mcastelli
 * adds all the prime numbers between 0 and limit(in this case, 1000)
 *
 */

public class PrimeSum {
	
	public int findSum(int limit){
		int sum = 0;
		for(int i = 0; i < limit; i++){
			if(isPrime(i)){
				sum += i;
			}
		}
		return sum;
	}
	
	public Boolean isPrime(int num){
		for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
	}

	public static void main(String[] args){
		PrimeSum p = new PrimeSum();
		System.out.println(p.findSum(1000));
	}
}
