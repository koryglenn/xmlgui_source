package info;

import java.util.ArrayList;

public class XMLDataArrayList {

    private static ArrayList<XMLDataWrapper> xmlDataArrayList;
    private static int IDCounter = 0;

    public static ArrayList<XMLDataWrapper> getXMLDataArrayList() {
	if (xmlDataArrayList == null)
	    xmlDataArrayList = new ArrayList<XMLDataWrapper>();
	return xmlDataArrayList;
    }

    public static void clear() {
	getXMLDataArrayList().clear();
    }

    public static void addXMLDataWrapper(XMLDataWrapper dataWrap) {
	if (dataWrap != null)
	    getXMLDataArrayList().add(dataWrap);
    }
    
    public static int getSize(){
	return getXMLDataArrayList().size();
    }
    
    public static XMLDataWrapper getObjectAt(int i){
	return getXMLDataArrayList().get(i);
    }
    
    public static boolean removeObjectAt(int i){
	if(i < getSize()){
	    getXMLDataArrayList().remove(i);
	    return true;
	}
	return false;
    }
    
    public static boolean removeObject(XMLDataWrapper wrapIn){
	for(int i=0; i<xmlDataArrayList.size();i++){
	    if(xmlDataArrayList.get(i).getEntryID()==wrapIn.getEntryID()){
		xmlDataArrayList.remove(i);
		return true;
	    }
	}
	return false;
    }
    
    public static int getNewID(){
	return IDCounter++;
    }

}
