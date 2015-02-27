package edu.jsu.mcis;
public class ColumnFullException extends RuntimeException {
	private static final long serialVersionUID = 7728848243630469797L;
	
	public ColumnFullException(String str){
		super(str);
	}
}