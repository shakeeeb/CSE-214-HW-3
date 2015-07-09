
public class StringStack {
	private int size = 0;
	private StringNode top;
	/**
	 * constructor with no parameters
	 * overloaded constructor
	 */
	public StringStack(){
		top = null;
	}
	
	public StringStack(String data){
		StringNode initial = new StringNode(data);
		top = initial;
	}
	/**
	 * push String onto the stack
	 * @param data - string to be pushed
	 */
	public void push(String data){
		if (this.isEmpty()){
			StringNode newNode = new StringNode(data);
			top = newNode; size += 1;
		} else {
			StringNode newNode = new StringNode(data);
			newNode.setLink(top);
			top = newNode; size += 1;
		}
	}
	/**
	 * pop string from the stack
	 * @return - String
	 */
	public String pop(){
		try{
		if (this.isEmpty()){
			throw new EmptyStackException();
		} else {
			String result =  top.getData();
			top = top.getLink(); 
			size -= 1;
			return result; 
		}
		} catch (EmptyStackException e){System.out.print("The Stack is Empty");return "";}
	}
	/**
	 * peek at the top value of the stack
	 * @return value stored in the top of the stack
	 */
	public String peek(){
		try{
		if(this.isEmpty()){
			throw new EmptyStackException();
		} else {
			return top.getData();
		}
		} catch(EmptyStackException e){System.out.print("The Stack is Empty");return "";}
	}
	public boolean isEmpty(){
		return (size == 0);
	}
	/**
	 * main reason i built this class
	 * the current size of the stack
	 * @return the number of elements in the class
	 */
	public int count(){
		return size;
	}

}
