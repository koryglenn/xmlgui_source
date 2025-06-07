package gui.dialog;

import gui.MainFrame;
import info.XMLDataArrayList;
import info.XMLDataWrapper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import constants.ButtonType;
import constants.Constants;
import constants.PButton;
import constants.PTextField;
import constants.TextFieldType;

public class EntryDialogAdd extends JDialog implements Serializable, ActionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JPanel headerPanel;
    private JPanel centerPanel;

    private JPanel assetPanel;
    private JPanel providerPanel;
    private JPanel callPanel;
    private JPanel vcnPanel;
    private JPanel sourcePanel;
    private JPanel titlePanel;
    private JPanel descriptionPanel;
    private JPanel launchPanel;
    private JPanel bModePanel;
    private JPanel bSourcePanel;

    private JLabel assetLabel;
    private JLabel providerLabel;
    private JLabel callLabel;
    private JLabel vcnLabel;
    private JLabel sourceLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel launchLabel;
    private JLabel bModeLabel;
    private JLabel bSourceLabel;

    private PTextField assetField;
    private PTextField providerField;
    private PTextField callField;
    private PTextField vcnField;
    private PTextField sourceField;
    private PTextField titleField;
    private PTextField descriptionField;
    private PTextField launchField;
    private PTextField bModeField;
    private PTextField bSourceField;

    private JPanel buttonPanel;
    private PButton acceptButton;
    private PButton cancelButton;
    
    private MainFrame mainFrame;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public EntryDialogAdd(MainFrame mainFrame) {
	this.mainFrame = mainFrame;
	setSize(new Dimension(WIDTH, HEIGHT));
	setLayout(new BorderLayout());

	add(getHeaderPanel(), BorderLayout.NORTH);
	add(getCenterPanel(), BorderLayout.CENTER);
	add(getButtonPanel(),BorderLayout.SOUTH);
    
	KeyboardFocusManager.getCurrentKeyboardFocusManager()
        .addPropertyChangeListener("permanentFocusOwner", new PropertyChangeListener()
    {
        @Override
        public void propertyChange(final PropertyChangeEvent e)
        {

            if (e.getOldValue() instanceof PTextField)
            {
                    SwingUtilities.invokeLater(new Runnable()
                    {
                            @Override
                            public void run()
                            {
                                    PTextField oldTextField = (PTextField)e.getOldValue();
                                    oldTextField.setSelectionStart(0);
                                    oldTextField.setSelectionEnd(0);
                            }
                    });

            }

            if (e.getNewValue() instanceof PTextField)
            {
                    SwingUtilities.invokeLater(new Runnable()
                    {
                            @Override
                            public void run()
                            {
                                    PTextField textField = (PTextField)e.getNewValue();
                                    textField.selectAll();
                            }
                    });

            }
        }
    });
    
    
    
    
    }

    private JPanel getHeaderPanel() {
	if (headerPanel == null) {
	    headerPanel = new JPanel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.setColor(Constants.PROJECT_MAIN_COLOR);
		    g.fillRect(0, 0, getWidth(), getHeight());
		    g.setColor(Constants.PROJECT_SUB_COLOR);
		    g.setFont(Constants.PROJECT_MAIN_FONT);
		    g.drawString("add channel:", 24, getHeight() - 8);
		}
	    };
	    headerPanel.setPreferredSize(new Dimension(WIDTH, 50));
	    headerPanel.setBorder(Constants.PROJECT_SUB_BORDER);
	}
	return headerPanel;
    }

    private JPanel getCenterPanel() {
	if (centerPanel == null) {
	    centerPanel = new JPanel();
	    centerPanel.setLayout(new BoxLayout(centerPanel,
		    BoxLayout.PAGE_AXIS));
	    
	    centerPanel.add(getAssetPanel());
	    centerPanel.add(getProviderPanel());
	    centerPanel.add(getCallPanel());
	    centerPanel.add(getVCNPanel());
	    centerPanel.add(getSourcePanel());
	    centerPanel.add(getTitlePanel());
	    centerPanel.add(getDescriptionPanel());
	    centerPanel.add(getLaunchPanel());
	    centerPanel.add(getBModePanel());
	    centerPanel.add(getBSourcePanel());

	}
	return centerPanel;
    }

    private JPanel getAssetPanel() {
	if (assetPanel == null) {
	    assetPanel = new JPanel();

	    assetPanel.setLayout(new BorderLayout());
	    assetPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    assetPanel.add(getAssetLabel(), BorderLayout.WEST);
	    assetPanel.add(getAssetField(), BorderLayout.CENTER);
	}
	return assetPanel;
    }

    private JLabel getAssetLabel() {
	if (assetLabel == null) {
	    assetLabel = new JLabel(Constants.CELL_PAD + "/rootfolder/assetID");
	    assetLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return assetLabel;
    }

    private PTextField getAssetField() {
	if (assetField == null) {
	    assetField = new PTextField("enter /rootfolder/assetID",
		    TextFieldType.LONG);
	}
	return assetField;
    }

    private JPanel getProviderPanel() {
	if (providerPanel == null) {
	    providerPanel = new JPanel();

	    providerPanel.setLayout(new BorderLayout());
	    providerPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    providerPanel.add(getProviderLabel(), BorderLayout.WEST);
	    providerPanel.add(getProviderField(), BorderLayout.CENTER);
	}
	return providerPanel;
    }

    private JLabel getProviderLabel() {
	if (providerLabel == null) {
	    providerLabel = new JLabel(Constants.CELL_PAD
		    + "/rootfolder/providerID");
	    providerLabel.setPreferredSize(new Dimension(Constants.LABEL_WIDTH,
		    25));
	}
	return providerLabel;
    }

    private PTextField getProviderField() {
	if (providerField == null) {
	    providerField = new PTextField("enter /rootfolder/providerID",
		    TextFieldType.LONG);
	}
	return providerField;
    }

    private JPanel getCallPanel() {
	if (callPanel == null) {
	    callPanel = new JPanel();

	    callPanel.setLayout(new BorderLayout());
	    callPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    callPanel.add(getCallLabel(), BorderLayout.WEST);
	    callPanel.add(getCallField(), BorderLayout.CENTER);
	}
	return callPanel;
    }

    private JLabel getCallLabel() {
	if (callLabel == null) {
	    callLabel = new JLabel(Constants.CELL_PAD + "/callLetters");
	    callLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return callLabel;
    }

    private PTextField getCallField() {
	if (callField == null) {
	    callField = new PTextField("enter /callLetters", TextFieldType.LONG);
	}
	return callField;
    }

    private JPanel getVCNPanel() {
	if (vcnPanel == null) {
	    vcnPanel = new JPanel();

	    vcnPanel.setLayout(new BorderLayout());
	    vcnPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    vcnPanel.add(getVCNLabel(), BorderLayout.WEST);
	    vcnPanel.add(getVCNField(), BorderLayout.CENTER);
	}
	return vcnPanel;
    }

    private JLabel getVCNLabel() {
	if (vcnLabel == null) {
	    vcnLabel = new JLabel(Constants.CELL_PAD + "/vcn");
	    vcnLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return vcnLabel;
    }

    private PTextField getVCNField() {
	if (vcnField == null) {
	    vcnField = new PTextField("enter /vcn", TextFieldType.LONG);
	}
	return vcnField;
    }
    
    private JPanel getSourcePanel() {
	if (sourcePanel == null) {
	    sourcePanel = new JPanel();

	    sourcePanel.setLayout(new BorderLayout());
	    sourcePanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    sourcePanel.add(getSourceLabel(), BorderLayout.WEST);
	    sourcePanel.add(getSourceField(), BorderLayout.CENTER);
	}
	return sourcePanel;
    }

    private JLabel getSourceLabel() {
	if (sourceLabel == null) {
	    sourceLabel = new JLabel(Constants.CELL_PAD + "/sourceId");
	    sourceLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return sourceLabel;
    }

    private PTextField getSourceField() {
	if (sourceField == null) {
	    sourceField = new PTextField("enter /sourceId", TextFieldType.LONG);
	}
	return sourceField;
    }
    
    private JPanel getTitlePanel() {
	if (titlePanel == null) {
	    titlePanel = new JPanel();

	    titlePanel.setLayout(new BorderLayout());
	    titlePanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    titlePanel.add(getTitleLabel(), BorderLayout.WEST);
	    titlePanel.add(getTitleField(), BorderLayout.CENTER);
	}
	return titlePanel;
    }

    private JLabel getTitleLabel() {
	if (titleLabel == null) {
	    titleLabel = new JLabel(Constants.CELL_PAD + "/title");
	    titleLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return titleLabel;
    }

    private PTextField getTitleField() {
	if (titleField == null) {
	    titleField = new PTextField("enter /title", TextFieldType.LONG);
	}
	return titleField;
    }
    
    private JPanel getDescriptionPanel() {
	if (descriptionPanel == null) {
	    descriptionPanel = new JPanel();

	    descriptionPanel.setLayout(new BorderLayout());
	    descriptionPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    descriptionPanel.add(getDescriptionLabel(), BorderLayout.WEST);
	    descriptionPanel.add(getDescriptionField(), BorderLayout.CENTER);
	}
	return descriptionPanel;
    }

    private JLabel getDescriptionLabel() {
	if (descriptionLabel == null) {
	    descriptionLabel = new JLabel(Constants.CELL_PAD + "/description");
	    descriptionLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return descriptionLabel;
    }

    private PTextField getDescriptionField() {
	if (descriptionField == null) {
	    descriptionField = new PTextField("enter /description", TextFieldType.LONG);
	}
	return descriptionField;
    }
    
    private JPanel getLaunchPanel() {
	if (launchPanel == null) {
	    launchPanel = new JPanel();

	    launchPanel.setLayout(new BorderLayout());
	    launchPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    launchPanel.add(getLaunchLabel(), BorderLayout.WEST);
	    launchPanel.add(getLaunchField(), BorderLayout.CENTER);
	}
	return launchPanel;
    }

    private JLabel getLaunchLabel() {
	if (launchLabel == null) {
	    launchLabel = new JLabel(Constants.CELL_PAD + "/launchMode");
	    launchLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return launchLabel;
    }

    private PTextField getLaunchField() {
	if (launchField == null) {
	    launchField = new PTextField("enter /launchMode", TextFieldType.LONG);
	}
	return launchField;
    }
    
    private JPanel getBModePanel() {
	if (bModePanel == null) {
	    bModePanel = new JPanel();

	    bModePanel.setLayout(new BorderLayout());
	    bModePanel.setBorder(new EmptyBorder(10, 10, 0, 10));

	    bModePanel.add(getBModeLabel(), BorderLayout.WEST);
	    bModePanel.add(getBModeField(), BorderLayout.CENTER);
	}
	return bModePanel;
    }

    private JLabel getBModeLabel() {
	if (bModeLabel == null) {
	    bModeLabel = new JLabel(Constants.CELL_PAD + "/barker/mode");
	    bModeLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return bModeLabel;
    }

    private PTextField getBModeField() {
	if (bModeField == null) {
	    bModeField = new PTextField("enter /barker/mode", TextFieldType.LONG);
	}
	return bModeField;
    }
    
    private JPanel getBSourcePanel() {
	if (bSourcePanel == null) {
	    bSourcePanel = new JPanel();

	    bSourcePanel.setLayout(new BorderLayout());
	    bSourcePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

	    bSourcePanel.add(getBSourceLabel(), BorderLayout.WEST);
	    bSourcePanel.add(getBSourceField(), BorderLayout.CENTER);
	}
	return bSourcePanel;
    }

    private JLabel getBSourceLabel() {
	if (bSourceLabel == null) {
	    bSourceLabel = new JLabel(Constants.CELL_PAD + "/barker/sourceId");
	    bSourceLabel
		    .setPreferredSize(new Dimension(Constants.LABEL_WIDTH, 25));
	}
	return bSourceLabel;
    }

    private PTextField getBSourceField() {
	if (bSourceField == null) {
	    bSourceField = new PTextField("enter /barker/sourceId", TextFieldType.LONG);
	}
	return bSourceField;
    }
    
    private JPanel getButtonPanel(){
	if(buttonPanel == null){
	    buttonPanel = new JPanel();
	    buttonPanel.setBorder(new EmptyBorder(20,10,10,10));
	    
	    buttonPanel.add(getAcceptButton());
	    buttonPanel.add(getCancelButton());
	}
	return buttonPanel;
    }
    
    private PButton getAcceptButton(){
	if(acceptButton == null){
	    acceptButton = new PButton("accept",ButtonType.MEDIUM);
	    acceptButton.addActionListener(this);
	}
	return acceptButton;
    }
    
    private PButton getCancelButton(){
	if(cancelButton == null){
	    cancelButton = new PButton("cancel", ButtonType.MEDIUM);
	    cancelButton.addActionListener(this);
	}
	return cancelButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == getCancelButton()){
	    this.setVisible(false);
	}else if(e.getSource() == getAcceptButton()){
	    if((!getAssetField().getText().equalsIgnoreCase("enter /rootfolder/assetId")&&(!getAssetField().getText().equalsIgnoreCase(""))) &&
		    (!getProviderField().getText().equalsIgnoreCase("enter /rootfolder/providerId")&&(!getProviderField().getText().equalsIgnoreCase(""))) &&
		    (!getCallField().getText().equalsIgnoreCase("enter /callLetters")&&(!getCallField().getText().equalsIgnoreCase(""))) &&
		    (!getVCNField().getText().equalsIgnoreCase("enter /vcn")&&(!getVCNField().getText().equalsIgnoreCase(""))) &&
		    (!getSourceField().getText().equalsIgnoreCase("enter /sourceId")&&(!getSourceField().getText().equalsIgnoreCase(""))) &&
		    (!getTitleField().getText().equalsIgnoreCase("enter /title")&&(!getTitleField().getText().equalsIgnoreCase(""))) &&
		    (!getDescriptionField().getText().equalsIgnoreCase("enter /description")&&(!getDescriptionField().getText().equalsIgnoreCase(""))) &&
		    (!getLaunchField().getText().equalsIgnoreCase("enter /launchMode")&&(!getLaunchField().getText().equalsIgnoreCase(""))) &&
		    (!getBModeField().getText().equalsIgnoreCase("enter /barker/mode")&&(!getBModeField().getText().equalsIgnoreCase(""))) &&
		    (!getBSourceField().getText().equalsIgnoreCase("enter /barker/sourceId")&&(!getBSourceField().getText().equalsIgnoreCase("")))){
		XMLDataWrapper wrap = new XMLDataWrapper(getAssetField().getText(),getProviderField().getText(),getCallField().getText(),getVCNField().getText(),
			getSourceField().getText(),getTitleField().getText(),getDescriptionField().getText(),getLaunchField().getText(),getBModeField().getText(),getBSourceField().getText());
		XMLDataArrayList.addXMLDataWrapper(wrap);
		mainFrame.refreshPanel();
		this.setVisible(false);
	    }
	}
	
    }
}
