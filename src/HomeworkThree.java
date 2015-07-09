import java.io.*;
import java.util.StringTokenizer;

/** HomeWork Three
 * 
 * @author Shakeeb saleh
 *
 */
// WARNING: tokenizer does not see \n as a whitespace character. there's nothing i can do about that
// bacasue then, a word and the next word on the next line are seen as a single word
// tokenizer does not recognize regular expressions, so i can't really change that
// it said it was supposed to work for \n, but it doesnt

public class HomeworkThree {
	/**
	 * global variables
	 * inputs is a global tokenizer
	 * thestack is a global stringstack
	 */
	static String text = "";
	static StringTokenizer inputs = new StringTokenizer(text);
	static StringStack theStack = new StringStack();
	
	/**
	 * format 1 is used for functions that dont need to be tabulated.
	 * @return
	 */
	public static String format1(){
		String result = "";
	
		while(inputs.hasMoreTokens()){
			String newWord = "";
				theStack.push(inputs.nextToken());
				String temp = theStack.pop();
				if (temp.equals("for") 
						|| temp.equals("public")
						|| temp.equals("private") 
						|| temp.equals("while") // do whiles are special cases
						|| temp.equals("if") 
						|| temp.equals("try") 
						|| temp.equals("catch")){
					theStack.push(">>"); 
					theStack.push(temp + " ");
					newWord += theStack.pop();
				} else if (temp.contains(";") || temp.contains("{")){
					theStack.push(temp + "\n"); 
					newWord += theStack.pop();
					if (theStack.count()>0){// once it gets to the end of this line
						newWord += tabulate();// check if it needs to tabulate
					}
					//System.out.print(newWord);
				} else { theStack.push(temp); // if its just a regular word
					newWord += theStack.pop() + " ";
				}	
				result += newWord; //System.out.print(result);
			}
		return result;
		}
		
	/**
	 * tabulate is used to tabulate functions
	 * @return
	 */
public static String tabulate(){
		String result = ""; int level = theStack.count(); String temp = "";
		while(inputs.hasMoreTokens()){
			String newWord = ""; String nextLine = "";
			
			theStack.push(inputs.nextToken());
			temp = theStack.pop();
			
				do{
					if (temp.equals("for") 
							|| temp.equals("public")
							|| temp.equals("private") 
							|| temp.equals("while") // do whiles are special cases
							|| temp.equals("if") 
							|| temp.equals("try") 
							|| temp.equals("catch")){
						theStack.push(">>"); 
						theStack.push( temp + " ");
						newWord = theStack.pop();
					} else if (temp.contains(";") || temp.contains("{") || temp.contains("}")){
						break;
					} else { theStack.push(temp); // just a regular word
						newWord = theStack.pop() + " ";
					}
					if(inputs.hasMoreTokens()){
						theStack.push(inputs.nextToken());
						temp = theStack.pop();} else {break;}
						nextLine += newWord; //System.out.print(result);
				} while (!(temp.contains(";")) || !(temp.contains("}")));
				theStack.push(temp + "\n"); // whole line
				nextLine = nextLine + theStack.pop();
				for(int i = 0; i<level;i++){
					nextLine = "\t" + nextLine;
				}
				result += nextLine;
				if(level < theStack.count()){
					break;
				}
				if (theStack.count()>level){
					result += tabulate();// tabulate count times
				}
				 
			}
		return result;
		}
		
	
	public static void main(String[] args){
		
		try {FileInputStream fis = new FileInputStream("src/testing.txt") ; 
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader stdin = new BufferedReader(inStream);
		String fullText = "";
		
		while(stdin.ready()){ // reads in the entire text to fullText
			fullText += stdin.readLine();
		} 
		text = fullText;
		inputs = new StringTokenizer(fullText);
		String answer = "";
		
		answer = format1();
		
		 System.out.print(answer);
		} catch (FileNotFoundException e){System.out.print("File not found");}
		catch (IOException i){System.out.print("IO Exception");}
		
		}
	}



