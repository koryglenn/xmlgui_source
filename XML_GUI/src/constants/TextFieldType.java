package constants;

public enum TextFieldType {
    LONG("long"), MEDIUM("medium"), SHORT("short");
    
    String toPrint;
    
    private TextFieldType(String toPrint){
	this.toPrint = toPrint;
    }

    public String toString(){
	return toPrint;
    }
}

