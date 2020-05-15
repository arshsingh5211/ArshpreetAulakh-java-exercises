package com.techelevator;

import java.util.Scanner;

/*
Write a command line program which prompts the user for a series of decimal integer values  
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);		
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		
		String line = userInput.nextLine();
		String[] decimals = line.split(" ");
		
		for (int i = 0;  i < decimals.length ; i++) {
			int inputNumber = Integer.parseInt(decimals[i]);
			System.out.print(inputNumber + " in binary is ");
			decimalToBinary(inputNumber);
			System.out.println(" ");
		}				     										
	}	
	
	
	public static void decimalToBinary(int inputNumber){
		
		int binaryNumber[] = new int[100];
		int index = 0;
		
		while (inputNumber > 0){
			
			binaryNumber[index++] = inputNumber % 2 ;
			inputNumber /= 2;						
		}
		for (int i = index-1; i >= 0; i--){
		       System.out.print(binaryNumber[i]);
		}		
	}
}