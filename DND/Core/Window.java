package core;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class Window {

	private JFrame frmCharacterRandomizer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmCharacterRandomizer.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Image icon_Avatar = Toolkit.getDefaultToolkit().getImage("Resources/avatar.png");
		frmCharacterRandomizer = new JFrame();
		frmCharacterRandomizer.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luis.pacheco\\Documents\\Tools\\Eclipse\\eclipse-workspace\\DND\\Resources\\window_icon.png"));
		frmCharacterRandomizer.setTitle("Character Randomizer");
		frmCharacterRandomizer.setBounds(100, 100, 800, 600);
		frmCharacterRandomizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCharacterRandomizer.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmFullRandom = new JMenuItem("Full Random");
		mnNew.add(mntmFullRandom);
		
		JMenu mnPrint = new JMenu("Print");
		menuBar.add(mnPrint);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmCharacterRandomizer.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Character = new JPanel();
		tabbedPane.addTab("Character", null, Character, null);
		Character.setLayout(new GridLayout(3, 1, 0, 0));
		
		JSplitPane split_CharacterStatus = new JSplitPane();
		split_CharacterStatus.setResizeWeight(0.8);
		Character.add(split_CharacterStatus);
		
		JSplitPane split_HealthSection = new JSplitPane();
		split_HealthSection.setResizeWeight(0.8);
		split_HealthSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_CharacterStatus.setLeftComponent(split_HealthSection);
		
		JProgressBar prog_HealthBar = new JProgressBar();
		prog_HealthBar.setStringPainted(true);
		prog_HealthBar.setString("100 / 100");
		prog_HealthBar.setValue(50);
		split_HealthSection.setLeftComponent(prog_HealthBar);
		
		JLabel lbl_HealthStatus = new JLabel("120 / 100 (+20)");
		split_HealthSection.setRightComponent(lbl_HealthStatus);
		
		JPanel panel_ImportantStats = new JPanel();
		split_CharacterStatus.setRightComponent(panel_ImportantStats);
		panel_ImportantStats.setLayout(new GridLayout(1, 4, 0, 0));
		
		JSplitPane split_HitDie = new JSplitPane();
		split_HitDie.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_ImportantStats.add(split_HitDie);
		
		JPanel Details = new JPanel();
		tabbedPane.addTab("Details", null, Details, null);
		Details.setLayout(new GridLayout(4, 1, 0, 0));
		
		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setResizeWeight(0.2);
		Details.add(splitPane_10);
		
		JPanel panel = new JPanel();
		splitPane_10.setRightComponent(panel);
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel lbl_Name = new JLabel("Name: Little Shell");
		panel.add(lbl_Name);
		
		JLabel lbl_Age = new JLabel("Age: ");
		panel.add(lbl_Age);
		
		JLabel lbl_Height = new JLabel("Height: ");
		panel.add(lbl_Height);
		
		JLabel lbl_Race = new JLabel("Race: Tortle");
		panel.add(lbl_Race);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\luis.pacheco\\Documents\\Tools\\Eclipse\\eclipse-workspace\\DND\\Resources\\avatar.png"));
		splitPane_10.setLeftComponent(lblNewLabel_6);
		
		JSplitPane splitPane_14 = new JSplitPane();
		splitPane_14.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Details.add(splitPane_14);
		
		JLabel lblNewLabel_21 = new JLabel("Backstory");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_14.setLeftComponent(lblNewLabel_21);
		
		JTextArea textArea_2 = new JTextArea();
		splitPane_14.setRightComponent(textArea_2);
		
		JSplitPane splitPane_11 = new JSplitPane();
		splitPane_11.setResizeWeight(0.5);
		Details.add(splitPane_11);
		
		JSplitPane splitPane_12 = new JSplitPane();
		splitPane_12.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_11.setRightComponent(splitPane_12);
		
		JLabel lblNewLabel_19 = new JLabel("End goals");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_12.setLeftComponent(lblNewLabel_19);
		
		JTextArea textArea = new JTextArea();
		splitPane_12.setRightComponent(textArea);
		
		JSplitPane splitPane_13 = new JSplitPane();
		splitPane_13.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_11.setLeftComponent(splitPane_13);
		
		JLabel lblNewLabel_20 = new JLabel("Start Goals");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_13.setLeftComponent(lblNewLabel_20);
		
		JTextArea textArea_1 = new JTextArea();
		splitPane_13.setRightComponent(textArea_1);
		
		JSplitPane splitPane_15 = new JSplitPane();
		splitPane_15.setResizeWeight(0.495);
		Details.add(splitPane_15);
		
		JSplitPane splitPane_16 = new JSplitPane();
		splitPane_16.setResizeWeight(0.5);
		splitPane_15.setLeftComponent(splitPane_16);
		
		JSplitPane splitPane_17 = new JSplitPane();
		splitPane_17.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setLeftComponent(splitPane_17);
		
		JLabel lblNewLabel_22 = new JLabel("Likes");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_17.setLeftComponent(lblNewLabel_22);
		
		JTextArea textArea_4 = new JTextArea();
		splitPane_17.setRightComponent(textArea_4);
		
		JSplitPane splitPane_18 = new JSplitPane();
		splitPane_18.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setRightComponent(splitPane_18);
		
		JLabel lblNewLabel_23 = new JLabel("Dislikes");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_18.setLeftComponent(lblNewLabel_23);
		
		JTextArea textArea_3 = new JTextArea();
		splitPane_18.setRightComponent(textArea_3);
		
		JSplitPane splitPane_19 = new JSplitPane();
		splitPane_19.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_15.setRightComponent(splitPane_19);
		
		JLabel lblNewLabel_24 = new JLabel("Affiliations");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_19.setLeftComponent(lblNewLabel_24);
		
		JTextArea textArea_5 = new JTextArea();
		splitPane_19.setRightComponent(textArea_5);
		
		JPanel Magic = new JPanel();
		tabbedPane.addTab("Magic", null, Magic, null);
		Magic.setLayout(new GridLayout(0, 5, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane);
		
		JSplitPane split_SpellSlots = new JSplitPane();
		split_SpellSlots.setResizeWeight(0.6);
		splitPane.setLeftComponent(split_SpellSlots);
		
		JLabel lblNewLabel_2 = new JLabel("Cantrips");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots.setLeftComponent(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("0");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots.setRightComponent(lblNewLabel_4);
		
		JPanel panel_SpellSlots = new JPanel();
		splitPane.setRightComponent(panel_SpellSlots);
		panel_SpellSlots.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("spell 1");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots.add(lblNewLabel_5);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_1);
		
		JSplitPane split_SpellSlots_1 = new JSplitPane();
		split_SpellSlots_1.setResizeWeight(0.6);
		splitPane_1.setLeftComponent(split_SpellSlots_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("1st Level Spells");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_1.setLeftComponent(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("0");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_1.setRightComponent(lblNewLabel_4_1);
		
		JPanel panel_SpellSlots_1 = new JPanel();
		splitPane_1.setRightComponent(panel_SpellSlots_1);
		panel_SpellSlots_1.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_1 = new JLabel("spell 1");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_1.add(lblNewLabel_5_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_2);
		
		JSplitPane split_SpellSlots_2 = new JSplitPane();
		split_SpellSlots_2.setResizeWeight(0.6);
		splitPane_2.setLeftComponent(split_SpellSlots_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("2nd Level Spells");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_2.setLeftComponent(lblNewLabel_2_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("0");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_2.setRightComponent(lblNewLabel_4_3);
		
		JPanel panel_SpellSlots_2 = new JPanel();
		splitPane_2.setRightComponent(panel_SpellSlots_2);
		panel_SpellSlots_2.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_2 = new JLabel("spell 1");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_2.add(lblNewLabel_5_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_3);
		
		JSplitPane split_SpellSlots_3 = new JSplitPane();
		split_SpellSlots_3.setResizeWeight(0.6);
		splitPane_3.setLeftComponent(split_SpellSlots_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("3rd Level Spells");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_3.setLeftComponent(lblNewLabel_2_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("0");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_3.setRightComponent(lblNewLabel_4_4);
		
		JPanel panel_SpellSlots_3 = new JPanel();
		splitPane_3.setRightComponent(panel_SpellSlots_3);
		panel_SpellSlots_3.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_3 = new JLabel("spell 1");
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_3.add(lblNewLabel_5_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_4);
		
		JSplitPane split_SpellSlots_4 = new JSplitPane();
		split_SpellSlots_4.setResizeWeight(0.6);
		splitPane_4.setLeftComponent(split_SpellSlots_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("4th Level Spells");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_4.setLeftComponent(lblNewLabel_2_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("0");
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_4.setRightComponent(lblNewLabel_4_5);
		
		JPanel panel_SpellSlots_4 = new JPanel();
		splitPane_4.setRightComponent(panel_SpellSlots_4);
		panel_SpellSlots_4.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_4 = new JLabel("spell 1");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_4.add(lblNewLabel_5_4);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_5);
		
		JSplitPane split_SpellSlots_5 = new JSplitPane();
		split_SpellSlots_5.setResizeWeight(0.6);
		splitPane_5.setLeftComponent(split_SpellSlots_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("5th Level Spells");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_5.setLeftComponent(lblNewLabel_2_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("0");
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_5.setRightComponent(lblNewLabel_4_6);
		
		JPanel panel_SpellSlots_5 = new JPanel();
		splitPane_5.setRightComponent(panel_SpellSlots_5);
		panel_SpellSlots_5.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_5 = new JLabel("spell 1");
		lblNewLabel_5_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_5.add(lblNewLabel_5_5);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_6);
		
		JSplitPane split_SpellSlots_6 = new JSplitPane();
		split_SpellSlots_6.setResizeWeight(0.6);
		splitPane_6.setLeftComponent(split_SpellSlots_6);
		
		JLabel lblNewLabel_2_6 = new JLabel("6th Level Spells");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_6.setLeftComponent(lblNewLabel_2_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("0");
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_6.setRightComponent(lblNewLabel_4_7);
		
		JPanel panel_SpellSlots_6 = new JPanel();
		splitPane_6.setRightComponent(panel_SpellSlots_6);
		panel_SpellSlots_6.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_6 = new JLabel("spell 1");
		lblNewLabel_5_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_6.add(lblNewLabel_5_6);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_7);
		
		JSplitPane split_SpellSlots_7 = new JSplitPane();
		split_SpellSlots_7.setResizeWeight(0.6);
		splitPane_7.setLeftComponent(split_SpellSlots_7);
		
		JLabel lblNewLabel_2_7 = new JLabel("7th Level Spells");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_7.setLeftComponent(lblNewLabel_2_7);
		
		JLabel lblNewLabel_4_8 = new JLabel("0");
		lblNewLabel_4_8.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_7.setRightComponent(lblNewLabel_4_8);
		
		JPanel panel_SpellSlots_7 = new JPanel();
		splitPane_7.setRightComponent(panel_SpellSlots_7);
		panel_SpellSlots_7.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_7 = new JLabel("spell 1");
		lblNewLabel_5_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_7.add(lblNewLabel_5_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_8);
		
		JSplitPane split_SpellSlots_8 = new JSplitPane();
		split_SpellSlots_8.setResizeWeight(0.6);
		splitPane_8.setLeftComponent(split_SpellSlots_8);
		
		JLabel lblNewLabel_2_8 = new JLabel("8th Level Spells");
		lblNewLabel_2_8.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_8.setLeftComponent(lblNewLabel_2_8);
		
		JLabel lblNewLabel_4_9 = new JLabel("0");
		lblNewLabel_4_9.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_8.setRightComponent(lblNewLabel_4_9);
		
		JPanel panel_SpellSlots_8 = new JPanel();
		splitPane_8.setRightComponent(panel_SpellSlots_8);
		panel_SpellSlots_8.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_8 = new JLabel("spell 1");
		lblNewLabel_5_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_8.add(lblNewLabel_5_8);
		
		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Magic.add(splitPane_9);
		
		JSplitPane split_SpellSlots_9 = new JSplitPane();
		split_SpellSlots_9.setResizeWeight(0.6);
		splitPane_9.setLeftComponent(split_SpellSlots_9);
		
		JLabel lblNewLabel_2_9 = new JLabel("9th Level Spells");
		lblNewLabel_2_9.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_9.setLeftComponent(lblNewLabel_2_9);
		
		JLabel lblNewLabel_4_10 = new JLabel("0");
		lblNewLabel_4_10.setHorizontalAlignment(SwingConstants.CENTER);
		split_SpellSlots_9.setRightComponent(lblNewLabel_4_10);
		
		JPanel panel_SpellSlots_9 = new JPanel();
		splitPane_9.setRightComponent(panel_SpellSlots_9);
		panel_SpellSlots_9.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_5_9 = new JLabel("spell 1");
		lblNewLabel_5_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellSlots_9.add(lblNewLabel_5_9);
		
		JPanel Inventory = new JPanel();
		tabbedPane.addTab("Inventory", null, Inventory, null);
		Inventory.setLayout(new GridLayout(2, 3, 1, 1));
		
		JSplitPane split_WeaponsSection = new JSplitPane();
		split_WeaponsSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_WeaponsSection);
		
		JSplitPane split_WeaponsHeader = new JSplitPane();
		split_WeaponsSection.setLeftComponent(split_WeaponsHeader);
		
		JButton bttn_AddWeapon = new JButton("Add new");
		split_WeaponsHeader.setLeftComponent(bttn_AddWeapon);
		
		JLabel lbl_h2_Weapons = new JLabel("Weapons");
		lbl_h2_Weapons.setHorizontalAlignment(SwingConstants.CENTER);
		split_WeaponsHeader.setRightComponent(lbl_h2_Weapons);
		
		JTextArea txtbox_Weapons = new JTextArea();
		split_WeaponsSection.setRightComponent(txtbox_Weapons);
		
		JSplitPane split_ArmorsSection = new JSplitPane();
		split_ArmorsSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_ArmorsSection);
		
		JSplitPane split_ArmorsHeader = new JSplitPane();
		split_ArmorsSection.setLeftComponent(split_ArmorsHeader);
		
		JButton bttn_AddArmor = new JButton("Add new");
		split_ArmorsHeader.setLeftComponent(bttn_AddArmor);
		
		JLabel lbl_h2_Armors = new JLabel("Armors");
		lbl_h2_Armors.setHorizontalAlignment(SwingConstants.CENTER);
		split_ArmorsHeader.setRightComponent(lbl_h2_Armors);
		
		JTextArea txtbox_Armors = new JTextArea();
		split_ArmorsSection.setRightComponent(txtbox_Armors);
		
		JSplitPane split_EquipmentSection = new JSplitPane();
		split_EquipmentSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_EquipmentSection);
		
		JSplitPane split_EquipmentHeader = new JSplitPane();
		split_EquipmentSection.setLeftComponent(split_EquipmentHeader);
		
		JButton bttn_AddEquipment = new JButton("Add new");
		split_EquipmentHeader.setLeftComponent(bttn_AddEquipment);
		
		JLabel lbl_h2_Equipment = new JLabel("Equipment");
		lbl_h2_Equipment.setHorizontalAlignment(SwingConstants.CENTER);
		split_EquipmentHeader.setRightComponent(lbl_h2_Equipment);
		
		JTextArea txtbox_Equipment = new JTextArea();
		split_EquipmentSection.setRightComponent(txtbox_Equipment);
		
		JSplitPane split_PotionsSection = new JSplitPane();
		split_PotionsSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_PotionsSection);
		
		JSplitPane split_PotionsHeader = new JSplitPane();
		split_PotionsSection.setLeftComponent(split_PotionsHeader);
		
		JButton bttn_AddPotion = new JButton("Add new");
		split_PotionsHeader.setLeftComponent(bttn_AddPotion);
		
		JLabel lbl_h2_Potions = new JLabel("Potions");
		lbl_h2_Potions.setHorizontalAlignment(SwingConstants.CENTER);
		split_PotionsHeader.setRightComponent(lbl_h2_Potions);
		
		JTextArea txtbox_Potions = new JTextArea();
		split_PotionsSection.setRightComponent(txtbox_Potions);
		
		JSplitPane split_MaterialsSection = new JSplitPane();
		split_MaterialsSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_MaterialsSection);
		
		JSplitPane split_MaterialsHeader = new JSplitPane();
		split_MaterialsSection.setLeftComponent(split_MaterialsHeader);
		
		JButton bttn_AddMaterial = new JButton("Add new");
		split_MaterialsHeader.setLeftComponent(bttn_AddMaterial);
		
		JLabel lbl_h2_Materials = new JLabel("Materials");
		lbl_h2_Materials.setHorizontalAlignment(SwingConstants.CENTER);
		split_MaterialsHeader.setRightComponent(lbl_h2_Materials);
		
		JTextArea txtbox_Materials = new JTextArea();
		split_MaterialsSection.setRightComponent(txtbox_Materials);
		
		JSplitPane split_ValuablesSection = new JSplitPane();
		split_ValuablesSection.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Inventory.add(split_ValuablesSection);
		
		JSplitPane split_ValuablesHeader = new JSplitPane();
		split_ValuablesSection.setLeftComponent(split_ValuablesHeader);
		
		JButton bttn_AddValuable = new JButton("Add new");
		split_ValuablesHeader.setLeftComponent(bttn_AddValuable);
		
		JLabel lbl_h2_Valuables = new JLabel("Valuables");
		lbl_h2_Valuables.setHorizontalAlignment(SwingConstants.CENTER);
		split_ValuablesHeader.setRightComponent(lbl_h2_Valuables);
		
		JTextArea txtbox_Valuables = new JTextArea();
		split_ValuablesSection.setRightComponent(txtbox_Valuables);
	}	
}
