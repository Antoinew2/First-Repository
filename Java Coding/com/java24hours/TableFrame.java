package com.java24hours;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableFrame extends JFrame{
	public TableFrame()
	{
		super("Table Frame");
		String[] columnLabels ={"First Name","Last Name", "Job", "Age"};
		Object[][] tableData=
			{
					{//row1
						"Frankie","Heck","Dental Hygenist",50
					},
					{//row2
						"Mike","Heck","Quarry Manager",51
					},
					{//row3
						"Axl","Heck","Slacker",19
					},
					{//row4
						"Sue","Heck","Wrestlerette",16
					},
					{//row5
						"Brick","Heck","Reader",12
					}
			};
		JTable table=new JTable(tableData,columnLabels);
		JScrollPane ScrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(ScrollPane);
		setSize(450,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		public static void main(String[] argurments)
		{
			TableFrame frame= new TableFrame();
		}
		
	}


