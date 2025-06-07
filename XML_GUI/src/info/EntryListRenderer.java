package info;

import info.helpers.CellPadHelper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import constants.Constants;

public class EntryListRenderer extends JPanel implements ListCellRenderer {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private CellPadHelper westCenterHelpPanel;
    private JPanel westCenterPanel;
    private CellPadHelper westEastHelpPanel;
    private JPanel westEastPanel;
    private CellPadHelper centerHelpPanel;
    private JPanel centerPanel;

    private JLabel titleLabel;
    private JLabel vcnLabel;
    private JLabel descriptionLabel;
    

    public EntryListRenderer() {
	setLayout(new GridBagLayout());
	GridBagConstraints gbc1 =  new GridBagConstraints();
	gbc1.gridx = 0;
	gbc1.fill = GridBagConstraints.HORIZONTAL;
	//gbc1.weightx = .25;
	add(this.getWestCenterHelpPanel(), gbc1);
	
	GridBagConstraints gbc2 = new GridBagConstraints();
	gbc2.gridx = 1;
	gbc2.fill = GridBagConstraints.HORIZONTAL;
	add(this.getWestEastHelpPanel(),gbc2);
	
	GridBagConstraints gbc3 = new GridBagConstraints();
	gbc3.gridx = 2;
	gbc3.weightx = 1;
	gbc3.fill = GridBagConstraints.HORIZONTAL;
	add(this.getCenterHelpPanel(),gbc3);
	setBorder(new CompoundBorder(new MatteBorder(0,0,1,0,Color.gray),new EmptyBorder(4,4,4,0)));
    }

    private CellPadHelper getWestCenterHelpPanel(){
	if(westCenterHelpPanel == null){
	    westCenterHelpPanel = new CellPadHelper(getWestCenterPanel());
	}
	return westCenterHelpPanel;
    }
    private JPanel getWestCenterPanel() {
	if (westCenterPanel == null) {
	    westCenterPanel = new JPanel();
	    westCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    westCenterPanel.add(getTitleLabel());
	    westCenterPanel.setPreferredSize(new Dimension(200,30));
	    westCenterPanel.setOpaque(true);
	}
	return westCenterPanel;
    }

    private JLabel getTitleLabel() {
	if (titleLabel == null) {
	    titleLabel = new JLabel();
	    titleLabel.setFont(Constants.PROJECT_SUB_FONT);
	}
	return titleLabel;
    }
    
    private CellPadHelper getWestEastHelpPanel(){
	if(westEastHelpPanel == null){
	    westEastHelpPanel = new CellPadHelper(getWestEastPanel());
	}
	return westEastHelpPanel;
    }
    
    private JPanel getWestEastPanel() {
	if (westEastPanel == null) {
	    westEastPanel = new JPanel();
	    westEastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    westEastPanel.add(getVCNLabel());
	    westEastPanel.setPreferredSize(new Dimension(100,30));
	    westEastPanel.setOpaque(true);
	}
	return westEastPanel;
    }

    private JLabel getVCNLabel() {
	if (vcnLabel == null) {
	    vcnLabel = new JLabel();
	    vcnLabel.setFont(Constants.PROJECT_SUB_FONT);
	}
	return vcnLabel;
    }

    private CellPadHelper getCenterHelpPanel(){
	if(centerHelpPanel == null){
	    centerHelpPanel = new CellPadHelper(getCenterPanel());
	}
	return centerHelpPanel;
    }
    
    private JPanel getCenterPanel() {
	if (centerPanel == null) {
	    centerPanel = new JPanel();
	    centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    centerPanel.add(getDescriptionLabel());
	    centerPanel.setOpaque(true);
	}
	return centerPanel;
    }

    private JLabel getDescriptionLabel() {
	if (descriptionLabel == null) {
	    descriptionLabel = new JLabel();
	    descriptionLabel.setFont(Constants.PROJECT_SUB_FONT);
	}
	return descriptionLabel;
    }

    private void setTitleLabel(String toSet) {
	this.getTitleLabel().setText(toSet);
    }

    private void setVCNLabel(String toSet) {
	this.getVCNLabel().setText(toSet);
    }

    private void setDescriptionLabel(String toSet) {
	this.getDescriptionLabel().setText(toSet);
    }

    private void updateText(XMLDataWrapper wrap) {
	this.setTitleLabel(wrap.getTitle());
	this.setVCNLabel(wrap.getVcn());
	this.setDescriptionLabel(wrap.getDescription());
    }
    

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
	    int index, boolean isSelected, boolean cellHasFocus) {

	XMLDataWrapper wrap = (XMLDataWrapper) value;
	this.updateText(wrap);

	if (isSelected) {
	    setBackground(list.getSelectionBackground());
	    setForeground(list.getSelectionForeground());
	} else {
	    setBackground(list.getBackground());
	    setForeground(list.getForeground());
	}
	setEnabled(list.isEnabled());
	setOpaque(true);

	return this;
    }

}