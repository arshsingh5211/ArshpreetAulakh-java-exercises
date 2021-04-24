package com.techelevator;

public class ExTest {

	public static void main(String[] args) {
		String str = "abxxxcd";
			StringBuilder sb = new StringBuilder(str);
			for (int i = 1; i < sb.length()-1; i++) {
				if (sb.charAt(i) == 'x') {
					sb.deleteCharAt(i);
				}
			}
					System.out.println(sb.toString());
	
	
					String test = "abxxxcd";
					String [] arr = test.split("");
					String ans = "";

					for (int i = 1; i < arr.length-1; i++) {
						if (!arr[i].equals("x")) {
							ans+=arr[i];
						}
					}
					System.out.println(arr[0] + ans + arr[arr.length-1]);
	}
	

}