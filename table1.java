import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.awt.print.*;


 class table extends JFrame
{
	JScrollPane jsp = new JScrollPane();
	JTable table = new JTable();
	JPanel panel = new JPanel();
        JButton JBPrint = new JButton("Print",new ImageIcon("images/print.png"));
	JButton JBBack = new JButton("back",new ImageIcon("images/reload.png"));

	Connection c;
	Statement s;
    ResultSet rs;
    String str,empl,drvid;
    String time[]={"AM","PM"};
	JLabel JLDriverNo = new JLabel("Driver No");
	JLabel JLDriverName = new JLabel("Driver Name");
	JLabel JLCompName = new JLabel("Wipro Pvt. Ltd.");
	JLabel JLProcess = new JLabel("Travel Agency");
	JLabel JLCabNo = new JLabel("Cab No");
	JLabel JLCap = new JLabel("Cab Capacity");
	JLabel JLDate = new JLabel("Date & Time");
	JLabel JLSign  = new JLabel("");
	JLabel JLAdmins = new JLabel("Admin Signature");
	JLabel JLDrivers = new JLabel("Driver Signature");
	JLabel JLComsign = new JLabel("Company Seal");

	JTextField JTFCompName = new JTextField();
	JTextField JTFProcess = new JTextField();
	JTextField JTFDriverName = new JTextField();
	JTextField JTFCabNo = new JTextField();
	JTextField JTFDriverNo = new JTextField();
	JTextField JTFCap = new JTextField();
	JTextField JTFDate = new JTextField();
	JTextField JTFSign = new JTextField();

	JMenuBar MMenubar = new JMenuBar();
	JMenu MOption = new JMenu("Options");
	JMenuItem MIAdd = new JMenuItem("Add");
	JMenuItem MIBack = new JMenuItem("Back");
	JMenuItem MIPrint = new JMenuItem("Print");

	JLabel StatusLabel = new JLabel("CREATED BY ROHAN AND GOKUL",JLabel.CENTER);

	public table(String Did,String Driverarray[],int i)
	{
		super("ROSTER FOR DRIVER");
		System.out.println(Driverarray.length);
		drvid=Did;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int j;
		Object data[][]=new  Object[i][7];
		String[] colHeads={"Sr.No.","Employee ID","Employee Name","Employee Location","Employee Process","Employee Phone","Signature"};
		for(j=0;j<i;j++)
		{
			empl=Driverarray[j];
		    str= "SELECT * FROM Employees WHERE E_ID=\'"+empl+"\'";
			System.out.println(str);
            try
            {

 				Class.forName("org.gjt.mm.mysql.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
				s = c.createStatement();
				rs = s.executeQuery(str);
				System.out.println("Executed");
				rs.next();

            	data[j][0]=j+1;
            	data[j][1]=rs.getString(1);
            	data[j][2]=rs.getString(2);
            	data[j][3]=rs.getString(4);
            	data[j][4]=rs.getString(6);
            	data[j][5]=rs.getString(5);
            	data[j][6]="";
            }
            catch(Exception e)
            {
            	System.out.println(e);
            }


		}


		jsp.setViewportView(table);
        JTable Jtable=new JTable(data,colHeads);

		jsp.setViewportView(Jtable);

		panel.add(jsp);
        try
		{

			s = c.createStatement();
			str= "select * from Driver where D_No =\'"+drvid+"\'";
			rs = s.executeQuery(str);
			rs.next();
			JTFDriverNo.setText("" + rs.getString(1));
			JTFDriverName.setText("" + rs.getString(2));
			JTFProcess.setText("" + rs.getString(4));
			JTFCabNo.setText("" + rs.getString(6));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		try
		{
			s = c.createStatement();
			str = "select * from Cab where C_No =\'"+JTFCabNo.getText()+"\'";
			rs = s.executeQuery(str);
			rs.next();
			JTFCap.setText("" + rs.getString(3));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		Calendar gc = Calendar.getInstance();
		String date = String.format("%1$td %1$tb %1$ty",new Date());
		JTFDate.setText(date+"  "+gc.get(Calendar.HOUR) +":"	+gc.get(Calendar.MINUTE) +":" +gc.get(Calendar.SECOND) +" "+time[+gc.get(Calendar.AM_PM)]);


		//Menu Bar

		MMenubar.add(JBBack);
		JBBack.addActionListener(JBActionListener);
		MMenubar.add(JBPrint);
		JBPrint.addActionListener(JBActionListener);
		setJMenuBar(MMenubar);

		panel.setLayout(null);

	        JLCompName.setBounds(270,10,350,55);
		JLCompName.setFont(new Font("Old English text MT",Font.BOLD,40));

		JLDriverNo.setBounds(50,90,100,20);
		JTFDriverNo.setBounds(150,90,160,20);
		JLDriverNo.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFDriverNo.setFont(new Font("Dialog",Font.BOLD,12));
		JTFDriverNo.addActionListener(JBActionListener);

		JLProcess.setBounds(440,90,100,20);
		JTFProcess.setBounds(560,90,160,20);
		JLProcess.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFProcess.setFont(new Font("Dialog",Font.BOLD,12));

		JLCabNo.setBounds(440,115,100,20);
		JTFCabNo.setBounds(560,115,160,20);
		JLCabNo.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFCabNo.setFont(new Font("Dialog",Font.BOLD,12));

		JLDriverName.setBounds(50,115,100,20);
		JTFDriverName.setBounds(150,115,160,20);
		JLDriverName.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFDriverName.setFont(new Font("Dialog",Font.BOLD,12));


		JLDate.setBounds(50,140,100,20);
		JTFDate.setBounds(150,140,160,20);
		JLDate.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFDate.setFont(new Font("Dialog",Font.BOLD,12));


		JLCap.setBounds(440,140,100,20);
		JTFCap.setBounds(560,140,160,20);
		JLCap.setFont(new Font("Palatino Linotype",Font.BOLD,14));
		JTFCap.setFont(new Font("Dialog",Font.BOLD,12));


		//		Adding To The Panel
		panel.add(JLCompName);
		panel.add(JLDriverNo);
		panel.add(JTFDriverNo);
		panel.add(JLProcess);
		panel.add(JTFProcess);
		panel.add(JLCabNo);
		panel.add(JTFCabNo);
		panel.add(JLDriverName);
		panel.add(JTFDriverName);
		panel.add(JLDate);
		panel.add(JTFDate);
		panel.add(JLCap);
		panel.add(JTFCap);


		StatusLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		getContentPane().add(StatusLabel,BorderLayout.PAGE_END);
		getContentPane().add(panel,BorderLayout.CENTER);

		JLComsign.setBounds(75,375,150,20);
		JLComsign.setFont(new Font("Palatino Linotype",Font.BOLD,14));
        panel.add(JLComsign);
        JLAdmins.setBounds(350,375,160,20);
		JLAdmins.setFont(new Font("Palatino Linotype",Font.BOLD,14));
	    panel.add(JLAdmins);
	    JLDrivers.setBounds(625,375,160,20);
		JLDrivers.setFont(new Font("Palatino Linotype",Font.BOLD,14));
	    panel.add(JLDrivers);
	    jsp.setBounds(10,170,800,130);
		panel.add(jsp);
		setLocation(100,100);
		setSize(830,500);
		setResizable(true);
		setVisible(true);
	}
/*      public void actionPerformed(ActionEvent event)
        {
                PrintUtilities.printComponent(this);

        }*/


	ActionListener JBActionListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			String str;
			if(ae.getSource() == JTFDriverNo)
			{
				str = JTFDriverNo.getText();
				try
				{
					Class.forName("org.gjt.mm.mysql.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
					Statement stmt = c.createStatement();
					String string = "select * from Driver where D_No =\'"+drvid+"\'";
					ResultSet rs = stmt.executeQuery(string);
					rs.next();
					JTFDriverName.setText("" + rs.getString(2));
					JTFProcess.setText("" + rs.getString(4));
					JTFCabNo.setText("" + rs.getString(6));
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			if(ae.getSource() == JBBack)
			{
				dispose();
			}
			if(ae.getSource() == JBPrint)
			{
				PrintUtilities.printComponent(panel);
				//new usePrinter();

			}


		}

};

}

class emp extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag,flag1,flag3=true;
	String Driverarray[]= new String[10];
	int i=0,j,k,capacity;
	String strEid,Drid;
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Please select the required Employee ID carefully");

	JLabel JLId = new JLabel("Employee ID");

	JTextField JTFId = new JTextField();

	int entry=0,l=1;
    JComboBox jcb;
    String did;

    public emp(String Did,int cap)
    {
    	Drid=Did;
    	capacity=cap;
    	setTitle("Addition of Employee into Roster");

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
    					    driv[l]=rs.getString(1);
    					    System.out.println(driv[l]+ " "+rs.getString(2));
    					    l++;
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


		jcb.setBounds(150,50,150,20);
		jcb.setFont(new Font("Dialog",Font.PLAIN,12));

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
		JBCancel.setBounds(180,100,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));

		JBCancel.addActionListener(this);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setLocation((screen.width-350)/2,((screen.height-165)/2));
		setSize(320,200);
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

       					   flag1=false;
    					   for(j=0;j<Driverarray.length;j++)
    					   {  if(Driverarray[j]==null)
    					     	break;
    					      else if(Driverarray[j].equals((String)jcb.getSelectedItem()))
    					             flag1=true;
    					   }
    					     if(flag1==true)
    					     {
    					       JOptionPane.showMessageDialog(null,"Employee : "+(String)jcb.getSelectedItem()+" is already added to Roster","Error in adding",JOptionPane.ERROR_MESSAGE);
    						   JTFId.setText("");
    					     }
    					     else
    					     {

    					       if(i==capacity-1)
    					       {
    					       	 Driverarray[i]=(String)jcb.getSelectedItem();
    					       	 JOptionPane.showMessageDialog(null,"Cab Capacity is Over","Cab Capacity ",JOptionPane.INFORMATION_MESSAGE);
    						       for(k=0;k<Driverarray.length;k++)
    					        	   if(Driverarray[k]==null)
    					        	   	break;
    						      new table(Drid,Driverarray,k);

    						      dispose();
    						      flag3=false;
    					       }
    					       Driverarray[i]=(String)jcb.getSelectedItem();
    					       i++;
    					     }
    					  if(flag3==true)
    					  {

    					    int res=JOptionPane.showConfirmDialog((Component)null,"Do You Want to Add Employee to Roster ?","Choose yes or no",JOptionPane.YES_NO_OPTION);
    					    String ObjButtons[] = {"Yes","No"};
		   				    if(res ==JOptionPane.YES_OPTION)
		   				    {  JTFId.setText("");

		   				    }
    					    else
    					    {                                                    					        System.out.println("no"+Driverarray.length+""+Drid);

    					        for(i=0;i<Driverarray.length;i++)
    					        	   if(Driverarray[i]==null)
    					        	   	break;
    					        	System.out.println(i);
    					        new table(Drid,Driverarray,i);
    					        dispose();
    					    }
    					  }
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

}
public class table1 extends JFrame implements ActionListener
{
	JButton JBEnter = new JButton("Enter",new ImageIcon("images/delete.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	boolean flag;
	Connection c;
    Statement stmt;
    ResultSet rs;

	String strEid,cabno;
	int cap;
	JLabel JLPic = new JLabel(new ImageIcon("images/delete.png"));
	JLabel JLBanner = new JLabel("Please select the required Driver ID carefully");

	JLabel JLId = new JLabel("Driver ID");
	JTextField JTFId = new JTextField();

    int entry=0,i=1;
    JComboBox jcb;
    String did;
    public table1()
    {
    	setTitle("Validation of Driver");
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
		jcb.setFont(new Font("Dialog",Font.PLAIN,12));

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
    		System.out.println("delete");
    		did=(String)jcb.getSelectedItem();
    	     if(did.equals("-- Select 0ne --"))
    	     	JOptionPane.showMessageDialog(null,"Select one OPTION from the Combo Box","Incorrect Selection",JOptionPane.ERROR_MESSAGE);

    		else
    		{
    			  try
    			  {

    			              Class.forName("org.gjt.mm.mysql.Driver");
    				          Connection c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				          Statement stmt = c.createStatement();
    				          ResultSet rs=stmt.executeQuery("select * from Driver where D_No=\'"+did+"\'");
    				    	   rs.next();

    							cabno=rs.getString(6);

								stmt = c.createStatement();
						        String		str = "select * from Cab where C_No =\'"+cabno+"\'";
						 		rs = stmt.executeQuery(str);
								rs.next();
							    cap=Integer.parseInt(rs.getString(3));
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
		                    JOptionPane.showMessageDialog(null,"Cab capacity is "+cap+" ","CAB CAPACITY",JOptionPane.INFORMATION_MESSAGE);
    				        new emp((String)jcb.getSelectedItem(),cap);
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
new table1();
}
}
