import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tabbedpane extends JFrame implements ActionListener
{	
	int da,da1;
	
	JLabel JBLab = new JLabel("        *   Select the TAB according to Profession.");
	JLabel JBLab1 = new JLabel("        *   Select 'ADD' Button to add a new Profile.");
	JLabel JBLab2 = new JLabel("        *   Select 'EDIT' Button to update/edit a Profile.");
	JLabel JBLab3 = new JLabel("        *   Select 'DELETE' Button to delete a Profile.");
	JLabel JBLab4 = new JLabel("        *   Click 'ENTER'  after Button selection's.");
	JLabel JBLab5 = new JLabel("        *   Click 'SEARCH'  for Driver's PICKUP/DROP Details.");
	JLabel JBLab6 = new JLabel("        *   Click 'ROSTER'  to create a Roster for Driver.");
	JLabel JBLab7 = new JLabel("        *   Click 'LOG'  to create a LOG ENTRIES for Driver.");


	JButton JBOk = new JButton("ENTER",new ImageIcon("images/enter.png"));
	JButton JBSearch = new JButton("SEARCH",new ImageIcon("images/search.png"));
	JButton JBTable = new JButton("ROSTER",new ImageIcon("images/roster.png"));
	JButton JBLOG = new JButton("LOG",new ImageIcon("images/log.png"));
	JButton JBLOGOUT = new JButton("LOG OUT",new ImageIcon("images/exit.png"));

	JRadioButton JBEdit = new JRadioButton("EDIT/UPDATE",false);
        JRadioButton JBAddnew2 = new JRadioButton("ADD",false);
	JRadioButton JBEdit2 = new JRadioButton("EDIT",false);
	JRadioButton JBDelete2 = new JRadioButton("DELETE",false);
	
	JRadioButton JBAddnew3 = new JRadioButton("ADD",false);
	JRadioButton JBEdit3 = new JRadioButton("EDIT",false);
	JRadioButton JBDelete3 = new JRadioButton("DELETE",false);
	ButtonGroup group=new ButtonGroup();
	ButtonGroup group1=new ButtonGroup();	
	class buttonpanel1 extends Panel
	{
		public buttonpanel1() 
		{}
	}
	
	class buttonpanel extends Panel
	{
		public buttonpanel() 
		{}
	}		

	class labelpanel extends Panel
	{
		public void labelpanel() 
		{}
	}

	public tabbedpane() 
	{
		super("CAB MANAGEMENT SYSTEM");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		}
		);

		Container contentPane = getContentPane();
		JTabbedPane jtab = new JTabbedPane();
		buttonpanel panel1 = new buttonpanel();
		buttonpanel1 panel7 = new buttonpanel1();
		buttonpanel1 panel8 = new buttonpanel1();
		buttonpanel1 panel9 = new buttonpanel1();
		buttonpanel1 panel10 = new buttonpanel1();
		
		labelpanel panel6 = new labelpanel();
		JPanel jpanel1 = new JPanel();
		
		jpanel1.add(panel1);
		
		
		jtab.addTab("ADMINISTRATOR",new ImageIcon(""),panel7, " To edit Administrators record click this tab");
			
		jtab.addTab("DRIVER",new ImageIcon(""),panel9, "To edit Drivers record click this tab ");
	
		
		jtab.addTab("EMPLOYEE",new ImageIcon(""),panel10, "To edit Employee record click this tab ");
		
		add(jtab);	

		panel1.add(JBOk);
		panel1.add(JBSearch);
		panel1.add(JBTable);
		panel1.add(JBLOG);
		panel1.add(JBLOGOUT);

		panel7.add(JBEdit);
		group.add(JBAddnew2);
		group.add(JBEdit2);
		group.add(JBDelete2);
		
		group.add(JBAddnew3);
		group.add(JBEdit3);
		group.add(JBDelete3);
	    group.add(JBEdit);
		panel9.add(JBAddnew2);
		panel9.add(JBEdit2);
		panel9.add(JBDelete2);
		
		
		panel10.add(JBAddnew3);
		panel10.add(JBEdit3);
		panel10.add(JBDelete3);
		
		setLayout(null);
		
		JBEdit.setBounds(130,30,100,20);		
		JBAddnew2.setBounds(50,30,60,20);
		JBEdit2.setBounds(130,30,60,20);
		JBDelete2.setBounds(210,30,60,20);
		
		JBAddnew3.setBounds(50,30,60,20);
		JBEdit3.setBounds(130,30,60,20);
		JBDelete3.setBounds(210,30,60,20);
		
		JBSearch.addActionListener(this);
		JBOk.addActionListener(this);
		JBTable.addActionListener(this);
		JBLOG.addActionListener(this);
		JBLOGOUT.addActionListener(this);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(jtab, BorderLayout.NORTH);
		contentPane.add(panel1, BorderLayout.SOUTH);
		contentPane.add(panel6, BorderLayout.CENTER);
		panel6.setLayout(new GridLayout(7,1));
		JBLab6.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab1.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab2.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab3.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab4.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab5.setFont(new Font("Dialog",Font.PLAIN,12));		
		JBLab7.setFont(new Font("Dialog",Font.PLAIN,12));		

	        panel6.add(JBLab1);
		panel6.add(JBLab2);
		panel6.add(JBLab3);
		panel6.add(JBLab4);
		panel6.add(JBLab5);
		panel6.add(JBLab6);
		panel6.add(JBLab7);

		setLocation(260,140);
		setSize(570,500);
		setResizable(false);
		setVisible(true);

		
		da = jtab.indexOfTab("ADMINISTRATOR");
		da1 = jtab.indexOfTab("SECURITY");
	}
	public void actionPerformed(ActionEvent ae)
	{
		JButton chkbtn = (JButton)ae.getSource();

		if(chkbtn == JBLOGOUT)
		{
			dispose();
			JOptionPane.showMessageDialog(null,"Logged Out Successfully.","LOGGED OUT",JOptionPane.INFORMATION_MESSAGE);	
		}		

		if(chkbtn == JBSearch)
		{
			new SearchAll();
		}
		if(chkbtn == JBTable)
		{
			new table1();
		}
        if(chkbtn == JBLOG)
		{
			new log();
		}
              
 		if(chkbtn == JBOk)
		{
			
			System.out.println(da);
			if(JBAddnew2.isSelected())
			{
				System.out.println("DRIVER ADD");
				new tabbedpane();
				dispose();
				new Entries_Driver();
			}
		
			if(JBAddnew3.isSelected())
			{
				System.out.println("EMPLOYEE ADD");
				new tabbedpane();
				dispose();
				new Entries_Emp();
			//	dispose();
			}

			if(JBEdit.isSelected())
			{
				System.out.print("ADMINISTRATOR MODIFY");
				new tabbedpane();
				dispose();
				new updateadmin();
				//dispose();
			}
			
			if(JBEdit2.isSelected())
			{
				new tabbedpane();
				dispose();
				new updatedriver();
				System.out.println("DRIVER MODIFY");
			//	dispose();
			}
		
			if(JBEdit3.isSelected())
			{
				System.out.println("EMPLOYEE MODIFY");
				new tabbedpane();
				dispose();
				new updateemployee();
				//dispose();
			}

			if(JBDelete2.isSelected())
			{
				System.out.println("DRIVER DELETE");
				new tabbedpane();
				dispose();
				new deletedriv();
			}

			if(JBDelete3.isSelected())
			{
				System.out.println("EMPLOYEE DELETE");
				new tabbedpane();
				dispose();
				new deleteemp();
			//	dispose();
			}
		}	
	}
	public static void main(String s[])
	{
		new tabbedpane();
	}
}
	
