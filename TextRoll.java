/**
 * Program Name:	TextRoll.java
 * Purpose: To move progressively through a body of text using spaces to jump between lines 	
 * Coder:	Carlton Branch, 0771107
 * Date: Jul 13, 2016
 */

public class TextRoll {


public static void main(String[] args){
	
	String text =
	  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n"
	+ "Pellentesque non ornare nulla, ultrices blandit dui. \n"
	+ "Proin pellentesque enim vel gravida porttitor. \n"
	+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra,\n"
	+ "per inceptos himenaeos. Suspendisse ornare ac erat non porta. \n"
	+ "Fusce venenatis accumsan purus, a auctor lectus efficitur a. \n"
	+ "In erat dolor, ultrices a pellentesque et, fermentum et massa. \n"
	+ "Ut euismod augue eget nulla pellentesque tempor. \n"
	+ "Nunc placerat pulvinar magna, nec eleifend arcu tincidunt ac. \n"
	+ "Morbi et dolor gravida, convallis augue rhoncus, ultricies leo. \n"
	+ "Ut eleifend elit odio, vel egestas purus feugiat ut. \n"
	+ "Aenean rhoncus quam elit, id placerat eros molestie id. \n"
	+ "Sed auctor hendrerit cursus. Fusce scelerisque condimentum nisl ac sagittis.\n";
			
	//declare and initialize all holder/counter variables
	int	counter = 0;
	boolean newLineFlag = false;
	int lastExit = 0;
	int currExit = 0;
	
	//Iterate through the string text, character by character
	for (int i = 0 ; i < text.length(); ++i){
		//if the newLineFlag is flipped - reset the counter and capture value of last exit
		if (newLineFlag)
		{
			counter = 0;
			newLineFlag = false;
			lastExit = currExit;
		}	
		
		//increment the counter and print text to screen
		counter++;
		System.out.print(text.charAt(i));
		
		//if the ball reaches a space further right than the last exit or the end of file 
		//print an X to mark the exit point and increment to the end of the line or eof
		//capture the current exit point in currExit
		if ( ( text.charAt(i) == ' ' && lastExit < counter ) || i == text.length() - 1 )
		{
			System.out.print('X');
			currExit = counter;
		
			while ( text.charAt(i) != '\n' && i < text.length() - 1 )
			{
				System.out.print(text.charAt(i));
				++i;
			}
		}
		
		//if the text reaches the end of a line or the text body - flip the newLineFlag
		if ( text.charAt( i ) == '\n' || i == text.length() - 1 ) 
		{
			newLineFlag = true;
			System.out.println("");
		}
		
	} 
	//print final results
	System.out.println("==============================");
	System.out.println("The ball will exit at space: " + currExit);
	
	}
}