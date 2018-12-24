import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class Admin1 extends JFrame
{
	JButton JBUpdt = new JButton("Update",new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JTextField passConfFail = new JTextField();

	JLabel JLAdminId = new JLabel("ID:");
	JLabel JLAdminName = new JLabel("Name:");
	JLabel JLAdminAddr = new JLabel("Address:");
	JLabel JLAdminPhone = new JLabel("Phone:");
	JLabel JLAdminLogin = new JLabel("Login:");
	JLabel JLAdminPass = new JLabel("Password:");
	JLabel JLAdminPassConf = new JLabel("Confirm Password:");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFLogin = new JTextField();
	JPasswordField JTFPass = new JPasswordField();
	JPasswordField JTFPassConf = new JPasswordField();

	JLabel StatusLabel = new JLabel("CREATED BY ROHAN AND GOKUL",JLabel.CENTER);

	String AdminId=null;

	public Admin1(String adminid)
    {
    	setTitle("Entries");
    	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

    	setDefaultCloseOperation(EXIT_ON_CLOSE);

    	AdminId = adminid;

    	JPanel JPContainer = new JPanel();
		JPContainer.setLayout(null);

		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner.setBounds(45,5,268,48);
		JLBanner.setFont(new Font("Dialog",Font.BOLD,14));
		JPContainer.add(JLBanner);

		//******************** Start adding of input field
		//-- Add Id Input Field
		JLAdminId.setBounds(10,50,105,20);
		JLAdminId.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFId.setBounds(115,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));
		JTFId.addActionListener(JBActionListener);

		JPContainer.add(JLAdminId);
		JPContainer.add(JTFId);

		//-- Add Name Input Field
		JLAdminName.setBounds(10,72,105,20);
		JLAdminName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFName.setBounds(115,72,200,20);
		JTFName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminName);
		JPContainer.add(JTFName);

		//-- Add Address Input Field
		JLAdminAddr.setBounds(10,94,105,20);
		JLAdminAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFAddr.setBounds(115,94,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminAddr);
		JPContainer.add(JTFAddr);

		//-- Add Phone Input Field
		JLAdminPhone.setBounds(10,116,105,20);
		JLAdminPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFPhone.setBounds(115,116,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminPhone);
		JPContainer.add(JTFPhone);

		//-- Add Login Input Field
		JLAdminLogin.setBounds(10,182,105,20);
		JLAdminLogin.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFLogin.setBounds(115,182,200,20);
		JTFLogin.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminLogin);
		JPContainer.add(JTFLogin);

		//-- Add Pass  Input Field
		JLAdminPass.setBounds(10,204,105,20);
		JLAdminPass.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFPass.setBounds(115,204,200,20);
		JTFPass.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminPass);
		JPContainer.add(JTFPass);

		//-- Add Pass  Input Field
		JLAdminPassConf.setBounds(10,226,105,20);
		JLAdminPassConf.setFont(new Font("Dialog",Font.PLAIN,11));

		JTFPassConf.setBounds(115,226,200,20);
		JTFPassConf.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAdminPassConf);
		JPContainer.add(JTFPassConf);

		//-- Add the JBReset
		JBReset.setBounds(112,260,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBSave
		JBUpdt.setBounds(12,260,99,25);
		JBUpdt.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdt.addActionListener(JBActionListener);
		JBUpdt.setActionCommand("update");
		JPContainer.add(JBUpdt);

		//-- Add the JBCancel
		JBCancel.setBounds(212,260,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		StatusLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		getContentPane().add(StatusLabel,BorderLayout.PAGE_END);

		getContentPane().add(JPContainer);
		setSize(332,353);
		setResizable(true);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);
	         try
	         {

	                 	Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();

    					String str= "SELECT * FROM Admin WHERE A_No=\'"+AdminId+"\'";

    					ResultSet rs = s.executeQuery(str);
    					System.out.println(AdminId);
		    			rs.next();
		    			JTFId.setText("" + rs.getString(1));
		    			JTFId.setEditable(false);
						JTFName.setText("" + rs.getString(2));
						JTFAddr.setText("" + rs.getString(3));
						JTFPhone.setText("" + rs.getString(4));
						JTFLogin.setText("" + rs.getString(5));

						JTFPass.setText("" + rs.getString(6));
						JTFPassConf.setText("" + rs.getString(6));
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
				dispose();
			}
			else if (srcObj =="update")
			{
				System.out.println("M"+srcObj);
				if(JTFId.getText().equals("")|| JTFName.getText().equals("")||JTFAddr.getText().equals("")||JTFPhone.getText().equals("")||JTFLogin.getText().equals("")||JTFPass.getText().equals("")||JTFPassConf.getText().equals(""))
			  JOptionPane.showMessageDialog(null,"Fill all the Fields of Form","Error in Adding",JOptionPane.ERROR_MESSAGE);
			  else if(!JTFPass.getText().equals(JTFPassConf.getText()))
				{
					JOptionPane.showMessageDialog(null,"Password confirmation Failed.","Password confirmation",JOptionPane.WARNING_MESSAGE);
					passConfFail.requestFocus();
					JTFPass.setText("");
					JTFPassConf.setText("");
				}
			 else
			 {

				try
				{
						Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();
				System.out.println("N"+srcObj);
						String str="Update Admin set A_Name = \'"+JTFName.getText()+"\',A_Addr = \'"+JTFAddr.getText()+"\',A_Phno="+JTFPhone.getText()+",A_login = \'"+JTFLogin.getText()+"\',A_pass = \'"+JTFPass.getText()+"\' WHERE A_no=\'"+JTFId.getText()+"\'";
					    s.executeUpdate(str);
					    System.out.println(str);

					    JOptionPane.showMessageDialog(null,"Admin record has been successfully updated.","Admin Updation",JOptionPane.INFORMATION_MESSAGE);

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
					JTFLogin.setText("");
					JTFPass.setText("");
					JTFPassConf.setText("");
			}
		}
	};
}
public class updateadmin extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag;
	String strEid;
	String strPass;
		String temp;
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Please fill the required fields carefully");

	JLabel JLId = new JLabel("Admin ID");
	JLabel JLPass=new JLabel("Password");

	JTextField JTFId = new JTextField();
	JPasswordField JTFPass = new JPasswordField();

    public updateadmin()
    {
    	setTitle("Updation of Admin");

    	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

    	setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel JPContainer = new JPanel();

		JPContainer.setLayout(null);

		JLPic.setBounds(5,5,32,32);
		JPContainer.add(JLPic);

		JLBanner.setBounds(45,5,300,48);
		JLBanner.setFont(new Font("Dialog",Font.BOLD,14));
		JPContainer.add(JLBanner);

		//add ID InputField
		JLId.setBounds(50,50,105,20);
		JLId.setFont(new Font("Dialog",Font.PLAIN,12));


		JTFId.setBounds(120,50,150,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));

		JLPass.setBounds(50,75,105,20);
		JLPass.setFont(new Font("Dialog",Font.PLAIN,12));


		JTFPass.setBounds(120,75,150,20);
		JTFPass.setFont(new Font("Dialog",Font.PLAIN,12));
		JTFPass.addActionListener(this);


		JPContainer.add(JLId);
		JPContainer.add(JTFId);
			JPContainer.add(JLPass);
		JPContainer.add(JTFPass);


		//-- Add the JBReset
		JBReset.setBounds(112,100,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.addActionListener(this);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBDelete
		JBEnter.setBounds(12,100,99,25);
		JBEnter.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBEnter.addActionListener(this);
		JBEnter.setActionCommand("save");
		JPContainer.add(JBEnter);

		//-- Add the JBCancel
		JBCancel.setBounds(212,100,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
         	JBCancel.addActionListener(this);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setLocation((screen.width-350)/2,((screen.height-165)/2));
		setSize(360,200);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource() == JBEnter || ae.getSource() == JTFPass)
    	{
    		System.out.println("delete");
    		if(JTFId.getText().equals("") || JTFPass.getText().equals("") )
    		{
    			JOptionPane.showMessageDialog(null,"Please Fill all Fields ","Error in searching ",JOptionPane.WARNING_MESSAGE);
    		}
    		else
    		{
    				try
					{
						Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				    Statement stmt = c.createStatement();
    					ResultSet rs=stmt.executeQuery("select * from Admin");
    					while(rs.next())
    					{
    						strEid=rs.getString(1);
    						strPass=rs.getString(6);
    						System.out.println("loop");
    						if(strEid.equals(JTFId.getText() ))
    						{
    							flag=true;
    						 temp=strPass;
    							System.out.println("flase4545");
    							break;

    						}
    						else
    							{
    						         System.out.println("true45645");
    							 						 flag=false;
    							}
    					}//while
    					if(flag==true)
    					{
    					   if(temp.equals(JTFPass.getText() ))
    					   {

    					    new Admin1(strEid);
    					    dispose();
    					   }
    					   else
    					   	JOptionPane.showMessageDialog(null,"Invalid Admin ID or Password","Error in Searching",JOptionPane.ERROR_MESSAGE);
    					}
    					else
    					{
    						JOptionPane.showMessageDialog(null,"Invalid Admin ID or Password","Error in Searching",JOptionPane.ERROR_MESSAGE);

    					}
    				}
					catch(Exception e)
					{
						System.out.println(e);
					}

    		}
    	}
    	else if(ae.getSource() == JBCancel)
    	{
    		dispose();
    	}
    	else if(ae.getSource() == JBReset)
    	{
    		JTFId.setText("");
    		JTFPass.setText("");
    	}
    }
public static void main(String args[])
{
new updateadmin();
}
}
