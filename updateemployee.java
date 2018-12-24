import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class Employee1 extends JFrame
{
JButton JBUpdt = new JButton("Update",new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Update only the required fields.");


	JLabel JLempId = new JLabel("ID:");
	JLabel JLempName = new JLabel("Name:");
	JLabel JLempAddr = new JLabel("Address:");
	JLabel JLempLocat = new JLabel("Location:");
	JLabel JLempPhone = new JLabel("Phone:");
	JLabel JLProcess = new JLabel("Process:");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFLocat = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFProcess = new JTextField();



	public Employee1(String EId)
    {
    	setTitle("Updation of Employee Record");
    	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

    	JPanel JPContainer = new JPanel();
		JPContainer.setLayout(null);
	
		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner.setBounds(45,5,268,48);
		JLBanner.setFont(new Font("Dialog",Font.BOLD,14));
		JPContainer.add(JLBanner);

		//************ Start adding of input field***********//
		//-- Add Id Input Field
		JLempId.setBounds(5,50,105,20);
		JLempId.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFId.setBounds(110,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempId);
		JPContainer.add(JTFId);
		JTFId.addActionListener(JBActionListener);

		//-- Add Name Input Field
		JLempName.setBounds(5,72,105,20);
		JLempName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFName.setBounds(110,72,200,20);
		JTFName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempName);
		JPContainer.add(JTFName);

		//-- Add Address Input Field
		JLempAddr.setBounds(5,94,105,20);
		JLempAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFAddr.setBounds(110,94,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempAddr);
		JPContainer.add(JTFAddr);

		//-- Add Phone Input Field
		JLempPhone.setBounds(5,116,105,20);
		JLempPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFPhone.setBounds(110,116,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempPhone);
		JPContainer.add(JTFPhone);
		
		//-- Add Process Input Field
		JLProcess.setBounds(5,160,105,20);
		JLProcess.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFProcess.setBounds(110,160,200,20);
		JTFProcess.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLProcess);
		JPContainer.add(JTFProcess);

		//-- Add Location Input Field
		JLempLocat.setBounds(5,138,105,20);
		JLempLocat.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFLocat.setBounds(110,138,200,20);
		JTFLocat.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempLocat);
		JPContainer.add(JTFLocat);

		//-- Add the JBUpdate
		JBUpdt.setBounds(5,190,105,25);
		JBUpdt.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdt.addActionListener(JBActionListener);
		JBUpdt.setActionCommand("update");
		JPContainer.add(JBUpdt);

		//-- Add the JBReset
		JBReset.setBounds(112,190,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBCancel
		JBCancel.setBounds(212,190,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(325,273);
		setResizable(false);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);
    
             try
	         {
	                 
	                    Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();
    					String str= "SELECT * FROM Employees WHERE E_Id=\'"+EId+"\'";
    					ResultSet rs = s.executeQuery(str);
		    			rs.next();
		    			JTFId.setText("" + rs.getString(1));
		    			JTFId.setEditable(false);
						JTFName.setText("" + rs.getString(2));
						JTFAddr.setText("" + rs.getString(3));
						JTFLocat.setText("" + rs.getString(4));
						JTFPhone.setText("" + rs.getString(5));
						JTFProcess.setText("" + rs.getString(6));
	         }
	         catch(Exception e)
	         {
	         }
						
    }
    ActionListener JBActionListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			String srcObj = ae.getActionCommand();
			if(srcObj=="cancel")
			{
			//	new tabbedpane();
				dispose();
			}
			else if (srcObj =="update")
			{
				System.out.println("M"+srcObj);
			 if(JTFId.getText().equals("")|| JTFName.getText().equals("")||JTFAddr.getText().equals("")||JTFLocat.getText().equals("")||JTFPhone.getText().equals("")||JTFProcess.getText().equals(""))
			  JOptionPane.showMessageDialog(null,"Fill all the Fields of Form","Error in Updating",JOptionPane.ERROR_MESSAGE);
			 else
			 {
			 
				try
				{
						Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();
				System.out.println("N"+srcObj);
				String str="Update Employees set E_Name = \'"+JTFName.getText()+"\',E_Addr = \'"+JTFAddr.getText()+"\',E_Loc = \'"+JTFLocat.getText()+"\',E_Phno="+JTFPhone.getText()+",E_Process = \'"+JTFProcess.getText()+"\' WHERE E_Id=\'"+JTFId.getText()+"\'";
					    s.executeUpdate(str);
					    System.out.println(str);

					    JOptionPane.showMessageDialog(null,"Employee record has been successfully updated.","Employee Updation",JOptionPane.INFORMATION_MESSAGE);
					//	new tabbedpane();
						dispose();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			 }
			}
			
			else if(srcObj=="reset")
			{
					
				
						
						JTFName.setText("");
						JTFAddr.setText("");
						JTFPhone.setText("");
						JTFLocat.setText("");
						JTFProcess.setText("");}
		}
	};
}


public class updateemployee extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag;
	
	String strEid;	 
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Choose Employee ID from the List.");

	JLabel JLId = new JLabel("Employee ID");
	
	JTextField JTFId = new JTextField();

			int entry=0,i=1;
    JComboBox jcb;
    String did;
    public updateemployee()
    {
    	setTitle("Updation of Employee");
      try
    	{
       
    	Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				    Statement stmt = c.createStatement();
    					ResultSet rs=stmt.executeQuery("select * from Employees");
    					while(rs.next())
    					{
    					  entry++;
    					  
    					}
       }
       catch(Exception e)
       {}
    		String driv[]=new String[entry+1];
    		driv[0]="-- Select 0ne --";		
    	try
    	{
    	
    	Class.forName("org.gjt.mm.mysql.Driver");
    				Connection	c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				 Statement   stmt = c.createStatement();
    				ResultSet	rs=stmt.executeQuery("select * from Employees");
    					while(rs.next())
    					{
    					    driv[i]=rs.getString(1);
    					    System.out.println(driv[i]+ " "+rs.getString(2));
    					    i++;
    					}				
    	}
    	catch(Exception e)
    	{
    	}
    	jcb=new JComboBox(driv);
       	
    	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

    	setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel JPContainer = new JPanel();

		JPContainer.setLayout(null);
		
		JLPic.setBounds(5,5,32,32);
		JPContainer.add(JLPic);

		JLBanner.setBounds(45,5,268,48);
		JLBanner.setFont(new Font("Dialog",Font.BOLD,14));
		JPContainer.add(JLBanner);

		//add ID InputField
		JLId.setBounds(50,50,105,20);
		JLId.setFont(new Font("Dialog",Font.PLAIN,12));
		
		
		jcb.setBounds(130,50,150,20);

		JPContainer.add(JLId);
		JPContainer.add(jcb);

		//-- Add the JBReset
		JBReset.setBounds(112,100,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.addActionListener(this);
		JBReset.setActionCommand("reset");

		//-- Add the JBDelete
		JBEnter.setBounds(12,100,99,25);
		JBEnter.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBEnter.addActionListener(this);
		JBEnter.setActionCommand("enter");
		JPContainer.add(JBEnter);

		//-- Add the JBCancel
		JBCancel.setBounds(212,100,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(this);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setLocation((screen.width-350)/2,((screen.height-165)/2));
		setSize(340,200);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	JButton sourceBtn = (JButton)ae.getSource();
    	if(sourceBtn == JBEnter)
    	{
    		did=(String)jcb.getSelectedItem();
    	     if(did.equals("-- Select 0ne --"))
    	     	JOptionPane.showMessageDialog(null,"Select one OPTION from the Combo Box","Incorrect Selection",JOptionPane.ERROR_MESSAGE);
    		else
    		{
    			new Employee1(did);
    			dispose();
    		}
    	}
    	else if(sourceBtn == JBCancel)
    	{
    		dispose();
    	}
    	else if(sourceBtn == JBReset)
    	{
    		JTFId.setText("");
    	}
    }
public static void main(String args[])
{
new updateemployee();
}
}
