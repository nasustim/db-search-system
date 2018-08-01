import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.datatransfer.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class CreateWindow implements ActionListener {
	
	static JFrame jf;
	static Container gcp;
	static JLabel l;
	static JTextField tfA;
	static JTextField tfB;
	static JTextField tfC;
	static JTextField tfD;
	static JTextField tfE;
	static DbConnect dbc;
	static JTable jt;
	static JCheckBox[] Dckbox;
	static JCheckBox[] Sckbox;
	static JRadioButton[] SMrb;
	static JRadioButton[] PMrb;
	static JRadioButton[] XSrb;
	static JLabel lbs;
	static JLabel lbd;
	static JLabel lbsm;
	static JLabel lbpm;
	static JLabel lbxs;
	static int cot = 0;
	static String[] temp = new String[6];
	static ButtonGroup smg;
	static ButtonGroup pmg;
	static ButtonGroup xsmg;
	static JPanel pr;
	
	static JButton b;
	static JButton cb;
	
	String[] text = new String[5];
	
	ArrayList<String> nmList = new ArrayList<String>();
	
	static boolean[] kindOfDisplayTable = new boolean[6];
	
	static String[] columnNames = {"name","step","condition","before_apply","apply","after_apply"};
	static String[] logicNames = {"and","or"};
	
	void createWindow(String title,int n){
		jf = new JFrame(title);
		gcp = jf.getContentPane();
		switch(n){
			case 1:
				createFirstFrame();
				break;
		}
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	private void createFirstFrame(){
		jf.setSize(700,600);
		
		tfA = new JTextField("",20);
		tfB = new JTextField("",20);
		tfC = new JTextField("",20);
		tfD = new JTextField("",20);
		tfE = new JTextField("",20);
		
		lbd = new JLabel("表示する項目");
		
		JPanel djp = new JPanel();
		Dckbox = new JCheckBox[6];
		for(int i = 0;i < 6;i++){
			Dckbox[i] = new JCheckBox(columnNames[i]);
			djp.add(Dckbox[i]);
		}
		
		lbs = new JLabel("検索元の項目");
		
		JPanel sjp = new JPanel();
		Sckbox = new JCheckBox[6];
		for(int i = 0;i < 6;i++){
			Sckbox[i] = new JCheckBox(columnNames[i]);
			sjp.add(Sckbox[i]);
		}
		
		lbsm = new JLabel("検索の論理判定");
		smg = new ButtonGroup();
		
		JPanel smjp = new JPanel();
		SMrb = new JRadioButton[3];
		SMrb[0] = new JRadioButton("and");
		SMrb[1] = new JRadioButton("or");
		SMrb[2] = new JRadioButton("完全一致",true);
		smg.add(SMrb[0]);
		smg.add(SMrb[1]);
		smg.add(SMrb[2]);
		smjp.add(SMrb[0]);
		smjp.add(SMrb[1]);
		smjp.add(SMrb[2]);
		
		lbpm = new JLabel("上からの順番を検索結果に考慮する");
		pmg = new ButtonGroup();
		
		JPanel pmjp = new JPanel();
		PMrb = new JRadioButton[2];
		PMrb[0] = new JRadioButton("する");
		PMrb[1] = new JRadioButton("しない",true);
		pmg.add(PMrb[0]);
		pmg.add(PMrb[1]);
		pmjp.add(PMrb[0]);
		pmjp.add(PMrb[1]);
		
		lbxs = new JLabel("検索結果に含まれる記号の表示");
		xsmg = new ButtonGroup();
		
		JPanel pxs = new JPanel();
		XSrb = new JRadioButton[2];
		XSrb[0] = new JRadioButton("数学記号");
		XSrb[1] = new JRadioButton("X-Symbol",true);
		xsmg.add(XSrb[0]);
		xsmg.add(XSrb[1]);
		pxs.add(XSrb[0]);
		pxs.add(XSrb[1]);
		
		b = new JButton("検索");
		b.addActionListener(this);/*
		gcp.add(tf,BorderLayout.NORTH);
		gcp.add(b,BorderLayout.SOUTH);
		gcp.add(lbd,BorderLayout.WEST);
		gcp.add(djp,BorderLayout.WEST);
		gcp.add(lbs,BorderLayout.WEST);
		gcp.add(sjp,BorderLayout.WEST);*/
		
		JPanel cp = new JPanel();
		cp.setLayout(new GridLayout(16,0));
		
		cp.add(tfA);
		cp.add(tfB);
		cp.add(tfC);
		cp.add(tfD);
		cp.add(tfE);
		cp.add(lbd);
		cp.add(djp);
		cp.add(lbs);
		cp.add(sjp);
		cp.add(lbsm);
		cp.add(smjp);
		cp.add(lbpm);
		cp.add(pmjp);
		cp.add(lbxs);
		cp.add(pxs);
		cp.add(b);
		
		gcp.add(cp);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			//add
			ConvertString cs = new ConvertString();
			//dda
			text[0] = tfA.getText();
			//add
			text[0] = cs.ConvertInString(text[0]);
			//dda
			//dda
			text[1] = tfB.getText();
			//add
			text[1] = cs.ConvertInString(text[1]);
			//dda
			//dda
			text[2] = tfC.getText();
			//add
			text[2] = cs.ConvertInString(text[2]);
			//dda
			//dda
			text[3] = tfD.getText();
			//add
			text[3] = cs.ConvertInString(text[3]);
			//dda
			//dda
			text[4] = tfE.getText();
			//add
			text[4] = cs.ConvertInString(text[4]);
			//dda
		
			for(int i = 0;i < 6;i++){
				if(Dckbox[i].isSelected()){
					kindOfDisplayTable[i] = true;
					System.out.println(columnNames[i]);
					temp[cot] = columnNames[i];
					cot++;
					System.out.println(cot);
				}else{
					kindOfDisplayTable[i] = false;
				}
			}
		
			dbc = new DbConnect();
			dbc.dbConnect(text);
		}
		if(e.getSource() == cb){
			getDataFromSelectedCell();
		}
	}
	public String createInTable(String[] text){
		String inTable = " ";
		
		if(SMrb[2].isSelected()==true){
			for(int i=0;i<6;i++){
				if(Sckbox[i].isSelected()==true){
					inTable = inTable + columnNames[i];
					inTable = inTable + " LIKE '"+text[0]+"' OR ";
				}
			}
			inTable = inTable.substring(0,inTable.length()-3);
			return inTable;
		}
		
		if(PMrb[1].isSelected()){
			for(int j = 0;j < 5;j++){
				if(text[j].length()==0){ continue; }	//""
				inTable = inTable + "(";
				for(int i = 0;i < 6;i++){
					if(Sckbox[i].isSelected() == true){
						inTable = inTable + columnNames[i];
						inTable = inTable + " LIKE '%"+text[j]+"%' OR ";
					}
				}
				inTable = inTable.substring(0,inTable.length()-3);
				inTable = inTable + ")";
				if(SMrb[0].isSelected()){
					inTable = inTable + " AND ";
				}else{
					inTable = inTable + " OR ";
				}
			}
		
			inTable = inTable.substring(0,inTable.length()-4);
			return inTable;
		}else{
		
			for(int j = 0;j < 6;j++){
				if(Sckbox[j].isSelected() == true){
					inTable = inTable + columnNames[j];
					inTable = inTable + " LIKE '%"+text[0]+"%"+text[1]+"%"+text[2]+"%"+text[3]+"%"+text[4]+"%' OR ";
				}
			}
			inTable = inTable.substring(0,inTable.length()-4);
			return inTable;
		}
	}
	
	public void addToTable(ResultSet rs) throws SQLException{
		int i = 0;
		
		ArrayList<String[]> rsList = new ArrayList<String[]>();
		String[] rsData = new String[cot];
		
		ConvertString cs = new ConvertString();
		
		/*この辺りがうまくいってない*/
		while(rs.next()){
			for(int j=0;j<6;j++){
				if(kindOfDisplayTable[j]){
					rsData[i] = rs.getString(columnNames[j]);
					if(XSrb[0].isSelected()){
						rsData[i] = cs.xsymToSym(rsData[i]);
					}
					i++;
				}
			}
			i = 0;
			rsList.add(rsData.clone());
		}
		
		String[] nmData = new String[cot];
		
		
		for(int k=0;k<cot;k++){
		

		
			nmData[k] = temp[k]/*nmList.get(k)*/;
		}
		
		String[][] tblData = new String[rsList.size()][cot];
		for(int k=0;k<rsList.size();k++){
			tblData[k] = rsList.get(k);
		}
		JFrame jf2 = new JFrame("result");
		Container gcp2 = jf2.getContentPane();
		jf2.setSize(700,500);
		
		jt = new JTable(tblData,nmData);
		
		
		/*
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				jt.requestFocusInWindow();
			}
		});*/
		//jt.requestFocusInWindow();
		
		
		JScrollPane sp = new JScrollPane(jt);
	    	//sp.setPreferredSize(new Dimension(670, 470));
		sp.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

	    	pr = new JPanel();
	    	
	    	pr.setLayout(new BoxLayout(pr,BoxLayout.PAGE_AXIS));
	    	
	    	pr.add(sp);

		cb = new JButton("選択しているセルデータをクリップボードにコピー");
		cb.addActionListener(this);
		
		pr.add(cb);

		/*

		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				pr.requestFocusInWindow();
			}
		});

		*/

		
	    	gcp2.add(pr, BorderLayout.CENTER);
	    	
	    	jf2.setVisible(true);
	    	
	    	jf2.toFront();
	    	
	    	pr.setFocusable(true);
	    	
	    	cot = 0;
	}
	
	//作りかけ
	public void getDataFromSelectedCell(){
		int row = jt.getSelectedRow();
		int column = jt.getSelectedColumn();
		Object cellStr = jt.getValueAt(row,column);
		
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection((String)cellStr);
		clip.setContents(selection,selection);
		
		
	}
	
}
