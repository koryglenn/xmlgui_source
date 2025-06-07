package constants;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;

public class PButton extends JButton{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PButton(String name, ButtonType type){
	super(name);
	this.setMargin(new Insets(0,0,0,0));
	this.setFont(Constants.PROJECT_SUB_FONT);
	this.putClientProperty("JButton.buttonType","textured");
	switch(type){
	case LONG:
	    this.setPreferredSize(new Dimension(180,25));
	    break;
	case MEDIUM:
	    this.setPreferredSize(new Dimension(125,25));
	    break;
	case SHORT:
	    this.setPreferredSize(new Dimension(75,25));
	    break;
	case EDIT:
	    this.setPreferredSize(new Dimension(50,25));
	    break;
	}
    }
    
}
