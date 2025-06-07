package constants;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class PTextField extends JTextField {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Font TEXT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    
    public PTextField(String text, TextFieldType type){
	super();
	this.setText(text);
	this.setFont(TEXT_FONT);
	switch(type){
	case LONG:
	    this.setPreferredSize(new Dimension(250,25));
	    break;
	case MEDIUM:
	    this.setPreferredSize(new Dimension(200,25));
	    break;
	case SHORT:
	    this.setPreferredSize(new Dimension(150,25));
	    break;
	}
    }

}
