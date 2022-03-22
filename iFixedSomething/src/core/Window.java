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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Window {

	// File I/O
	private File file_Daily, file_DailyReport, file_WeeklyReport, file_MonthlyReport, file_YearlyReport,
	file_Macros;
	
	private String path_Daily, path_DailyReport, path_WeeklyReport, path_MonthlyReport, path_YearlyReport,
	path_Macros;
	
	// GUI components
	private JFrame frmIfixedsomething;
	private JTextField txt_ModelNumber;
	private JTextField txt_ServiceTag;
	private JTextField txt_Dps;
	private JTextField txt_Rack;
	private JTextField txt_Bin;
	private JTextField txt_CellNumber;
	private JTextField txt_RackMin;
	private JTextField txt_RackMax;
	private JPanel panel_Settings, panel_Debug, panel_Rework;
	
	
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
		checkFileStructure();
		initialize();
	}


	public void checkFileStructure()
	{
		Boolean result = false;
		LocalDateTime currentDay = LocalDateTime.now();
		String path_ = "";
		
		
		// Create Records folder
		path_ = "Records/";
		File dir_Records = new File(path_);	
		result = dir_Records.mkdir();
		if (!result)
		{
			System.out.println("Failed to create Records folder");
		}
		
		// Create folder for current year
		DateTimeFormatter dtf_Year = DateTimeFormatter.ofPattern("yyyy");
		path_ = path_ + dtf_Year.format(currentDay) + "/";
		path_YearlyReport = path_ + "summary_" + dtf_Year.format(currentDay) + ".txt";
		File dir_Year = new File(path_);
		result = dir_Year.mkdir();
		if (!result)
		{
			System.out.println("Failed to create yearly folder");
		}
		file_YearlyReport = new File(path_YearlyReport);
		try
		{
			file_YearlyReport.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create yearly report - %s\n", e.getMessage());
		}
		
		// Create folder for current month
		DateTimeFormatter dtf_Month = DateTimeFormatter.ofPattern("MMMM");
		path_ = path_ + dtf_Month.format(currentDay) + "/";
		path_MonthlyReport = path_ + "summary_" + dtf_Month.format(currentDay) + ".txt";
		File dir_Month = new File(path_);
		result = dir_Month.mkdir();
		if (!result)
		{
			System.out.println("Failed to create monthly folder");
		}
		file_MonthlyReport = new File(path_MonthlyReport);
		try
		{
			file_MonthlyReport.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create monthly report - %s\n", e.getMessage());
		}
		
		// Create folder for current week of the month
		DateTimeFormatter dtf_Week = DateTimeFormatter.ofPattern("W");	
		path_ = path_ + "Week " + dtf_Week.format(currentDay) + "/";
		path_WeeklyReport = path_ + "summary_Week " + dtf_Week.format(currentDay) + ".txt";
		File dir_Week = new File(path_);
		result = dir_Week.mkdir();
		if (!result)
		{
			System.out.println("Failed to create weekly folder");
		}
		file_WeeklyReport = new File(path_WeeklyReport);
		try
		{
			file_WeeklyReport.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create weekly report - %s\n", e.getMessage());
		}
		
		// Create folder for current day of the month
		DateTimeFormatter dtf_Day = DateTimeFormatter.ofPattern("d");
		path_ = path_ + dtf_Day.format(currentDay) + "/";
		File dir_Day = new File(path_);
		result = dir_Day.mkdir();
		if (!result)
		{
			System.out.println("Failed to create daily folder");
		}
		
		// Create daily file and report
		DateTimeFormatter dtf_CurrentDay = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		path_DailyReport = path_ + "summary_"+ dtf_CurrentDay.format(currentDay) + ".txt";
		path_ = path_ + dtf_CurrentDay.format(currentDay) + ".txt";
		path_Daily = path_;
		file_Daily = new File(path_Daily);
		file_DailyReport = new File(path_DailyReport);
		
		try
		{
			result = file_DailyReport.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create daily report - %s\n", e.getMessage());
		}
		try
		{
			result = file_Daily.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create daily file - %s\n", e.getMessage());
		}
		
		
		// Create resources folder, along with macros file
		path_ = "Resources/";
		File dir_Resources = new File(path_);
		result = dir_Resources.mkdir();
		if (!result)
		{
			System.out.println("Failed to create Resources folder");
		}
		path_Macros = path_ + "Macros.txt";
		file_Macros = new File(path_Macros);
		try
		{
			result = file_Macros.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create macros file - %s\n", e.getMessage());
		}
	}
	
	
	public void showPopUp()
	{
		Pop_DebugNote temp = new Pop_DebugNote();
		temp.show();
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
		frmIfixedsomething.setIconImage(Toolkit.getDefaultToolkit().getImage("W:\\JavaLearning\\iFixedSomething\\Resources\\grey_ivy_logo.png"));
		frmIfixedsomething.setBounds(100, 100, 700, 300);
		frmIfixedsomething.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frmIfixedsomething.setUndecorated(true);
		frmIfixedsomething.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		JSplitPane split_Frame = new JSplitPane();
		frmIfixedsomething.getContentPane().add(split_Frame);
		
		JPanel panel_Menu = new JPanel();
		split_Frame.setLeftComponent(panel_Menu);
		panel_Menu.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton bttn_Debug = new JButton("Debug");
		bttn_Debug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Debug.setVisible(true);
				panel_Settings.setVisible(false);
			}
		});
		
		panel_Menu.add(bttn_Debug);
		
		JButton bttn_Rework = new JButton("Rework");
		panel_Menu.add(bttn_Rework);
		
		JButton bttn_Settings = new JButton("Settings");
		bttn_Settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Settings.setVisible(true);
				panel_Debug.setVisible(false);
			}
		});
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
		
		panel_Settings = new JPanel();
		panel_Settings.setBounds(0, 0, 604, 202);
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
		
		JSplitPane split_GenOptions = new JSplitPane();
		split_GenOptions.setResizeWeight(0.5);
		panel_GeneralSettings.add(split_GenOptions);
		
		JPanel panel_GenOptions = new JPanel();
		split_GenOptions.setLeftComponent(panel_GenOptions);
		panel_GenOptions.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lbl_Option1 = new JLabel("New label");
		lbl_Option1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_GenOptions.add(lbl_Option1);
		
		JLabel lbl_Option1_1 = new JLabel("New label");
		lbl_Option1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_GenOptions.add(lbl_Option1_1);
		
		JLabel lbl_Option1_2 = new JLabel("New label");
		lbl_Option1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_GenOptions.add(lbl_Option1_2);
		
		JLabel lbl_Option1_3 = new JLabel("New label");
		lbl_Option1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_GenOptions.add(lbl_Option1_3);
		
		JPanel panel_GenOptionValues = new JPanel();
		split_GenOptions.setRightComponent(panel_GenOptionValues);
		panel_GenOptionValues.setLayout(new GridLayout(4, 1, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setToolTipText("This is a test option, for testing.");
		panel_GenOptionValues.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_GenOptionValues.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		panel_GenOptionValues.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		panel_GenOptionValues.add(chckbxNewCheckBox_3);
		
		JSplitPane split_ProfileSettings = new JSplitPane();
		split_ProfileSettings.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_Settings.add(split_ProfileSettings);
		
		JLabel lbl_ProfileSettings = new JLabel("Profile Settings");
		lbl_ProfileSettings.setHorizontalAlignment(SwingConstants.CENTER);
		split_ProfileSettings.setLeftComponent(lbl_ProfileSettings);
		
		JPanel panel_ProfileSettings = new JPanel();
		split_ProfileSettings.setRightComponent(panel_ProfileSettings);
		panel_ProfileSettings.setLayout(new GridLayout(2, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		panel_ProfileSettings.add(splitPane);
		
		JSplitPane split_RackRange = new JSplitPane();
		split_RackRange.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(split_RackRange);
		
		JLabel lbl_RackRange = new JLabel("Rack Range (min - max)");
		lbl_RackRange.setHorizontalAlignment(SwingConstants.CENTER);
		split_RackRange.setLeftComponent(lbl_RackRange);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		split_RackRange.setRightComponent(splitPane_2);
		
		txt_RackMin = new JTextField();
		splitPane_2.setLeftComponent(txt_RackMin);
		txt_RackMin.setColumns(10);
		
		txt_RackMax = new JTextField();
		splitPane_2.setRightComponent(txt_RackMax);
		txt_RackMax.setColumns(10);
		
		JSplitPane split_CellNumber = new JSplitPane();
		splitPane.setLeftComponent(split_CellNumber);
		
		JLabel lbl_CellNumber = new JLabel("Cell Number:");
		split_CellNumber.setLeftComponent(lbl_CellNumber);
		
		txt_CellNumber = new JTextField();
		split_CellNumber.setRightComponent(txt_CellNumber);
		txt_CellNumber.setColumns(10);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		panel_ProfileSettings.add(splitPane_1);
		
		JPanel panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		
		JLabel lbl_temp_1 = new JLabel("New label");
		panel.add(lbl_temp_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		JLabel lbl_temp = new JLabel("New label");
		panel_1.add(lbl_temp);
		
		panel_Debug = new JPanel();
		layers_Workpanes.setLayer(panel_Debug, 1);
		panel_Debug.setBounds(0, 0, 604, 202);
		
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
		
		JLabel lbl_CellValue = new JLabel("A");
		lbl_CellValue.setHorizontalAlignment(SwingConstants.CENTER);
		split_Cell.setRightComponent(lbl_CellValue);
		
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
