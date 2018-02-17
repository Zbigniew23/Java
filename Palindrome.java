public class Palindrome
{
  static int a = 11122111;
  static int b = 115739811;
  static int c = 171;
	// sinus cosinus 
  
	public static void main(String[] args)
	{
		Palindrom3 pal = new Palindrom3();
		 System.out.println(Palindrom3.isPalindrome(a));
		 System.out.println(Palindrom3.isPalindrome(b));
		 System.out.println(Palindrom3.isPalindrome(c));
	}
	
	private static boolean isPalindrome(Integer u) {
        if (u == 0)
            return false;
        String ir =  Integer.toString(u);
        StringBuilder sb = new StringBuilder(ir);
       sb.reverse();     
       return sb.toString().equals(ir);
    }
}
