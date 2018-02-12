package com.interview.questions;

public class Palindrom3
{
  static int x = 11122111;
  static int y = 115556811;
  static int z = 171;
	
	public static void main(String[] args)
	{
		//hfipygw9qr[ger]\qgu31-gjuhrio'ehgw964rjkgrruoqhgwr80gr]yg8rgh
		 System.out.println(Palindrom3.isPalindrome(x));
		 System.out.println(Palindrom3.isPalindrome(y));
		 System.out.println(Palindrom3.isPalindrome(z));
		 System.out.println(Palindrom3.isPalindrome(78952));
	}
	
	private static boolean isPalindrome(Integer u) {
        if (u == 0)
            return false;
        String ir =  Integer.toString(u);
//      StringBuilder isn't thread-safe
        StringBuilder sb = new StringBuilder(ir);
       sb.reverse();     
       return sb.toString().equals(ir);
    }
}
