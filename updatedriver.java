import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class Driver1 extends JFrame
{
    JButton JBUpdt = new JButton("Update",new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Update only the required fields.");


	JLabel JLDriId = new JLabel("ID :");
	JLabel JLDriName = new JLabel("Name :");
	JLabel JLDriTravAge = new JLabel("Travel Agency :");
	JLabel JLDriAddr = new JLabel("Address :");
	JLabel JLDriPhone = new JLabel("Phone :");
	JLabel JLDriVno = new JLabel("Vehical No :");
	JLabel JLDriJoin = new JLabel("Date of join :");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFTravAge = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFVno = new JTextField();
	JTextField JTFJoin = new JTextField();

	public Driver1(String Did)
    {
    	setTitle("Entries of driver");
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

		//******************** Start adding of input field
		//-- Add Id Input Field
		JLDriId.setBounds(5,50,105,20);
		JLDriId.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFId.setBounds(110,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriId);
		JPContainer.add(JTFId);
		JTFId.addActionListener(JBActionListener);

		//-- Add Name Input Field
		JLDriName.setBounds(5,72,105,20);
		JLDriName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFName.setBounds(110,72,200,20);
		JTFName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriName);
		JPContainer.add(JTFName);

		//-- Add Address Input Field
		JLDriAddr.setBounds(5,94,105,20);
		JLDriAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFAddr.setBounds(110,94,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriAddr);
		JPContainer.add(JTFAddr);

		//-- Add Phone Input Field
		JLDriPhone.setBounds(5,116,105,20);
		JLDriPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFPhone.setBounds(110,116,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriPhone);
		JPContainer.add(JTFPhone);

		//-- Add Location Input Field
		JLDriTravAge.setBounds(5,138,105,20);
		JLDriTravAge.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFTravAge.setBounds(110,138,200,20);
		JTFTravAge.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriTravAge);
		JPContainer.add(JTFTravAge);

		//-- Add Vehical No Input Field
		JLDriVno.setBounds(5,160,105,20);
		JLDriVno.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFVno.setBounds(110,160,200,20);
		JTFVno.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriVno);
		JPContainer.add(JTFVno);

		//-- Add Date of Joining
		JLDriJoin.setBounds(5,182,105,20);
		JLDriJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFJoin.setBounds(110,182,90,20);
		JTFJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriJoin);
		JPContainer.add(JTFJoin);



		//-- Add the JBUpdate
		JBUpdt.setBounds(5,260,105,25);
		JBUpdt.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdt.addActionListener(JBActionListener);
		JBUpdt.setActionCommand("update");
		JPContainer.add(JBUpdt);

		//-- Add the JBReset
		JBReset.setBounds(112,260,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBCancel
		JBCancel.setBounds(212,260,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);


		getContentPane().add(JPContainer);
		setSize(325,353);
		setResizable(false);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);

             try
	         {
                        Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();
    					String str= "SELECT * FROM Driver WHERE D_No=\'"+Did+"\'";
    					ResultSet rs = s.executeQuery(str);
		    			rs.next();
		    			JTFId.setText("" + rs.getString(1));
						JTFId.setEditable(false);
						JTFName.setText("" + rs.getString(2));
						JTFAddr.setText("" + rs.getString(3));
						JTFTravAge.setText("" + rs.getString(4));
						JTFPhone.setText("" + rs.getString(5));
						JTFVno.setText("" + rs.getString(6));
						JTFJoin.setText("" + rs.getString(7));
						JTFJoin.setEditable(false);

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
			 if(	JTFId.getText().equals("") ||JTFName.getText().equals("") ||JTFAddr.getText().equals("")||JTFPhone.getText().equals("")||JTFVno.getText().equals("")||JTFJoin.getText().equals("")||JTFTravAge.getText().equals(""))

				{
					JOptionPane.showMessageDialog(null,"Fill all the Fields of Form","Error in Updating",JOptionPane.ERROR_MESSAGE);

				}
			else
			{

				try
				{
						Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    					Statement s = c.createStatement();
			        	System.out.println("N"+srcObj);
				        String str="Update Driver set D_Name = \'"+JTFName.getText()+"\',D_Addr = \'"+JTFAddr.getText()+"\',Process = \'"+JTFTravAge.getText()+"\',D_Phno="+JTFPhone.getText()+",C_no = \'"+JTFVno.getText()+"\',Date_Join = \'"+JTFJoin.getText()+"\' WHERE D_No=\'"+JTFId.getText()+"\'";
					    s.executeUpdate(str);
					    System.out.println(str);

					    JOptionPane.showMessageDialog(null,"Driver record has been successfully updated.","Driver Updation",JOptionPane.INFORMATION_MESSAGE);

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
						JTFTravAge.setText("");
						JTFPhone.setText("");
						JTFVno.setText("");
			}

			}
	};
}


public class updatedriver extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag;

	String strEid;
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Choose Driver ID from the List.");

	JLabel JLId = new JLabel("Driver ID");

	JTextField JTFId = new JTextField();

	int entry=0,i=1;
    JComboBox jcb;
    String did;

    public updatedriver()
    {
    	setTitle("Updation of Driver Record");
    	 try
       {

    	Class.forName("org.gjt.mm.mysql.Driver");
    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				    Statement stmt = c.createStatement();
    					ResultSet rs=stmt.executeQuery("select * from Driver");
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
    				ResultSet	rs=stmt.executeQuery("select * from Driver");
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


		jcb.setBounds(120,50,150,20);

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
		JBEnter.setActionCommand("update");
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
    		{			   new Driver1(did);
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
new updatedriver();
}
}
