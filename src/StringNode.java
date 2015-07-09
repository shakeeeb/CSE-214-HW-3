
public class StringNode {
	private String data;
	private StringNode link;
	/**
	 * constructor
	 * @param data
	 */
	public StringNode(){
		
	}
	public StringNode(String data){
		this.data = data;
		this.link = null;
	}
	/**
	 * Overloaded constructor
	 * @param data
	 * @param link
	 */
	public StringNode(String data, StringNode link){
		this.data = data;
		this.link = link;
	}
	/**
	 * get Data
	 * @return data
	 */
	public String getData(){
		return data;
	}
	/**
	 * set Data
	 * @param data
	 */
	public void setData(String data){
		this.data = data;
	}
	/**
	 * get link
	 * @return link
	 */
	public StringNode getLink(){
		return link; 
	}
	/**
	 * set Link
	 * @param newLink
	 */
	public void setLink(StringNode newLink){
		link = newLink;
	}

}
