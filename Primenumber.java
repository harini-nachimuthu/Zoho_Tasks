import java.util.Scanner;

public class Primenumber {

	public static boolean isprime(int n) {
			if(n<=1) {
				return false;
			}
			for(int i=2;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					return false;		
				}
			}	
			return true;
		}
	
	public static void main(String[] args) {
		
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter the number till which prime number to be checked :: ");
		int n=obj.nextInt();
		if(n<=1) {
			System.out.println("Not a prime number");
		}else {
			System.out.println("\nThe prime numbers are : ");
			
			for(int i=2;i<=n;i++) {
				if(isprime(i)) {
					System.out.print(i + " ");
				}
				
			}
		}
	}
}
