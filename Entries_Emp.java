import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.*;

public class Entries_Emp extends JFrame //implements ActionListener
{
	Boolean flag,flag6,flag7=true;
	String strEid;
	JButton JBUpdt = new JButton("Save",new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

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

	public Entries_Emp()
    {
    	setTitle("Adding Employee to Database");
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

		//************ Start adding of input field***********//
		//-- Add Id Input Field
		JLempId.setBounds(5,50,105,20);
		JLempId.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFId.setBounds(110,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLempId);
		JPContainer.add(JTFId);

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
		JBUpdt.setActionCommand("Save");
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

		//JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(325,253);
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
			else if(srcObj=="Save")
			{
	       	 	if(JTFId.getText().equals("")|| JTFName.getText().equals("")||JTFAddr.getText().equals("")||JTFLocat.getText().equals("")||JTFPhone.getText().equals("")||JTFProcess.getText().equals(""))
			  		JOptionPane.showMessageDialog(null,"Fill all the Fields of Form","Error in insertion",JOptionPane.ERROR_MESSAGE);
			 	else
			 	{
				try
				{
					Pattern pat=Pattern.compile("[a-z . A-Z]+"); 
					Pattern pat1=Pattern.compile("[0-9]+"); 
					Matcher mat1;
					Matcher mat=pat.matcher(JTFName.getText());
					flag6=mat.matches();

					if(flag6)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check Name","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFName.setText("");flag7=false;
					}

					mat=pat.matcher(JTFId.getText());
					mat1=pat1.matcher(JTFId.getText());
					if(mat.find() && mat1.find())
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check ID. It should be like : E100","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFId.setText("");flag7=false;
					}
					mat=pat.matcher(JTFAddr.getText());
					flag6=mat.matches();
	                                                            									if(flag6)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check the Address.","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFAddr.setText("");flag7=false;
					}
					
					mat=pat1.matcher(JTFPhone.getText());
					flag6=mat.matches();
					
					if(flag6)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check Phone Number","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFPhone.setText("");
						flag7=false;
					}

					mat=pat.matcher(JTFProcess.getText());
					flag6=mat.matches();
					
					if(flag6)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check Process Name.","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFProcess.setText("");flag7=false;
					}
					mat=pat.matcher(JTFLocat.getText());
					flag6=mat.matches();

					if(flag6)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Check Location","Error in insertion",JOptionPane.ERROR_MESSAGE);
						JTFLocat.setText("");
						flag7=false;
					}     
					if(flag7==true)
					{
						Class.forName("org.gjt.mm.mysql.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
						Statement stmt = c.createStatement();
						ResultSet rs=stmt.executeQuery("select * from Employees");
						if(rs.next()==false)
						{
							flag=false; 
							System.out.println("empty");
						}
						else
						{
							do
							{
								strEid=rs.getString(1);
								System.out.println("loop");
								if(strEid.equals(JTFId.getText()))
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
							}while(rs.next());//while
						}//else
						if(flag==false)
						{
							PreparedStatement stmt1 = c.prepareStatement("insert into Employees values(?,?,?,?,?,?)");
							stmt1.setString(1,JTFId.getText());
							stmt1.setString(2,JTFName.getText());
							stmt1.setString(3,JTFAddr.getText());
							stmt1.setString(4,JTFLocat.getText());
							stmt1.setString(5,JTFPhone.getText());
							stmt1.setString(6,JTFProcess.getText());
							stmt1.executeUpdate();
							System.out.println("Program executed success fully");
							                                                                                                 JOptionPane.showMessageDialog(null,"Employee Record has been successfully updated.","Employee Record Updation",JOptionPane.INFORMATION_MESSAGE);
 
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Employee : "+JTFId.getText()+" is already present","Error in insertion",JOptionPane.ERROR_MESSAGE);
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
		else if(srcObj=="reset")
		{
			JTFId.setText("");
			JTFName.setText("");
			JTFAddr.setText("");
			JTFPhone.setText("");
			JTFLocat.setText("");
			JTFProcess.setText("");
		}
	}
	};	  
    public static void main(String s[])
    {
    	new Entries_Emp();
    }
}
