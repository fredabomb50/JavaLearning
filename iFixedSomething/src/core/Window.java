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
import java.awt.Image;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;    

public class Window {

	// Processes
	private Process proc_Macro;
	
	// File I/O
	private File file_Daily, file_DailyReport, file_WeeklyReport, file_MonthlyReport, file_YearlyReport,
	file_Macros;
	
	private String path_Daily, path_DailyReport, path_WeeklyReport, path_MonthlyReport, path_YearlyReport,
	path_Macros;
	
	// GUI components
	private JFrame frmIfixedsomething;
	private JPanel panel_Debug, panel_Rework;
	
	
	private Image img_Exit, img_Debug;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Window window = new Window();
					window.frmIfixedsomething.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window()
	{
		checkFileStructure();
		runMacros();
		initialize();
	}

	
	// create directory tree, and skipping over present files
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
		
		// Create records archive folder
		File dir_ArchivedRecords = new File(path_ + "_archives");
		result = dir_ArchivedRecords.mkdir();
		if (!result)
		{
			System.out.println("Failed to create Records archive folder");
		}
		
		// Create units folder
		File dir_Units = new File(path_ + "_units");
		result = dir_Units.mkdir();
		if (!result)
		{
			System.out.println("Failed to create units folder");
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
		path_Macros = path_ + "macros.txt";
		file_Macros = new File(path_Macros);
		try
		{
			result = file_Macros.createNewFile();
		}
		catch (IOException e)
		{
			System.out.printf("Failed to create macros file - %s\n", e.getMessage());
		}
		
		// Create logs folder
		path_ = "Logs/";
		File dir_Logs = new File(path_);
		if (!dir_Logs.mkdir())
		{
			System.out.println("Failed to create logs folder");
		}
		
		// Create logs archive folder
		File dir_ArchivedLogs = new File(path_ + "_archives");
		if(!dir_ArchivedLogs.mkdir())
		{
			System.out.println("Failed to create Logs archive folder");
		}
	}
	
	// needs to be parameterized so any pop up can be opened
	public void showPopUp()
	{
		Pop_DebugNote temp = new Pop_DebugNote();
		temp.show();
	}
	
	// run macros.exe
	public void runMacros()
	{
		Runtime macroEXE = Runtime.getRuntime();
		try
		{
			proc_Macro = macroEXE.exec("macros.exe");
		}
		catch (IOException e)
		{
			System.out.printf("Failed to launch / find macro - %s", e.getMessage());
		}
		
	}
	
	
	// clean closure of application
	public void exit_App()
	{
		// create windows-safe event for closing app
		WindowEvent event = new WindowEvent(frmIfixedsomething, WindowEvent.WINDOW_CLOSING);
		
		// close process for macros.exe
		proc_Macro.destroy();
		
		// post windows-safe event
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
		
		// remove GUI from screen
		frmIfixedsomething.setVisible(false);
		
		// dispose of class instance
		frmIfixedsomething.dispose();
		
		// exit application
		System.exit(0);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize()
	{
		frmIfixedsomething = new JFrame();
		frmIfixedsomething.setResizable(false);
		frmIfixedsomething.setTitle("iFixedSomething");
		frmIfixedsomething.setIconImage(Toolkit.getDefaultToolkit().getImage("W:\\JavaLearning\\iFixedSomething\\Resources\\images\\icon_IvyLogoGrey.png"));
		frmIfixedsomething.setBounds(100, 100, 700, 300);
		frmIfixedsomething.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIfixedsomething.setUndecorated(true);
		frmIfixedsomething.getContentPane().setLayout(null);

		
		JButton bttn_CloseApp = new JButton("");
		bttn_CloseApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				exit_App();
			}
		});
		bttn_CloseApp.setBounds(670, 0, 30, 30);
		frmIfixedsomething.getContentPane().add(bttn_CloseApp);
		img_Exit = Toolkit.getDefaultToolkit().getImage("W:\\\\JavaLearning\\\\iFixedSomething\\\\Resources\\\\images\\\\icon_Close.jpg");
		Image scaled_i = img_Exit.getScaledInstance(30, 30, Image.SCALE_FAST);
		bttn_CloseApp.setIcon(new ImageIcon(scaled_i));
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBounds(0, 0, 75, 300);
		frmIfixedsomething.getContentPane().add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JButton btnNewButton = new JButton("Debug");
		btnNewButton.setBounds(10, 11, 55, 44);
		panel_Menu.add(btnNewButton);
		 
		
		panel_Debug = new JPanel();
		panel_Debug.setBounds(0, 0, 604, 202);
	}

}
