
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class BrainFuckInterpreter {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		System.out.print("Input 	: ");
		
		//input String
		StringBuilder s = new StringBuilder(a.nextLine());
		
		System.out.print("Output 	: ");
		
		//variables
		int arr[] = new int[30000]; 	  //for tracking
		int length = s.length();	  //length of brainfuck code
		int loop_count = 0;		  //loop count b/w loops	
		int pointer = 0;		  //pointer
		
		//loop for interpreting
		for(int i = 0; i < length; i++){
			
			if (s.charAt(i) == '+')
				arr[pointer]++;
		
			else if (s.charAt(i) == '-')
				arr[pointer]--;
			
			else if (s.charAt(i) == '<')
				pointer = (pointer == 0) ? length-1 : pointer - 1;
			
			else if (s.charAt(i) == '>')
				pointer = (pointer == length-1) ? 0 : pointer + 1;
			
			else if (s.charAt(i) == '.')
				System.out.print((char)arr[pointer]);
			
			else if (s.charAt(i) == ',')
				arr[pointer] = a.nextInt();
			
			else if (s.charAt(i) == '['){
				
				if (arr[pointer] == 0){
					
					i++;
					
					while (loop_count > 0 || s.charAt(i) != ']'){
						if (s.charAt(i) == '[') loop_count++;
						if (s.charAt(i) == ']') loop_count--;
						
						i++;
					}
					
				}
			}
			
			else if (s.charAt(i)== ']'){
				
				if (arr[pointer] != 0){
					
					i--;
					
					while (loop_count > 0 || s.charAt(i) != '['){
						if (s.charAt(i) == ']') loop_count++;
						if (s.charAt(i) == '[') loop_count--;
						
						i--;
					}
					i--;
					
				}
			}
				
		}
		

	}

}
