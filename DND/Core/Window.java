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
import javax.swing.JRadioButton;
import java.awt.Font;

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
		String healthStatus = "100 / 100";
		
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
		
		JPanel Character = new JPanel();
		tabbedPane.addTab("Character", null, Character, null);
		Character.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane_20 = new JSplitPane();
		splitPane_20.setResizeWeight(0.05);
		splitPane_20.setOrientation(JSplitPane.VERTICAL_SPLIT);
		Character.add(splitPane_20);
		
		JSplitPane split_CharacterStatus_1 = new JSplitPane();
		split_CharacterStatus_1.setResizeWeight(0.2);
		splitPane_20.setLeftComponent(split_CharacterStatus_1);
		
		JSplitPane split_HealthSection_1 = new JSplitPane();
		split_HealthSection_1.setResizeWeight(0.8);
		split_HealthSection_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_CharacterStatus_1.setLeftComponent(split_HealthSection_1);
		
		JProgressBar prog_HP_1 = new JProgressBar();
		prog_HP_1.setValue(50);
		prog_HP_1.setStringPainted(true);
		prog_HP_1.setString("100 / 100");
		split_HealthSection_1.setLeftComponent(prog_HP_1);
		
		JSplitPane split_HitAndDeath_1 = new JSplitPane();
		split_HitAndDeath_1.setResizeWeight(0.2);
		split_HealthSection_1.setRightComponent(split_HitAndDeath_1);
		
		JSplitPane split_HitDie_1 = new JSplitPane();
		split_HitDie_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_HitAndDeath_1.setLeftComponent(split_HitDie_1);
		
		JLabel lbl_HitDie_1 = new JLabel("Hit Die");
		lbl_HitDie_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_HitDie_1.setLeftComponent(lbl_HitDie_1);
		
		JLabel lbl_HitDieCount_1 = new JLabel("9D12");
		lbl_HitDieCount_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_HitDie_1.setRightComponent(lbl_HitDieCount_1);
		
		JSplitPane split_DeathSaves_1 = new JSplitPane();
		split_DeathSaves_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_HitAndDeath_1.setRightComponent(split_DeathSaves_1);
		
		JLabel lbl_DeathSaves_1 = new JLabel("Death Saves");
		lbl_DeathSaves_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_DeathSaves_1.setLeftComponent(lbl_DeathSaves_1);
		
		JSplitPane split_DeathSavesCounter_1 = new JSplitPane();
		split_DeathSavesCounter_1.setResizeWeight(0.5);
		split_DeathSaves_1.setRightComponent(split_DeathSavesCounter_1);
		
		JSplitPane split_DeathSaveLabels_1 = new JSplitPane();
		split_DeathSaveLabels_1.setResizeWeight(0.5);
		split_DeathSaveLabels_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_DeathSavesCounter_1.setLeftComponent(split_DeathSaveLabels_1);
		
		JLabel lbl_SuccessfulDeathSaves_1 = new JLabel("Successes");
		lbl_SuccessfulDeathSaves_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_DeathSaveLabels_1.setLeftComponent(lbl_SuccessfulDeathSaves_1);
		
		JLabel lbl_FailedDeathSaves_1 = new JLabel("Fails");
		lbl_FailedDeathSaves_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_DeathSaveLabels_1.setRightComponent(lbl_FailedDeathSaves_1);
		
		JSplitPane split_DeathSavesOutcomes_1 = new JSplitPane();
		split_DeathSavesOutcomes_1.setResizeWeight(0.5);
		split_DeathSavesOutcomes_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_DeathSavesCounter_1.setRightComponent(split_DeathSavesOutcomes_1);
		
		JPanel panel_SuccessfulDeathSaves_1 = new JPanel();
		split_DeathSavesOutcomes_1.setLeftComponent(panel_SuccessfulDeathSaves_1);
		panel_SuccessfulDeathSaves_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rad_sDeathSave1_1 = new JRadioButton("");
		rad_sDeathSave1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SuccessfulDeathSaves_1.add(rad_sDeathSave1_1);
		
		JRadioButton rad_sDeathSave2_1 = new JRadioButton("");
		rad_sDeathSave2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SuccessfulDeathSaves_1.add(rad_sDeathSave2_1);
		
		JRadioButton rad_sDeathSave3_1 = new JRadioButton("");
		rad_sDeathSave3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SuccessfulDeathSaves_1.add(rad_sDeathSave3_1);
		
		JPanel panel_FailedDeathSaves_1 = new JPanel();
		split_DeathSavesOutcomes_1.setRightComponent(panel_FailedDeathSaves_1);
		
		JRadioButton rad_fDeathSave1_1 = new JRadioButton("");
		rad_fDeathSave1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FailedDeathSaves_1.add(rad_fDeathSave1_1);
		
		JRadioButton rad_fDeathSave2_1 = new JRadioButton("");
		rad_fDeathSave2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FailedDeathSaves_1.add(rad_fDeathSave2_1);
		
		JRadioButton rad_fDeathSave3_1 = new JRadioButton("");
		rad_fDeathSave3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_FailedDeathSaves_1.add(rad_fDeathSave3_1);
		
		JSplitPane split_ImportantDetails_1 = new JSplitPane();
		split_ImportantDetails_1.setResizeWeight(0.5);
		split_CharacterStatus_1.setRightComponent(split_ImportantDetails_1);
		
		JSplitPane split_SavingThrowsContainer_1 = new JSplitPane();
		split_SavingThrowsContainer_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		split_ImportantDetails_1.setLeftComponent(split_SavingThrowsContainer_1);
		
		JLabel lbl_SavingThrows_1 = new JLabel("Saving Throws");
		lbl_SavingThrows_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_SavingThrowsContainer_1.setLeftComponent(lbl_SavingThrows_1);
		
		JSplitPane split_Saves_1 = new JSplitPane();
		split_Saves_1.setResizeWeight(0.5);
		split_SavingThrowsContainer_1.setRightComponent(split_Saves_1);
		
		JSplitPane split_SavingThrows_1 = new JSplitPane();
		split_SavingThrows_1.setResizeWeight(0.5);
		split_Saves_1.setLeftComponent(split_SavingThrows_1);
		
		JPanel panel_ProficientSaves_1 = new JPanel();
		split_SavingThrows_1.setLeftComponent(panel_ProficientSaves_1);
		panel_ProficientSaves_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JRadioButton rad_StrSaveProf_1 = new JRadioButton("");
		rad_StrSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_StrSaveProf_1);
		
		JRadioButton rad_DexSaveProf_1 = new JRadioButton("");
		rad_DexSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_DexSaveProf_1);
		
		JRadioButton rad_ConSaveProf_1 = new JRadioButton("");
		rad_ConSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_ConSaveProf_1);
		
		JRadioButton rad_IntSaveProf_1 = new JRadioButton("");
		rad_IntSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_IntSaveProf_1);
		
		JRadioButton rad_WisSaveProf_1 = new JRadioButton("");
		rad_WisSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_WisSaveProf_1);
		
		JRadioButton rad_ChrSaveProf_1 = new JRadioButton("");
		rad_ChrSaveProf_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ProficientSaves_1.add(rad_ChrSaveProf_1);
		
		JPanel panel_SavingThrowBonus_1 = new JPanel();
		split_SavingThrows_1.setRightComponent(panel_SavingThrowBonus_1);
		panel_SavingThrowBonus_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lbl_StrSaveBonus_1 = new JLabel("+2");
		lbl_StrSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_StrSaveBonus_1);
		
		JLabel lbl_DexSaveBonus_1 = new JLabel("+2");
		lbl_DexSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_DexSaveBonus_1);
		
		JLabel lbl_ConSaveBonus_1 = new JLabel("+2");
		lbl_ConSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_ConSaveBonus_1);
		
		JLabel lbl_IntSaveBonus_1 = new JLabel("+2");
		lbl_IntSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_IntSaveBonus_1);
		
		JLabel lbl_WisSaveBonus_1 = new JLabel("+2");
		lbl_WisSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_WisSaveBonus_1);
		
		JLabel lbl_ChrSaveBonus_1 = new JLabel("+2");
		lbl_ChrSaveBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowBonus_1.add(lbl_ChrSaveBonus_1);
		
		JPanel panel_SavingThrowLabels_1 = new JPanel();
		split_Saves_1.setRightComponent(panel_SavingThrowLabels_1);
		panel_SavingThrowLabels_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lbl_StrSave_1 = new JLabel("Strength");
		lbl_StrSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_StrSave_1);
		
		JLabel lbl_DexSave_1 = new JLabel("Dexterity");
		lbl_DexSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_DexSave_1);
		
		JLabel lbl_ConSave_1 = new JLabel("Constitution");
		lbl_ConSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_ConSave_1);
		
		JLabel lbl_IntSave_1 = new JLabel("Intelligence");
		lbl_IntSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_IntSave_1);
		
		JLabel lbl_WisSave_1 = new JLabel("Wisdom");
		lbl_WisSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_WisSave_1);
		
		JLabel lbl_ChrSave_1 = new JLabel("Charisma");
		lbl_ChrSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SavingThrowLabels_1.add(lbl_ChrSave_1);
		
		JPanel panel_ImportantValues_1 = new JPanel();
		split_ImportantDetails_1.setRightComponent(panel_ImportantValues_1);
		panel_ImportantValues_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JSplitPane split_AC_1 = new JSplitPane();
		split_AC_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_ImportantValues_1.add(split_AC_1);
		
		JLabel lbl_AC_1 = new JLabel("AC");
		lbl_AC_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_AC_1.setLeftComponent(lbl_AC_1);
		
		JLabel lbl_ACValue_1 = new JLabel("22");
		lbl_ACValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ACValue_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		split_AC_1.setRightComponent(lbl_ACValue_1);
		
		JSplitPane split_Inititative_1 = new JSplitPane();
		split_Inititative_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_ImportantValues_1.add(split_Inititative_1);
		
		JLabel lbl_Initiative_1 = new JLabel("Initiative");
		lbl_Initiative_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_Inititative_1.setLeftComponent(lbl_Initiative_1);
		
		JLabel lbl__InitValue_1 = new JLabel("+2");
		lbl__InitValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl__InitValue_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		split_Inititative_1.setRightComponent(lbl__InitValue_1);
		
		JSplitPane split_Proficiency_1 = new JSplitPane();
		split_Proficiency_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_ImportantValues_1.add(split_Proficiency_1);
		
		JLabel lbl_ProfBonus_1 = new JLabel("Proficiency");
		lbl_ProfBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_Proficiency_1.setLeftComponent(lbl_ProfBonus_1);
		
		JLabel lbl__ProfValue_1 = new JLabel("4");
		lbl__ProfValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl__ProfValue_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		split_Proficiency_1.setRightComponent(lbl__ProfValue_1);
		
		JSplitPane split_Inspiration_1 = new JSplitPane();
		split_Inspiration_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_ImportantValues_1.add(split_Inspiration_1);
		
		JLabel lbl_Inspiration_1 = new JLabel("Inspiration");
		lbl_Inspiration_1.setHorizontalAlignment(SwingConstants.CENTER);
		split_Inspiration_1.setLeftComponent(lbl_Inspiration_1);
		
		JLabel lbl__InspValue_1 = new JLabel("1");
		lbl__InspValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl__InspValue_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		split_Inspiration_1.setRightComponent(lbl__InspValue_1);
		
		JTabbedPane tabs_Statistics = new JTabbedPane(JTabbedPane.TOP);
		splitPane_20.setRightComponent(tabs_Statistics);
		
		JPanel panel_Abilities = new JPanel();
		tabs_Statistics.addTab("Core", null, panel_Abilities, null);
		panel_Abilities.setLayout(new GridLayout(1, 2, 0, 0));
		
		JSplitPane splitPane_21 = new JSplitPane();
		splitPane_21.setResizeWeight(0.5);
		panel_Abilities.add(splitPane_21);
		
		JSplitPane splitPane_22 = new JSplitPane();
		splitPane_21.setLeftComponent(splitPane_22);
		
		JSplitPane splitPane_23 = new JSplitPane();
		splitPane_23.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_22.setLeftComponent(splitPane_23);
		
		JSplitPane splitPane_25 = new JSplitPane();
		splitPane_25.setResizeWeight(0.5);
		splitPane_23.setRightComponent(splitPane_25);
		
		JSplitPane splitPane_26 = new JSplitPane();
		splitPane_26.setResizeWeight(0.5);
		splitPane_25.setLeftComponent(splitPane_26);
		
		JPanel panel_AbilityNames = new JPanel();
		splitPane_26.setLeftComponent(panel_AbilityNames);
		panel_AbilityNames.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lbl_Strength = new JLabel("STR: ");
		panel_AbilityNames.add(lbl_Strength);
		
		JLabel lbl_Dexterity = new JLabel("DEX: ");
		panel_AbilityNames.add(lbl_Dexterity);
		
		JLabel lbl_Constitution = new JLabel("CON: ");
		panel_AbilityNames.add(lbl_Constitution);
		
		JLabel lbl_Intelligence = new JLabel("INT: ");
		panel_AbilityNames.add(lbl_Intelligence);
		
		JLabel lbl_Wisdom = new JLabel("WIS: ");
		panel_AbilityNames.add(lbl_Wisdom);
		
		JLabel lbl_Charisma = new JLabel("CHR: ");
		panel_AbilityNames.add(lbl_Charisma);
		
		JPanel panel_AbilityMods = new JPanel();
		splitPane_26.setRightComponent(panel_AbilityMods);
		panel_AbilityMods.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lbl_StrMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_StrMod);
		
		JLabel lbl_DexMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_DexMod);
		
		JLabel lbl_ConMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_ConMod);
		
		JLabel lbl_IntMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_IntMod);
		
		JLabel lbl_WisMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_WisMod);
		
		JLabel lbl_ChrMod = new JLabel("  +5  ");
		panel_AbilityMods.add(lbl_ChrMod);
		
		JPanel panel_AbilityScores = new JPanel();
		splitPane_25.setRightComponent(panel_AbilityScores);
		panel_AbilityScores.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lbl_StrScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_StrScore);
		
		JLabel lbl_DexScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_DexScore);
		
		JLabel lbl_ConScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_ConScore);
		
		JLabel lbl_IntScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_IntScore);
		
		JLabel lbl_WisScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_WisScore);
		
		JLabel lbl_ChrScore = new JLabel("  (20)  ");
		panel_AbilityScores.add(lbl_ChrScore);
		
		JLabel lbl_AbilityScores = new JLabel("Ability Scores");
		lbl_AbilityScores.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_23.setLeftComponent(lbl_AbilityScores);
		
		JSplitPane splitPane_24 = new JSplitPane();
		splitPane_24.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_22.setRightComponent(splitPane_24);
		
		JLabel lblNewLabel_7 = new JLabel("Skills");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_24.setLeftComponent(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		splitPane_24.setRightComponent(panel_1);
		
		JSplitPane splitPane_27 = new JSplitPane();
		splitPane_27.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_21.setRightComponent(splitPane_27);
		
		JLabel lblNewLabel_8 = new JLabel("Proficiences");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_27.setLeftComponent(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		splitPane_27.setRightComponent(panel_2);
		
		JPanel panel_Actions = new JPanel();
		tabs_Statistics.addTab("Actions", null, panel_Actions, null);
		
		JPanel panel_Features = new JPanel();
		tabs_Statistics.addTab("Features", null, panel_Features, null);
	}	
}
