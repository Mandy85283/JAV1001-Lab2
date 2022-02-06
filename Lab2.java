import java.util.Scanner;
import java.util.Arrays; 
public class Lab2
{
    public static void main(String[] args)
	{
		//To scan string to encript from user.
	    System.out.println("Enter a string to encrypt:");
		Scanner myScannerObject = new Scanner(System.in);
		String message = myScannerObject.nextLine();
		//To scan a key from user.
		System.out.println("Enter a key to encrypt with:");
		Scanner myScannerObject1 = new Scanner(System.in);
		int key = myScannerObject1.nextInt();
		//To call and print encryption method.
		System.out.println("The encrypted string is: " + encryption(message,key));
		 
		System.out.println("Decrypting " + encryption(message,key) + " with -"+key);
		//To sacn and print decryption method   
		String encriptvalue = encryption(message,key);
		System.out.println(decryption(encriptvalue,key));
		
		//To scan the length of an array from user.
		System.out.print("Enter the number of elements you want to store: "); 
		int  number = myScannerObject.nextInt();
		int arr[] = Array(number);
		//To call and print Array method.
	    System.out.println("Testing methods with " + Arrays.toString(arr));
		
		//To call and perint average method.   
		System.out.println("The average is " + Average(number,arr));
		
		//To scan a value to check in an array.
        System.out.print("Enter a value to search for: "); 
        int searchedValue = myScannerObject.nextInt();;
		//To call check method.
		check(searchedValue,arr);
		
		// to call and print reverse method.
		System.out.println("The reversed array is " + Arrays.toString(reverse(arr)));
	}
	// Method to encrypt the String.
	static  String encryption(String message, int key)
	{
		String encriptvalue = "";
		char ch;
		int temp;
		for (int i=0; i < message.length() ; i++)
		{
			ch = message.charAt(i);
			if(Character.isLetter(ch))
			{
				temp = ch + key;
				if((Character.isUpperCase(ch))&&temp>90 || (Character.isLowerCase(ch))&&temp>122)
				{
					temp = temp - 26;
				}
			ch = (char) temp;
		    }
		encriptvalue = encriptvalue + ch;
		}
		return encriptvalue;
	}
		   
	// Method to decrypt the String.
	static  String decryption(String encriptvalue, int key)
	{
		String decryptvalue = "";
		char ch;
		int temp;
		for (int j=0; j < encriptvalue.length() ; j++)
		{
			ch = encriptvalue.charAt(j);
			if(Character.isLetter(ch))
			{
				temp = ch - key;
				if((Character.isUpperCase(ch))&&temp<65 || (Character.isLowerCase(ch))&&temp<97)
				{
					temp = temp + 26;
				}
			    ch = (char) temp;
			}
			decryptvalue = decryptvalue + ch;
	    }
		return decryptvalue;
	}
		   
	//Method to create an Array.
    static int[] Array(int number)
	{
		Scanner myScannerObject = new Scanner(System.in);
		System.out.print("Enter the elements of the array: "); 
		int[] array = new int[number];  
		for(int i = 0; i < number; i++)
		{
			array[i] = myScannerObject.nextInt();
		}
        return array;
	}
		
	//Method to calculate an average.
	static double Average(int number, int arr[])
	{
		Scanner myScannerObject = new Scanner(System.in);
		double temp = 0;
		for(int i = 0; i < number; i++)
		{
		    temp += arr[i];
		} 
		double avg = temp/number;
		return avg;		
	}
		
	//Mehod to check a value if present in an array.
	static void check(int searchedValue,int arr[])
    {
        
		boolean found = false;
        for(int x : arr)
		{
	        if(x == searchedValue)
			{
				found = true;
				break;
			}
		}
		if(found == true)
		{
			System.out.println("The array contain: " + searchedValue);
		}
		else
		{
			System.out.println("The array does not contain: " + searchedValue);
		}
    }

//Method to reversed an array.
    static int[] reverse(int arr[])
    {
		int temp;
		for (int i = 0; i < arr.length/2; i++) 
        {
            temp = arr[i];            
            arr[i] = arr[arr.length-1-i];            
            arr[arr.length-1-i] = temp;
        }
	    return arr;
	 }
}
