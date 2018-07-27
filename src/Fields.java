import java.awt.Color;


public class Fields {

	private int val = 0;
	private boolean isEditable = false;
	private Color clr = Color.BLACK;
	
	public Fields(int value){
		val = value;
	}
	
	public Fields(){
		
	}
	
	public int getVal(){
		return val;
	}
	
	public void setVal(int newValue){
		val = newValue;
	}
	
	public void setEditable(boolean val){
		isEditable = val;
	}
	
	public boolean getEditable(){
		return isEditable;
	}
	
	public void setColor(Color col){
		clr = col;
	}
	
	public Color getColor(){
		return clr;
	}
}
