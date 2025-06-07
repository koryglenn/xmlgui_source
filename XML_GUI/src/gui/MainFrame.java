package gui;

import gui.dialog.EntryDialogAdd;
import gui.dialog.EntryDialogViewEdit;
import info.XMLDataArrayList;
import info.XMLDataWrapper;
import info.EntryListRenderer;
import info.helpers.CellPadHelper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import constants.ButtonType;
import constants.Constants;
import constants.PButton;

public class MainFrame extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JPanel titlePanel;

    private JPanel centerPanel;
    private JPanel centerNorthPanel;
    private JPanel centerNorth1Panel;
    private JPanel centerNorth2Panel;
    private JPanel centerNorth3Panel;
    private CellPadHelper centerNorth1HelpPanel;
    private CellPadHelper centerNorth2HelpPanel;
    private CellPadHelper centerNorth3HelpPanel;

    private JLabel titleLabel;
    private JLabel vcnLabel;
    private JLabel descriptionLabel;
    private JScrollPane centerPane;
    private JList entryList;

    private JPanel southPanel;
    private PButton addEntryButton;
    private PButton removeEntryButton;
    private PButton editEntryButton;
    private PButton generateButton;

    public MainFrame() {
	setLayout(new BorderLayout());
	setPreferredSize(new Dimension(Constants.FRAME_WIDTH,
		Constants.FRAME_HEIGHT));

	add(getTitlePanel(), BorderLayout.NORTH);
	add(getCenterPanel(), BorderLayout.CENTER);
	add(getSouthPanel(), BorderLayout.SOUTH);
    }

    private JPanel getTitlePanel() {
	if (titlePanel == null) {
	    titlePanel = new JPanel() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
		    g.setColor(Constants.PROJECT_MAIN_COLOR);
		    g.fillRect(0, 0, 3000, Constants.TITLE_HEIGHT);
		    g.setColor(Constants.PROJECT_SUB_COLOR);
		    g.setFont(Constants.PROJECT_MAIN_FONT);
		    g.drawString(
			    Constants.TITLE_STRING,
			    Constants.FRAME_PADDING,
			    (Constants.TITLE_HEIGHT / 2)
				    + (Constants.PROJECT_MAIN_FONT.getSize() / 2));
		}
	    };
	    titlePanel.setPreferredSize(new Dimension(Constants.FRAME_WIDTH,
		    Constants.TITLE_HEIGHT));
	    titlePanel.setBorder(Constants.PROJECT_SUB_BORDER);
	}
	return titlePanel;
    }

    private JPanel getCenterPanel() {
	if (centerPanel == null) {
	    centerPanel = new JPanel();
	    centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    centerPanel.setLayout(new BorderLayout());
	    centerPanel.add(getCenterNorthPanel(), BorderLayout.NORTH);
	    centerPanel.add(getCenterPane(), BorderLayout.CENTER);
	}
	return centerPanel;
    }

    private JPanel getCenterNorthPanel() {
	if (centerNorthPanel == null) {
	    centerNorthPanel = new JPanel();
	    centerNorthPanel.setBorder(new EmptyBorder(6, 6, 6, 2));
	    centerNorthPanel.setLayout(new GridBagLayout());

	    GridBagConstraints gbc1 = new GridBagConstraints();
	    gbc1.gridx = 0;
	    gbc1.fill = GridBagConstraints.HORIZONTAL;
	    centerNorthPanel.add(getCenterNorth1HelpPanel(), gbc1);
	    centerNorthPanel.add(Box.createHorizontalStrut(204),gbc1);

	    GridBagConstraints gbc2 = new GridBagConstraints();
	    gbc2.gridx = 1;
	    gbc2.fill = GridBagConstraints.HORIZONTAL;
	    centerNorthPanel.add(getCenterNorth2HelpPanel(), gbc2);
	    centerNorthPanel.add(Box.createHorizontalStrut(102),gbc2);

	    GridBagConstraints gbc3 = new GridBagConstraints();
	    gbc3.gridx = 2;
	    gbc3.fill = GridBagConstraints.HORIZONTAL;
	    gbc3.weightx = 1;
	    centerNorthPanel.add(getCenterNorth3HelpPanel(), gbc3);
	    centerNorthPanel.setOpaque(true);
	    centerNorthPanel.setBackground(Color.LIGHT_GRAY);
	}
	return centerNorthPanel;
    }

    private CellPadHelper getCenterNorth1HelpPanel() {
	if (centerNorth1HelpPanel == null) {
	    centerNorth1HelpPanel = new CellPadHelper(getCenterNorth1Panel());
	}
	return centerNorth1HelpPanel;
    }

    private JPanel getCenterNorth1Panel() {
	if (centerNorth1Panel == null) {
	    centerNorth1Panel = new JPanel();
	    centerNorth1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    centerNorth1Panel.add(getTitleLabel());
	    centerNorth1Panel.setOpaque(true);
	    centerNorth1Panel.setBackground(Color.gray);
	}
	return centerNorth1Panel;
    }

    private JLabel getTitleLabel() {
	if (titleLabel == null) {
	    titleLabel = new JLabel("title:");
	    titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	    titleLabel.setForeground(Color.white);
	}
	return titleLabel;
    }

    private CellPadHelper getCenterNorth2HelpPanel() {
	if (centerNorth2HelpPanel == null) {
	    centerNorth2HelpPanel = new CellPadHelper(getCenterNorth2Panel());
	}
	return centerNorth2HelpPanel;
    }

    private JPanel getCenterNorth2Panel() {
	if (centerNorth2Panel == null) {
	    centerNorth2Panel = new JPanel();
	    centerNorth2Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    centerNorth2Panel.add(getVCNLabel());
	    centerNorth2Panel.setOpaque(true);
	    centerNorth2Panel.setBackground(Color.gray);

	}
	return centerNorth2Panel;
    }

    private JLabel getVCNLabel() {
	if (vcnLabel == null) {
	    vcnLabel = new JLabel("vcn #:");
	    vcnLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	    vcnLabel.setForeground(Color.white);
	}
	return vcnLabel;
    }

    private CellPadHelper getCenterNorth3HelpPanel() {
	if (centerNorth3HelpPanel == null) {
	    centerNorth3HelpPanel = new CellPadHelper(getCenterNorth3Panel());
	}
	return centerNorth3HelpPanel;
    }

    private JPanel getCenterNorth3Panel() {
	if (centerNorth3Panel == null) {
	    centerNorth3Panel = new JPanel();
	    centerNorth3Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    centerNorth3Panel.add(getDescriptionLabel());
	    centerNorth3Panel.setOpaque(true);
	    centerNorth3Panel.setBackground(Color.gray);

	}
	return centerNorth3Panel;
    }

    private JLabel getDescriptionLabel() {
	if (descriptionLabel == null) {
	    descriptionLabel = new JLabel("description:");
	    descriptionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	    descriptionLabel.setForeground(Color.white);
	}
	return descriptionLabel;
    }

    private JScrollPane getCenterPane() {
	if (centerPane == null) {
	    centerPane = new JScrollPane();
	    centerPane
		    .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    centerPane.setViewportView(getEntryList());
	}
	return centerPane;
    }

    private JList getEntryList() {
	if (entryList == null) {
	    entryList = new JList(new EntryListModel());
	    entryList.setCellRenderer(new EntryListRenderer());
	    entryList.addMouseListener(new DoubleClickListener(entryList));
	}
	return entryList;
    }

    public void refreshPanel() {
	getEntryList().updateUI();
	repaint();
    }

    public void loadEntryDialog(XMLDataWrapper wrap) {
	EntryDialogViewEdit edve = new EntryDialogViewEdit(wrap);
	edve.setVisible(true);
    }

    public void loadAddEntryDialog() {
	EntryDialogAdd eda = new EntryDialogAdd(this);
	eda.setVisible(true);
    }

    private class EntryListModel extends AbstractListModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getSize() {
	    return XMLDataArrayList.getSize();
	}

	@Override
	public Object getElementAt(int index) {
	    return XMLDataArrayList.getObjectAt(index);
	}

    }

    private class DoubleClickListener extends MouseAdapter {
	protected JList list;

	public DoubleClickListener(JList l) {
	    list = l;
	}

	public void mouseClickedEvent(MouseEvent e) {
	    if (e.getClickCount() == 2) {
		if (entryList.getModel().getSize() > 0) {
		    int index = list.locationToIndex(e.getPoint());
		    ListModel lm = list.getModel();
		    XMLDataWrapper wrap = (XMLDataWrapper) (lm
			    .getElementAt(index));
		    refreshPanel();
		    loadEntryDialog(wrap);
		}
	    }
	}

    }

    private JPanel getSouthPanel() {
	if (southPanel == null) {
	    southPanel = new JPanel();
	    southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    southPanel.setLayout(new GridBagLayout());

	    GridBagConstraints gbc1 = new GridBagConstraints();
	    gbc1.gridx = 0;
	    southPanel.add(getAddEntryButton(), gbc1);

	    GridBagConstraints gbc2 = new GridBagConstraints();
	    gbc2.gridx = 1;
	    southPanel.add(Box.createHorizontalStrut(10), gbc2);

	    GridBagConstraints gbc3 = new GridBagConstraints();
	    gbc3.gridx = 2;
	    southPanel.add(getRemoveEntryButton(), gbc3);

	    GridBagConstraints gbc4 = new GridBagConstraints();
	    gbc4.gridx = 3;
	    southPanel.add(Box.createHorizontalStrut(10), gbc4);

	    GridBagConstraints gbc5 = new GridBagConstraints();
	    gbc5.gridx = 4;
	    southPanel.add(getEditEntryButton(), gbc5);

	    GridBagConstraints gbc6 = new GridBagConstraints();
	    gbc6.gridx = 5;
	    southPanel.add(Box.createHorizontalStrut(150));

	    GridBagConstraints gbc7 = new GridBagConstraints();
	    gbc7.gridx = 6;
	    southPanel.add(getGenerateButton(), gbc7);
	}
	return southPanel;
    }

    private PButton getAddEntryButton() {
	if (addEntryButton == null) {
	    addEntryButton = new PButton("Add Entry", ButtonType.MEDIUM);
	    addEntryButton.addActionListener(this);
	}
	return addEntryButton;
    }

    private PButton getRemoveEntryButton() {
	if (removeEntryButton == null) {
	    removeEntryButton = new PButton("Remove Entry", ButtonType.MEDIUM);
	    removeEntryButton.addActionListener(this);
	}
	return removeEntryButton;
    }

    private PButton getEditEntryButton() {
	if (editEntryButton == null) {
	    editEntryButton = new PButton("Edit Entry", ButtonType.MEDIUM);
	    editEntryButton.addActionListener(this);
	}
	return editEntryButton;
    }

    private PButton getGenerateButton() {
	if (generateButton == null) {
	    generateButton = new PButton("Generate XML", ButtonType.MEDIUM);
	    generateButton.addActionListener(this);
	}
	return generateButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == getAddEntryButton()) {
	    loadAddEntryDialog();
	} else if (e.getSource() == getRemoveEntryButton()) {
	    if (getEntryList().getModel().getSize() > 0) {
		switch (JOptionPane.showConfirmDialog(this,
			"Are you sure you want to delete Entry?")) {
		case JOptionPane.YES_OPTION:
		    int index = getEntryList().getSelectedIndex();
		    XMLDataWrapper wrap = (XMLDataWrapper) (getEntryList()
			    .getSelectedValue());
		    XMLDataArrayList.removeObject(wrap);
		    if (index == getEntryList().getModel().getSize()) {
			getEntryList().setSelectedIndex(
				getEntryList().getModel().getSize() - 1);
		    }
		    break;
		case JOptionPane.NO_OPTION:
		    break;
		case JOptionPane.CANCEL_OPTION:
		    break;
		}
		refreshPanel();
	    }
	} else if (e.getSource() == getEditEntryButton()) {
	    if (getEntryList().getModel().getSize() > 0) {
		XMLDataWrapper wrap = (XMLDataWrapper) (getEntryList()
			.getSelectedValue());
		loadEntryDialog(wrap);
	    }
	}
    }

}
