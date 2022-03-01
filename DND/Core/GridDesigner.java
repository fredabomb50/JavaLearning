package core;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;


public class GridDesigner extends Gui
{
	//======================Constants; ultimately needs to be removed once a final design is made, to avoid memory hogging
	//Generic
	final private static int default_GridX = 10;
	final private static int default_GridY = 10;
	
	//Button defaults
	final private static int bttn_DefaultGridWidth = 1;
	final private static int bttn_DefaultGridHeight = 1;
	
	//Label defaults
	final private static int lbl_DefaultSize = 1;
	
	//Panel defaults
	
	
	//======================Variables
	//Labels
	GridBagConstraints lbl_Class, lbl_Level; 

	//Panels
	GridBagConstraints panel_AlignBG, panel_Avatar; 
	
	//Buttons
	GridBagConstraints bttn_CharacterDetails;
	
	//
	
	
	//======================Constructor
	public GridDesigner()
	{
		
	}
	
	
	//======================Constraint setters
	public void setCoord(GridBagConstraints constraint, int x, int y)
	{
		constraint.gridx = x;
		constraint.gridy = y;
	}
	
	
	public void setDimensions(GridBagConstraints constraint, int x, int y)
	{
		constraint.gridx = x;
		constraint.gridy = y;
	}
	
	
	
	//======================Stubs
	// contains old constraint settings from gui class; to be splintered as methods
	public void stub1()
	{
		/*
				// set constraints
		GridBagConstraints cClassLabel, cLevelLabel, cAlignBGPanel, cAvatarPanel, cCharacterDetailsButton;
		
		
		cAvatarPanel = new GridBagConstraints();
		setConstraintValues(cAvatarPanel, 1, 1, 1, 1, 0, 0, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);

		
		cClassLabel = new GridBagConstraints();
		setConstraintValues(cClassLabel, cAvatarPanel.gridx, (cAvatarPanel.gridy - 1), 1, 1, 0, 0, 0, 0, GridBagConstraints.NONE, GridBagConstraints.SOUTH);
		//cClassLabel.gridx = cAvatarPanel.gridx;
		//cClassLabel.gridy = cAvatarPanel.gridy - 1;		
		//cClassLabel.gridheight = 1;
		//cClassLabel.gridwidth = 1;
		//cClassLabel.anchor = GridBagConstraints.SOUTH;
		
		cLevelLabel = new GridBagConstraints();
		cLevelLabel.gridx = cAvatarPanel.gridx - 1;
		cLevelLabel.gridy = cAvatarPanel.gridy;		
		cLevelLabel.gridheight = 1;
		cLevelLabel.gridwidth = 1;
		cLevelLabel.anchor = GridBagConstraints.NORTH;
		
		cAlignBGPanel = new GridBagConstraints();
		cAlignBGPanel.gridx = cAvatarPanel.gridx;
		cAlignBGPanel.gridy = cAvatarPanel.gridy + 1;		
		cAlignBGPanel.gridheight = 1;
		cAlignBGPanel.gridwidth = 1;
		cAlignBGPanel.anchor = GridBagConstraints.NORTH;
		
		cCharacterDetailsButton = new GridBagConstraints();
		cCharacterDetailsButton.fill = GridBagConstraints.NONE;
		cCharacterDetailsButton.weightx = 0.5;
		cCharacterDetailsButton.gridx = cAvatarPanel.gridx + 1;
		cCharacterDetailsButton.gridy = cAvatarPanel.gridy;
		cCharacterDetailsButton.ipady = 60;
		cCharacterDetailsButton.gridheight = cAvatarPanel.gridheight;
		cCharacterDetailsButton.gridwidth = 1;
		cCharacterDetailsButton.anchor = GridBagConstraints.WEST; 
		*/
	}
}
