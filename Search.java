import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.print.*;


class srchTable extends JFrame implements ActionListener
{
    Connection c;
	Statement s;
    ResultSet rs;
	String str;
	JTable Jtable;
	boolean flag;
	int n;
	JPanel JPContainer = new JPanel();
    JScrollPane jsp=new JScrollPane();

    JLabel JLBanner = new JLabel("Search Results");
    JLabel JLPic = new JLabel(new ImageIcon("images/bSearch.png"));
	JLabel StatusLabel = new JLabel("CREATED BY Rohan AND Gokul",JLabel.CENTER);
    JButton JBSearch = new JButton("Search More",new ImageIcon("images/search.png"));
    JButton JBPrint = new JButton("Print",new ImageIcon("images/PRINT.png"));
    JButton JBExit = new JButton("Exit Search",new ImageIcon("images/exit.png"));

	JMenuBar MMenubar = new JMenuBar();

	public srchTable(String Did,String Dtype)
    {
		setTitle("Search Result");

		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPContainer.setLayout(null);
        System.out.println(Dtype);

		try
		{

			if(Dtype=="Driver ID")
			{	str= "SELECT * FROM Security_Log WHERE D_No=\'"+Did+"\'";
			    n=1;
			}
			else if(Dtype == "Date")
			{	str= "SELECT * FROM Security_Log WHERE Date=\'"+Did+"\'";
			    n=4;
			}
			else if(Dtype == "Driver Name")
			{
					str= "SELECT * FROM Security_Log WHERE D_Name=\'"+Did+"\'";
					n=2;
			}
			else if(Dtype == "Cab No")
			{
				str= "SELECT * FROM Security_Log WHERE C_No=\'"+Did+"\'";
				n=3;
			}
			System.out.println(str);
        	Class.forName("org.gjt.mm.mysql.Driver");
		    System.out.println("DRIVER FOUND");
		    c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
	      	System.out.println("CONNECTION FOUND");
    	    s = c.createStatement();
	       	System.out.println("str");
    		rs = s.executeQuery(str);
    		while(rs.next())
    		{
		System.out.println("while");
	    		String strlog=rs.getString(n);
			System.out.println(strlog);
    			if(strlog.equals(Did))
    			{
	    		   flag=true;
				   System.out.println("b "+flag);
    				break;
	    		}

			else
			{
			 	flag=false;

				System.out.println("b "+flag);
    			}
    		}//while
			if(flag==true)
			{
				Class.forName("org.gjt.mm.mysql.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
				s = c.createStatement();
				rs = s.executeQuery(str);

				String[] colHeads={"Driver No","Driver Name","Cab Number","Date","Time In","Time Out","Meter In","Meter Out"};
				int i=0,j=0;
				int count =0;
				while(rs.next())
				{
					count++;
				}
				rs = null;
				rs = s.executeQuery(str);
				Object data[][]=new  Object[count][8];
				while(rs.next())
				{
					for(j=1;j<=8;j++)
					{
						data[i][j-1]=rs.getString(j);
					}
					i++;
				}
				JTable Jtable=new JTable(data,colHeads);

				jsp.setViewportView(Jtable);

				JPContainer.add(jsp);
			}
			else
			{		JOptionPane.showMessageDialog(null,"No record present in log Register for  "+Did,"Error in Searching",JOptionPane.WARNING_MESSAGE);
			        new Search();
			}
		}
	    catch(Exception e)
		{}

		MMenubar.add(JBSearch);
		JBSearch.addActionListener(this);
		JBPrint.addActionListener(this);
		MMenubar.add(JBExit);
		JBExit.addActionListener(this);
		setJMenuBar(MMenubar);

		jsp.setBounds(10,100,800,320);
		JPContainer.add(jsp);

		JLPic.setBounds(200,25,32,32);
		JPContainer.add(JLPic);

		JLBanner.setBounds(270,10,350,55);
		JLBanner.setFont(new Font("Old English text MT",Font.BOLD,40));
		JPContainer.add(JLBanner);

		StatusLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		getContentPane().add(StatusLabel,BorderLayout.PAGE_END);
		getContentPane().add(JPContainer);

		setSize(820,500);
		setResizable(false);
		setLocation(100,100);
		setVisible(flag);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == JBSearch)
		{
			new Search();
			dispose();
		}

		if(ae.getSource()== JBExit)
		{
            dispose();
		}
	}

}

public class Search extends JDialog
{
	//Start create variables
	JButton JBSearch = new JButton("Search",new ImageIcon("images/Search.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/Cancel.png"));

	JLabel JLPic1 = new JLabel(new ImageIcon("images/bSearch.png"));
	JLabel JLBanner = new JLabel("Select what to locate and select where to locate.");
	JLabel JLSearchFor = new JLabel("Search For:");
	JLabel JLSearchIn = new JLabel("Look By:");

	JPanel JPDialogContainer = new JPanel();

	JTextField JTFSearchFor = new JTextField();

	JComboBox JCSearchIn;
		int entry=0,i=1;
    JComboBox jcb,jcb1;
    String did,driv[],driv1[];
    boolean flag4=false,flag5=true,flag6=false;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	//End create variables

	public Search()
	{
		setTitle("Search Driver");
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
         	String driv1[]=new String[entry+1];
    		driv[0]="-- Select 0ne --";
    		driv1[0]="-- Select 0ne --";
    	try
    	{

    	Class.forName("org.gjt.mm.mysql.Driver");
    				Connection	c = DriverManager.getConnection("jdbc:mysql://localhost/project","root","vignet");
    				   Statement stmt = c.createStatement();
                                   ResultSet rs=stmt.executeQuery("select * from Driver");
    					while(rs.next())
    					{
    					    driv[i]=rs.getString(1);
    					    driv1[i]=rs.getString(2);
    					    System.out.println(driv[i]+ " "+driv1[i]);
    					    i++;
    					}
    	}
    	catch(Exception e)
    	{
    	}
    		jcb=new JComboBox(driv);
    		jcb1=new JComboBox(driv1);
		//Start Initalize variables
		String StrListItem[]={"Driver ID","Driver Name","Date","Cab No"};
		JCSearchIn = new JComboBox(StrListItem);
		StrListItem = null;

		JPDialogContainer.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPDialogContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner.setBounds(55,5,280,48);
		JLBanner.setFont(new Font("Dialog",Font.PLAIN,12));
		JPDialogContainer.add(JLBanner);
		//End initialize variables

		//******************** Start adding of input field
		//-- Add Id Input Field
		JLSearchFor.setBounds(5,72,105,20);
		JLSearchFor.setFont(new Font("Dialog",Font.PLAIN,12));

		jcb.setBounds(110,72,225,20);
		jcb.setFont(new Font("Dialog",Font.PLAIN,12));

	    jcb1.setBounds(110,72,225,20);
		jcb1.setFont(new Font("Dialog",Font.PLAIN,12));
		jcb1.setVisible(false);
		JTFSearchFor.setBounds(110,72,225,20);
        JTFSearchFor.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFSearchFor.setVisible(false);
		JPDialogContainer.add(JTFSearchFor);

		JPDialogContainer.add(JLSearchFor);

		JPDialogContainer.add(jcb);
			JPDialogContainer.add(jcb1);

		//-- Add Name Input Field
		JLSearchIn.setBounds(5,50,105,20);
		JLSearchIn.setFont(new Font("Dialog",Font.PLAIN,12));

		JCSearchIn.setBounds(110,50,225,20);
		JCSearchIn.setFont(new Font("Dialog",Font.PLAIN,12));

		//******************** End adding of input field

		//-- Add the JBSearch
		JBSearch.setBounds(50,100,99,25);
		JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBSearch.addActionListener(JBActionListener);
		JBSearch.setActionCommand("search");
		JPDialogContainer.add(JBSearch);
		JCSearchIn.addActionListener(JBActionListener1);
		JPDialogContainer.add(JLSearchIn);
		JPDialogContainer.add(JCSearchIn);

		//-- Add the JBCancel
		JBCancel.setBounds(180,100,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPDialogContainer.add(JBCancel);

		getContentPane().add(JPDialogContainer);
		setSize(350,165);
		setResizable(false);
		setLocation((screen.width - 350)/2,((screen.height-165)/2));
		setVisible(true);
	}
	ActionListener JBActionListener1 = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
		   	String Sin=(String)JCSearchIn.getSelectedItem();
		    if(Sin.equals("Driver ID"))
		    {
		       jcb1.setVisible(false);
		    	JTFSearchFor.setVisible(false);

		        jcb.setVisible(true);
		        flag4=false;
		        flag5=true;
		    }
		    if(Sin.equals("Driver Name"))
		    {
		    	jcb.setVisible(false);
		    	JTFSearchFor.setVisible(false);
		    	jcb1.setVisible(true);
		    	flag4=false;
		    	flag5=false;
		    }
		    if(Sin.equals("Date"))
		    {

		            jcb.setVisible(false);
		             jcb1.setVisible(false);
		            JTFSearchFor.setVisible(true);

		            flag4=true;

		    }
		    if(Sin.equals("Cab No"))
		    {
		    		 jcb.setVisible(false);
		             jcb1.setVisible(false);
		            JTFSearchFor.setVisible(true);

		            flag4=true;


		    }
		}
	};

	ActionListener JBActionListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{

		   	String srcObj = e.getActionCommand();
			if(srcObj=="search")
			{
				if(flag4==false)
				{
				   if(flag5==true)
				   {

				      did=(String)jcb.getSelectedItem();
    	              if(did.equals("-- Select 0ne --"))
    	     	      JOptionPane.showMessageDialog(null,"Select one OPTION from the Combo Box","Incorrect Selection",JOptionPane.ERROR_MESSAGE);

    		         else
    		         {	//	   dispose();

    					new srchTable(did,JCSearchIn.getSelectedItem().toString());
					  dispose();
			 	     }
				   }
				   else
				   {
				   	did=(String)jcb1.getSelectedItem();
    	              if(did.equals("-- Select 0ne --"))
    	     	      JOptionPane.showMessageDialog(null,"Select one OPTION from the Combo Box","Incorrect Selection",JOptionPane.ERROR_MESSAGE);

    		         else
    		         {
    			  	//	   dispose();

    					new srchTable(did,JCSearchIn.getSelectedItem().toString());
					  dispose();
			 	     }
				   }
				}
				else
				{
					if(JTFSearchFor.getText().equals(""))
				   {
				  	 JOptionPane.showMessageDialog(null,"Please fill the Field","Error in Searching",JOptionPane.WARNING_MESSAGE);
					 JTFSearchFor.requestFocus();
				     }
				   else
				   {

					 new srchTable(JTFSearchFor.getText(),JCSearchIn.getSelectedItem().toString());
					 dispose();
				   }
				}
			}
			else
			{
				dispose();
			}
		}
};
public static void main(String args[])
{
new Search();
}

}
