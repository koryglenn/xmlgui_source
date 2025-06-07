package info.helpers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CellPadHelper extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JPanel toBeWrapped;
    
    public CellPadHelper(JPanel toBeWrapped){
	if(toBeWrapped != null) this.toBeWrapped = toBeWrapped;
	else this.toBeWrapped = new JPanel();
	
	setLayout(new GridBagLayout());
	setBorder(new EmptyBorder(0,0,0,4));
	setOpaque(false);
	
	GridBagConstraints gbc1 = new GridBagConstraints();
	gbc1.gridx = 0;
	gbc1.fill = GridBagConstraints.HORIZONTAL;
	gbc1.weightx = 1;
	add(this.toBeWrapped,gbc1);
    }

}
