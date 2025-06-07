package info;

import java.io.Serializable;

/**
 * @author Matt Ramsey
 *
 */
public class XMLDataWrapper implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String rootFolderAssetID;
    private String rootFolderProviderID;
    private String callLetters;
    private String vcn;
    private String sourceID;
    private String title;
    private String description;
    private String launchMode;
    private String barkerMode;
    private String barkerSourceID;
    private int entryID;

    /**
     * 
     */
    public XMLDataWrapper() {
	this(new String(), new String(), new String(), new String(),
		new String(), new String(), new String(), new String(),
		new String(), new String());
    }

    /**
     * @param rootFolderAssetID
     * @param rootFolderProviderID
     * @param callLetters
     * @param vcn
     * @param sourceID
     * @param title
     * @param description
     * @param launchMode
     * @param barkerMode
     * @param barkerSourceID
     */
    public XMLDataWrapper(String rootFolderAssetID,
	    String rootFolderProviderID, String callLetters, String vcn,
	    String sourceID, String title, String description,
	    String launchMode, String barkerMode, String barkerSourceID) {
	if (rootFolderAssetID != null)
	    this.rootFolderAssetID = rootFolderAssetID;
	if (rootFolderProviderID != null)
	    this.rootFolderProviderID = rootFolderProviderID;
	if (callLetters != null)
	    this.callLetters = callLetters;
	if (vcn != null)
	    this.vcn = vcn;
	if (sourceID != null)
	    this.sourceID = sourceID;
	if (title != null)
	    this.title = title;
	if (description != null)
	    this.description = description;
	if (launchMode != null)
	    this.launchMode = launchMode;
	if (barkerMode != null)
	    this.barkerMode = barkerMode;
	if (barkerSourceID != null)
	    this.barkerSourceID = barkerSourceID;
	entryID = XMLDataArrayList.getNewID();
    }


    /**
     * @return
     */
    public boolean initialize() {
	return initialize(new XMLDataWrapper());
    }

    /**
     * @param xmlDataWrapperIn
     * @return
     */
    public boolean initialize(XMLDataWrapper xmlDataWrapperIn) {
	if (xmlDataWrapperIn != null) {
	    this.setRootFolderAssetID(xmlDataWrapperIn.getRootFolderAssetID());
	    this.setRootFolderProviderID(xmlDataWrapperIn
		    .getRootFolderProviderID());
	    this.setCallLetters(xmlDataWrapperIn.getCallLetters());
	    this.setVcn(xmlDataWrapperIn.getVcn());
	    this.setSourceID(xmlDataWrapperIn.getSourceID());
	    this.setTitle(xmlDataWrapperIn.getTitle());
	    this.setDescription(xmlDataWrapperIn.getDescription());
	    this.setLaunchMode(xmlDataWrapperIn.getLaunchMode());
	    this.setBarkerMode(xmlDataWrapperIn.getBarkerMode());
	    this.setBarkerSourceID(xmlDataWrapperIn.getBarkerSourceID());
	    this.setEntryID(xmlDataWrapperIn.getEntryID());
	    return true;
	}
	return false;
    }

 
    public XMLDataWrapper clone(){
	XMLDataWrapper out = new XMLDataWrapper();
	out.initialize(this);
	return out;
    }
    
    /**
     * @return
     */
    public String getRootFolderAssetID() {
	if (rootFolderAssetID == null)
	    rootFolderAssetID = new String();
	return rootFolderAssetID;
    }

    /**
     * @param rootFolderAssetID
     */
    public void setRootFolderAssetID(String rootFolderAssetID) {
	this.rootFolderAssetID = rootFolderAssetID;
    }

    /**
     * @return
     */
    public String getRootFolderProviderID() {
	if (rootFolderProviderID == null)
	    rootFolderProviderID = new String();
	return rootFolderProviderID;
    }

    /**
     * @param rootFolderProviderID
     */
    public void setRootFolderProviderID(String rootFolderProviderID) {
	this.rootFolderProviderID = rootFolderProviderID;
    }

    /**
     * @return
     */
    public String getCallLetters() {
	if (callLetters == null)
	    callLetters = new String();
	return callLetters;
    }

    /**
     * @param callLetters
     */
    public void setCallLetters(String callLetters) {
	this.callLetters = callLetters;
    }

    /**
     * @return
     */
    public String getVcn() {
	if (vcn == null)
	    vcn = new String();
	return vcn;
    }

    /**
     * @param vcn
     */
    public void setVcn(String vcn) {
	this.vcn = vcn;
    }

    /**
     * @return
     */
    public String getSourceID() {
	if (sourceID == null)
	    sourceID = new String();
	return sourceID;
    }

    /**
     * @param sourceID
     */
    public void setSourceID(String sourceID) {
	this.sourceID = sourceID;
    }

    /**
     * @return
     */
    public String getTitle() {
	if (title == null)
	    title = new String();
	return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return
     */
    public String getDescription() {
	if (description == null)
	    description = new String();
	return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return
     */
    public String getLaunchMode() {
	if (launchMode == null)
	    launchMode = new String();
	return launchMode;
    }

    /**
     * @param launchMode
     */
    public void setLaunchMode(String launchMode) {
	this.launchMode = launchMode;
    }

    /**
     * @return
     */
    public String getBarkerMode() {
	if (barkerMode == null)
	    barkerMode = new String();
	return barkerMode;
    }

    /**
     * @param barkerMode
     */
    public void setBarkerMode(String barkerMode) {
	this.barkerMode = barkerMode;
    }

    /**
     * @return
     */
    public String getBarkerSourceID() {
	if (barkerSourceID == null)
	    barkerSourceID = new String();
	return barkerSourceID;
    }

    /**
     * @param barkerSourceID
     */
    public void setBarkerSourceID(String barkerSourceID) {
	this.barkerSourceID = barkerSourceID;
    }
    
    public int getEntryID() {
        return entryID;
    }
    
    private void setEntryID(int entryID) {
        this.entryID = entryID;
    }

}
