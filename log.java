import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.*;


class Driver2 extends JFrame
{
	JButton JBUpdt = new JButton("Save",new ImageIcon("images/save.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	String str;
	PreparedStatement stmt; 
	Connection c ; 
	ResultSet rs;
	Statement s; 
	int meterin,meterout;
	JLabel JLPic1 = new JLabel(new ImageIcon("images/bmodify.png"));
	JLabel JLBanner = new JLabel("Please fill-up the required field.");

	JTextField passConfFail = new JTextField();

	JLabel JLDriverNo= new JLabel("Driver No.:");
	JLabel JLDriverName = new JLabel("Driver Name:");
	JLabel JLCabNo = new JLabel("Cab No:");
	JLabel JLMeterReading = new JLabel("Meter Reading:");
	JRadioButton work_in=new JRadioButton("Work In",false);
	JRadioButton work_out=new JRadioButton("Work Out",false);
	ButtonGroup group=new ButtonGroup();
	JLabel JLDate = new JLabel("Date:");
	JLabel JLTime = new JLabel("Time:");

	JTextField JTFDriverNo = new JTextField();
	JTextField JTFDriverName = new JTextField();
	JTextField JTFCabNo = new JTextField();
	JTextField JTFMeterReading = new JTextField();
	JTextField JTFDate = new JTextField();
	JTextField JTFTime = new JTextField();
	String min,mout;
	boolean flag5=false,flag6,flag9;
	public Driver2(String Did)
	{
		setTitle("Entry of Driver to Log Register.");
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent we)
				{
				dispose();
				}
				}
				);

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
		//-- Add Driver No In the Field
		JLDriverNo.setBounds(10,50,105,20);
		JLDriverNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFDriverNo.setBounds(115,50,200,20);
		JTFDriverNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriverNo);
		JPContainer.add(JTFDriverNo);

		//-- Add Driver Name In the Field
		JLDriverName.setBounds(10,75,105,20);
		JLDriverName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFDriverName.setBounds(115,75,200,20);
		JTFDriverName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDriverName);
		JPContainer.add(JTFDriverName);

		JTFDriverNo.addActionListener(JBActionListener);

		//-- Add Cab Number In the Field
		JLCabNo.setBounds(10,100,105,20);
		JLCabNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFCabNo.setBounds(115,100,200,20);
		JTFCabNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCabNo);
		JPContainer.add(JTFCabNo);


		JLMeterReading.setBounds(10,195,200,20);
		JLMeterReading.setFont(new Font("Dialog",Font.PLAIN,12));
		JPContainer.add(JLMeterReading);
		JTFMeterReading.setBounds(115,195,200,20);
		JTFMeterReading.setFont(new Font("Dialog",Font.PLAIN,12));
		group.add(work_in);
		group.add(work_out);
		work_in.setBounds(40,175,90,20);
		work_out.setBounds(145,175,90,20);

		JPContainer.add(JTFMeterReading);

		//-- Add Date in this Field
		JLDate.setBounds(10,125,105,20);
		JLDate.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFDate.setBounds(115,125,200,20);
		JTFDate.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLDate);
		JPContainer.add(JTFDate);

		//-- Add Time in this Field
		JLTime.setBounds(10,150,105,20);
		JLTime.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFTime.setBounds(115,150,200,20);
		JTFTime.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLTime);
		JPContainer.add(JTFTime);



		//-- Add the JBSave
		JBUpdt.setBounds(40,260,99,25);
		JBUpdt.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdt.addActionListener(JBActionListener);
		JBUpdt.setActionCommand("save");
		JPContainer.add(JBUpdt);

		//-- Add the JBCancel
		JBCancel.setBounds(180,260,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(332,353);
		setResizable(true);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);
		try
		{

			Class.forName("org.gjt.mm.mysql.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
			s = c.createStatement();
			str= "SELECT * FROM Driver WHERE D_No=\'"+Did+"\'";
			System.out.println(str);
			rs = s.executeQuery(str);
			rs.next();
			JTFDriverNo.setText("" + rs.getString(1));
			JTFDriverName.setText("" + rs.getString(2));
			JTFCabNo.setText("" + rs.getString(6));
			Calendar gc = Calendar.getInstance();
			String date = String.format("%1$td %1$tb %1$ty",new Date());
			JTFDate.setText(date);
			JTFTime.setText(gc.get(Calendar.HOUR) +":"	+gc.get(Calendar.MINUTE) +":" +gc.get(Calendar.SECOND) +" PM");

			JTFDriverNo.setEditable(false);
			JTFDriverName.setEditable(false);



			JTFDate.setEditable(false);
			JTFTime.setEditable(false);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	ActionListener JBActionListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{

			String srcObj = e.getActionCommand();

			if(srcObj=="cancel")
			{
				new tabbedpane();
				dispose();
			}

			else if(srcObj=="save")
			{       

				try
				{
					Pattern pat1=Pattern.compile("[0-9]+");
					Matcher mat;
					mat=pat1.matcher(JTFMeterReading.getText());
					flag9=mat.matches();

					if(!flag9)
					{
						JOptionPane.showMessageDialog(null,"Meter Reading Should Be In Numbers","Error in Adding",JOptionPane.ERROR_MESSAGE);
						JTFMeterReading.setText("");
					}


					if(JTFMeterReading.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please fill all the Fields","Error in Saving",JOptionPane.WARNING_MESSAGE);
					else
					{
						flag5=false;
						flag6=false;
						Class.forName("org.gjt.mm.mysql.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
						Statement stmt = c.createStatement();
						String string = "select * from Security_Log where D_No =\'"+JTFDriverNo.getText()+"\'";
						ResultSet rs = stmt.executeQuery(string);
						//System.out.println(rs.next());
						if(rs.next()==false)
						{  flag6=true;
							System.out.println(" loop");


						}  
						if(flag6==false)
						{System.out.println("flag6");
							string = "select * from Security_Log where D_No =\'"+JTFDriverNo.getText()+"\'";
							rs = stmt.executeQuery(string);
							while(rs.next())
							{
								System.out.println(rs.getString(7));
								min=rs.getString(7);
								mout=rs.getString(8);


								if(!min.equals("") && mout.equals(""))
									flag5=true;

							}


						}
					}		
					Class.forName("org.gjt.mm.mysql.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");

					if(flag5==false)
					{System.out.println("flag5");
						if(flag6==true)
							meterout=0;
						else      				    		                                meterout=Integer.parseInt(mout);		    		             	
						meterin=Integer.parseInt(JTFMeterReading.getText());
						System.out.println(meterout+" "+meterin);


						if(meterout>=meterin)
						{	JOptionPane.showMessageDialog(null,"Incorrect Meter Reading, It should greater than "+meterout,"Incorrect Meter reading",JOptionPane.ERROR_MESSAGE);
							JTFMeterReading.setText("");
						}
						else
						{

							stmt = c.prepareStatement("insert into Security_Log values(?,?,?,?,?,?,?,?)");
							stmt.setString(1,JTFDriverNo.getText());
							stmt.setString(2,JTFDriverName.getText());
							stmt.setString(3,JTFCabNo.getText());
							stmt.setString(4,JTFDate.getText());
								stmt.setString(7,JTFMeterReading.getText());
							stmt.setString(5,JTFTime.getText());
							stmt.setString(6,"");
							stmt.setString(8,"");

							stmt.executeUpdate();

							JOptionPane.showMessageDialog(null,"Saved Successfully","Entry of driver into Log Register",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
					else 
					{ 	

						str= "SELECT * FROM Security_Log WHERE D_No=\'"+JTFDriverNo.getText()+"\'";

						rs = s.executeQuery(str);
						while(rs.next())
						{

							meterin=Integer.parseInt(rs.getString(7));	
						}
						meterout=Integer.parseInt(JTFMeterReading.getText());
						System.out.println(meterout+" "+meterin);
						if(meterout<=meterin)
						{	JOptionPane.showMessageDialog(null,"Incorrect Meter Reading, It should greater than "+meterin,"Incorrect Meter reading",JOptionPane.ERROR_MESSAGE);
							JTFMeterReading.setText("");
						}
						else
						{

							str = "update Security_Log set Meter_Out = \'"+JTFMeterReading.getText()+"\',Time_Out=\'"+JTFTime.getText()+"\' where D_No= \'"+JTFDriverNo.getText()+"\' and Meter_Out='\'";
							s.executeUpdate(str);
							System.out.println(str);
							JOptionPane.showMessageDialog(null,"Saved Successfully","Entry of driver into Log Register",JOptionPane.INFORMATION_MESSAGE);

							dispose();
						}

					}

				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}



			}

		}
	};

}

public class log extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag;

	String strEid;	 
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Please select the required Driver ID carefully");

	JLabel JLId = new JLabel("Driver ID");
	JTextField JTFId = new JTextField();

	int entry=0,i=1;
	JComboBox jcb;
	String did;
	public log()
	{
		setTitle("Driver entry in to LOG");
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

		//-- Add the JBDelete
		JBEnter.setBounds(40,100,99,25);
		JBEnter.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBEnter.addActionListener(this);
		JBEnter.setActionCommand("update");
		JPContainer.add(JBEnter);

		//-- Add the JBCancel
		JBCancel.setBounds(180,100,99,25);
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
			System.out.println("delete");
			did=(String)jcb.getSelectedItem();
			if(did.equals("-- Select 0ne --"))
				JOptionPane.showMessageDialog(null,"Select one OPTION from the Combo Box","Incorrect Selection",JOptionPane.ERROR_MESSAGE);

			else
			{			   new Driver2(did);
				dispose();

			}	

		}
		else if(sourceBtn == JBCancel)
		{
			new tabbedpane();
			dispose();
		}

	}
	public static void main(String s[])
	{
		new log();
	}
}
