package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Window {

	private JFrame frmIfixedsomething;
	private JTextField txt_ModelNumber;
	private JTextField txt_ServiceTag;
	private JTextField txt_Dps;
	private JTextField txt_Cell;
	private JTextField txt_Rack;
	private JTextField txt_Bin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmIfixedsomething.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	public void exit_App()
	{
		WindowEvent event = new WindowEvent(frmIfixedsomething, WindowEvent.WINDOW_CLOSING);
		
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
		frmIfixedsomething.setVisible(false);
		frmIfixedsomething.dispose();
		
		System.exit(0);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIfixedsomething = new JFrame();
		frmIfixedsomething.setResizable(false);
		frmIfixedsomething.setTitle("iFixedSomething");
		frmIfixedsomething.setIconImage(Toolkit.getDefaultToolkit().getImage("W:\\JavaLearning\\iFixedSomething\\resources\\grey_ivy_logo.png"));
		frmIfixedsomething.setBounds(100, 100, 700, 300);
		frmIfixedsomething.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIfixedsomething.setUndecorated(true);
		frmIfixedsomething.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		JSplitPane split_Frame = new JSplitPane();
		frmIfixedsomething.getContentPane().add(split_Frame);
		
		JPanel panel_Menu = new JPanel();
		split_Frame.setLeftComponent(panel_Menu);
		panel_Menu.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton bttn_Debug = new JButton("Debug");
		panel_Menu.add(bttn_Debug);
		
		JButton bttn_Rework = new JButton("Rework");
		panel_Menu.add(bttn_Rework);
		
		JButton bttn_Settings = new JButton("Settings");
		panel_Menu.add(bttn_Settings);
		
		JLabel lbl_MenuPlaceholder = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder);
		
		JLabel lbl_MenuPlaceholder_1 = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder_1);
		
		JLabel lbl_MenuPlaceholder_2 = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder_2);
		
		JButton bttn_Exit = new JButton("Exit");
		bttn_Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_App();
			}
		});
		panel_Menu.add(bttn_Exit);
		
		JSplitPane split_Workpane = new JSplitPane();
		split_Workpane.setResizeWeight(0.03);
		split_Workpane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_Frame.setRightComponent(split_Workpane);
		
		JLayeredPane layers_Workpanes = new JLayeredPane();
		split_Workpane.setRightComponent(layers_Workpanes);
		
		JPanel panel_Settings = new JPanel();
		panel_Settings.setBounds(0, 0, 620, 217);
		layers_Workpanes.add(panel_Settings);
		panel_Settings.setLayout(new GridLayout(0, 2, 0, 0));
		
		JSplitPane split_GeneralSettings = new JSplitPane();
		split_GeneralSettings.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_Settings.add(split_GeneralSettings);
		
		JLabel lbl_GeneralSettigns = new JLabel("General");
		lbl_GeneralSettigns.setHorizontalAlignment(SwingConstants.CENTER);
		split_GeneralSettings.setLeftComponent(lbl_GeneralSettigns);
		
		JPanel panel_GeneralSettings = new JPanel();
		split_GeneralSettings.setRightComponent(panel_GeneralSettings);
		panel_GeneralSettings.setLayout(new GridLayout(1, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		panel_GeneralSettings.add(splitPane);
		
		JPanel panel_GenOptions = new JPanel();
		splitPane.setLeftComponent(panel_GenOptions);
		panel_GenOptions.setLayout(new GridLayout(4, 1, 0, 0));
		
		JSplitPane split_ProfileSettings = new JSplitPane();
		split_ProfileSettings.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_Settings.add(split_ProfileSettings);
		
		JLabel lbl_ProfileSettings = new JLabel("Profile Settings");
		lbl_ProfileSettings.setHorizontalAlignment(SwingConstants.CENTER);
		split_ProfileSettings.setLeftComponent(lbl_ProfileSettings);
		
		JPanel panel_ProfileSettings = new JPanel();
		split_ProfileSettings.setRightComponent(panel_ProfileSettings);
		
		JPanel panel_UnitInfo = new JPanel();
		split_Workpane.setLeftComponent(panel_UnitInfo);
		panel_UnitInfo.setLayout(new GridLayout(2, 3, 0, 0));
		
		JSplitPane split_Model = new JSplitPane();
		split_Model.setResizeWeight(0.5);
		panel_UnitInfo.add(split_Model);
		
		JLabel lbl_Model = new JLabel("Model:");
		lbl_Model.setHorizontalAlignment(SwingConstants.CENTER);
		split_Model.setLeftComponent(lbl_Model);
		
		txt_ModelNumber = new JTextField();
		split_Model.setRightComponent(txt_ModelNumber);
		txt_ModelNumber.setColumns(10);
		
		JSplitPane split_ServiceTag = new JSplitPane();
		split_ServiceTag.setResizeWeight(0.5);
		panel_UnitInfo.add(split_ServiceTag);
		
		JLabel lbl_ServiceTag = new JLabel("Service Tag: ");
		lbl_ServiceTag.setHorizontalAlignment(SwingConstants.CENTER);
		split_ServiceTag.setLeftComponent(lbl_ServiceTag);
		
		txt_ServiceTag = new JTextField();
		split_ServiceTag.setRightComponent(txt_ServiceTag);
		txt_ServiceTag.setColumns(10);
		
		JSplitPane split_Dps = new JSplitPane();
		split_Dps.setResizeWeight(0.5);
		panel_UnitInfo.add(split_Dps);
		
		JLabel lbl_Dps = new JLabel("DPS:");
		lbl_Dps.setHorizontalAlignment(SwingConstants.CENTER);
		split_Dps.setLeftComponent(lbl_Dps);
		
		txt_Dps = new JTextField();
		split_Dps.setRightComponent(txt_Dps);
		txt_Dps.setColumns(10);
		
		JSplitPane split_Cell = new JSplitPane();
		split_Cell.setResizeWeight(0.555);
		panel_UnitInfo.add(split_Cell);
		
		JLabel lbl_Cell = new JLabel("Cell:");
		lbl_Cell.setHorizontalAlignment(SwingConstants.CENTER);
		split_Cell.setLeftComponent(lbl_Cell);
		
		txt_Cell = new JTextField();
		split_Cell.setRightComponent(txt_Cell);
		txt_Cell.setColumns(10);
		
		JSplitPane split_Rack = new JSplitPane();
		split_Rack.setResizeWeight(0.72);
		panel_UnitInfo.add(split_Rack);
		
		JLabel lbl_Rack = new JLabel("Rack:");
		lbl_Rack.setHorizontalAlignment(SwingConstants.CENTER);
		split_Rack.setLeftComponent(lbl_Rack);
		
		txt_Rack = new JTextField();
		split_Rack.setRightComponent(txt_Rack);
		txt_Rack.setColumns(10);
		
		JSplitPane split_Bin = new JSplitPane();
		split_Bin.setResizeWeight(0.535);
		panel_UnitInfo.add(split_Bin);
		
		JLabel lbl_Bin = new JLabel("Bin:");
		lbl_Bin.setHorizontalAlignment(SwingConstants.CENTER);
		split_Bin.setLeftComponent(lbl_Bin);
		
		txt_Bin = new JTextField();
		split_Bin.setRightComponent(txt_Bin);
		txt_Bin.setColumns(10);
	}
}
