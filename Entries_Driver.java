import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.*;

public class Entries_Driver extends JFrame implements ActionListener
{
	Boolean flag,flag1,flag6,flag7=true;
	String strDid;
	JButton JBUpdt = new JButton("Save",new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	JButton JBJoin = new JButton("Join",new ImageIcon("image/Time"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLDriId = new JLabel("ID :");
	JLabel JLDriName = new JLabel("Name :");
        JLabel JLDriTravAge=new JLabel("Travel Agency :");
	JLabel JLDriAddr = new JLabel("Address :");
	JLabel JLDriPhone = new JLabel("Phone :");
	JLabel JLDriVno = new JLabel("CAB No :");
	JLabel JLDriJoin = new JLabel("Date of join :");
	JLabel JLCname = new JLabel("CAB Name");
	JLabel JLCcap = new JLabel("CAB Capacity");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFTravAge = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFVno = new JTextField();
	JTextField JTFJoin = new JTextField();
	JTextField JTFCname = new JTextField();
	JTextField JTFCcap = new JTextField();

	public Entries_Driver()
    {
    	setTitle("Adding Driver to Database");

    	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		JLDriJoin.setBounds(5,220,105,20);
		JLDriJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFJoin.setBounds(110,220,200,20);
		JTFJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriJoin);
		JPContainer.add(JTFJoin);

		JLCname.setBounds(5,200,105,20);
		JLCname.setFont(new Font("Dialog",Font.PLAIN,12));
		JTFCname.setBounds(110,200,200,20);
		JTFJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCname);
		JPContainer.add(JTFCname);

		JLCcap.setBounds(5,180,105,20);
		JLCcap.setFont(new Font("Dialog",Font.PLAIN,12));
		JTFCcap.setBounds(110,180,200,20);
		JTFJoin.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCcap);
		JPContainer.add(JTFCcap);

		//-- Add the JBUpdate
		JBUpdt.setBounds(5,260,105,25);
		JBUpdt.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdt.addActionListener(JBActionListener);
		JBUpdt.setActionCommand("save");
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

		String date = String.format("%1$td %1$tm %1$ty",new Date());
    	JTFJoin.setText(date);

		getContentPane().add(JPContainer);
		setSize(325,353);
		setResizable(false);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);
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
			else if(srcObj=="reset")
			{
				JTFId.setText("");
				JTFName.setText("");
				JTFAddr.setText("");
				JTFPhone.setText("");
				JTFVno.setText("");
				JTFJoin.setText("");
				JTFTravAge.setText("");
                JTFCname.setText("");
                JTFCcap.setText("");
			}
		    else if(srcObj=="save")
			{
				if(	JTFId.getText().equals("") ||JTFName.getText().equals("") ||JTFAddr.getText().equals("")||JTFPhone.getText().equals("")||JTFVno.getText().equals("")||JTFJoin.getText().equals("")||JTFTravAge.getText().equals("")||JTFCcap.getText().equals("")||JTFCname.getText().equals(""))
		    	{
					JOptionPane.showMessageDialog(null,"Fill all the Fields of Form","Error in Adding",JOptionPane.ERROR_MESSAGE);
			    }
				else
				{
					try
				 	{
						Pattern pat=Pattern.compile("[a-z @ / * . A-Z]+");
						Pattern pat1=Pattern.compile("[0-9]+");
						Matcher mat1=pat1.matcher(JTFName.getText());

						Matcher mat=pat.matcher(JTFName.getText());
						flag6=mat.matches();
						if(flag6)
                        {}
						else
						{
							JOptionPane.showMessageDialog(null,"Check Name","Error in Adding",JOptionPane.ERROR_MESSAGE);
                            JTFName.setText("");flag7=false;
						}

						mat=pat.matcher(JTFId.getText());
						mat1=pat1.matcher(JTFId.getText());
						if(mat.find() && mat1.find())
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Check ID. It should be like : D100","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFId.setText("");flag7=false;
						}
						mat=pat.matcher(JTFVno.getText());
						mat1=pat1.matcher(JTFVno.getText());


            					if(mat.find() && mat1.find())
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Check Cab No. It should be like : MH 12 AS 1234","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFVno.setText("");flag7=false;
						}
						mat=pat.matcher(JTFAddr.getText());
						flag6=mat.matches();
						// mat=pat.matcher(JTFAddr.getText());
                                                mat1=pat1.matcher(JTFAddr.getText());


						if(flag6 || mat1.find())
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Check the Address.","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFAddr.setText("");flag7=false;
						}
						mat=pat1.matcher(JTFPhone.getText());
						flag6=mat.matches();

						if(flag6)
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Phone Number Should Be In Numbers","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFPhone.setText("");flag7=false;
						}
						mat=pat1.matcher(JTFCcap.getText());
						flag6=mat.matches();

						if(flag6)
						{
							int capa=Integer.parseInt(JTFCcap.getText());
							if(capa>7 || capa<4)
							{
								JOptionPane.showMessageDialog(null,"Capacity should be more than 3 & less than 8","Error in Adding",JOptionPane.ERROR_MESSAGE);
								JTFCcap.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Check CAB Capacity","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFCcap.setText("");flag7=false;
						}
						mat=pat.matcher(JTFTravAge.getText());
						flag6=mat.matches();

	        				if(flag6)
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Check Agency Name.","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFTravAge.setText("");flag7=false;
						}
						mat=pat.matcher(JTFCname.getText());
						flag6=mat.matches();
						if(flag6)
						{}
						else
						{
							JOptionPane.showMessageDialog(null,"Check CAB name","Error in Adding",JOptionPane.ERROR_MESSAGE);
							JTFCname.setText("");
							flag7=false;
						}
						if(flag7==true)
						{
							Class.forName("org.gjt.mm.mysql.Driver");
							Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
							Statement stmt = c.createStatement();
							ResultSet rs=stmt.executeQuery("select * from Driver");
							System.out.println("one");
							if(rs.next()==false)
							{
								flag=false;
								System.out.println("emptyone");
							}
							else
							{
								do
								{
									System.out.println("three");
									strDid=rs.getString(1);
									System.out.println("loop");
									if(strDid.equals(JTFId.getText()))
									{
										flag=true;
										System.out.println("true");
										break;
									}
									else
									{
										System.out.println("false");
										flag=false;
									}
								}
							while(rs.next());//while
							}//else
    						if(flag==false)
    						{
    							try
    							{
									rs=stmt.executeQuery("select * from Deleted_Driver");
									if(rs.next()==false)
									{
										flag1=false;
										System.out.println("emptytwo");
									}
									else
									{
										do
										{
											System.out.println("three");
											strDid=rs.getString(1);
											System.out.println("loop");
											if(strDid.equals(JTFId.getText()))
											{
												flag1=true;
												System.out.println("true");
												break;
											}
											else
											{
												System.out.println("flase");
												flag1=false;
											}
    									}
    									while(rs.next());
									}
    							}
    							catch(Exception e)
    							{
    							}
	    						if(flag1==false)
	    						{

	    							PreparedStatement stmt1 = c.prepareStatement("insert into Driver values(?,?,?,?,?,?,?)");
	    							stmt1.setString(1,JTFId.getText());
	 				   				stmt1.setString(2,JTFName.getText());
	 				   				stmt1.setString(3,JTFAddr.getText());
	 				   			stmt1.setString(4,JTFTravAge.getText());
	    							stmt1.setString(5,JTFPhone.getText());
	    							stmt1.setString(6,JTFVno.getText());
	    							stmt1.setString(7,JTFJoin.getText());
	    							stmt1.executeUpdate();
	    							System.out.println("two");
	    							PreparedStatement stmt2 = c.prepareStatement("insert into Cab values(?,?,?)");
	    							System.out.println("Program executed success fully");
	    							stmt2.setString(1,JTFVno.getText());
	    							stmt2.setString(2,JTFCname.getText());
	    							stmt2.setString(3,JTFCcap.getText());

	    							stmt2.executeUpdate();
JOptionPane.showMessageDialog(null,"Driver Record has been successfully inserted.","Driver Record insertion",JOptionPane.INFORMATION_MESSAGE);

	    						      	dispose();
	    							System.out.println("Program executed success fully");
	    						}
	    						else
	    						{
	    							JOptionPane.showMessageDialog(null,"Driver ID : "+JTFId.getText()+" is already used by another person","Error in Adding",JOptionPane.ERROR_MESSAGE);
    								JTFId.setText("");
	    						}
    						}
    						else
    						{
    							JOptionPane.showMessageDialog(null,"Driver : "+JTFId.getText()+" is already present","Error in Adding",JOptionPane.ERROR_MESSAGE);
    							JTFId.setText("");
    						}
						}
               		}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}
	};
    public void actionPerformed(ActionEvent ae)
    {
    	String srcObj = ae.getActionCommand();
    	JButton chkbtn = (JButton)ae.getSource();
    	if(srcObj == "cancel")
    	{
    		dispose();
    	}
    }
    public static void main(String s[])
    {
    	new Entries_Driver();
    }
}
