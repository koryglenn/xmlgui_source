package gui.dialog;

import info.XMLDataWrapper;

import java.io.Serializable;

import javax.swing.JDialog;

public class EntryDialogViewEdit extends JDialog implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private XMLDataWrapper toShow;

    public EntryDialogViewEdit(XMLDataWrapper toShow){
	this.toShow = toShow;
    }
}
