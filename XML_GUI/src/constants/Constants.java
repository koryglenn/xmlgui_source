package constants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Constants {
    
    public final static String TITLE_STRING;
    public final static String CELL_PAD;

    public final static Font PROJECT_MAIN_FONT;
    public final static Font PROJECT_SUB_FONT;
    public final static Color PROJECT_MAIN_COLOR;
    public final static Color PROJECT_SUB_COLOR;
    public final static Border PROJECT_MAIN_BORDER;
    public final static Border PROJECT_SUB_BORDER;
    
    public final static int FRAME_WIDTH;
    public final static int FRAME_HEIGHT;
    public final static int TITLE_HEIGHT;
    public final static int FRAME_PADDING;
    public final static int LABEL_WIDTH; 
    
    static{
	TITLE_STRING = "ECL XML GENERATOR v1.0";
	CELL_PAD = "    ";
	
	PROJECT_MAIN_FONT = new Font(Font.SANS_SERIF,Font.BOLD,24);
	PROJECT_SUB_FONT = new Font(Font.SANS_SERIF,Font.PLAIN,16);
	PROJECT_MAIN_COLOR = new Color(51,51,255);
	PROJECT_SUB_COLOR = Color.WHITE;
	PROJECT_MAIN_BORDER = BorderFactory.createLineBorder(PROJECT_MAIN_COLOR, 4);
	PROJECT_SUB_BORDER = BorderFactory.createLineBorder(PROJECT_SUB_COLOR, 4);
	
	FRAME_WIDTH = 800;
	FRAME_HEIGHT = 600;
	TITLE_HEIGHT = 50;
	FRAME_PADDING = 10;
	LABEL_WIDTH = 150;
    }
    
}
