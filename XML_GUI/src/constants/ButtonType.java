package constants;

import java.io.Serializable;

public enum ButtonType implements Serializable{
    
    LONG("long"), MEDIUM("medium"), SHORT("short"), EDIT("edit");

    String displayString;
    
    private ButtonType(String displayString){
	this.displayString = displayString;
    }
    
    public String toString(){
	return displayString;
    }
}
