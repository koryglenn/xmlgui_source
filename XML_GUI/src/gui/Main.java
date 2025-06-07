package gui;

import info.XMLDataArrayList;
import info.XMLDataWrapper;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	
	XMLDataWrapper test1 = new XMLDataWrapper("test","test","test","test","test","This is a test of a long title.","test","test", "test", "test");
	XMLDataWrapper test2 = new XMLDataWrapper("test","test","test","test","test","test","test","test", "test", "test");
	XMLDataWrapper test3 = new XMLDataWrapper("test","test","test","test","test","test","test","test", "test", "test");
	
	XMLDataArrayList.addXMLDataWrapper(test1);
	XMLDataArrayList.addXMLDataWrapper(test2);
	XMLDataArrayList.addXMLDataWrapper(test3);
	MainFrame mf = new MainFrame();
	mf.pack();
	mf.setVisible(true);

    }

}
