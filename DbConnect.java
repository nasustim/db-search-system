import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect{

	CreateWindow cw;
	String[] text = new String[5];
	
	boolean dbConnect(String[] text){
		
		this.text = text;
		
		cw = new CreateWindow();
		
		try{
			dbaccess();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void dbaccess() throws Exception{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection(
					"jdbc:postgresql://localhost/testdb",USER,PASSWORD
					);
			st = cn.createStatement();
			
			
			//rs = st.executeQuery("SELECT * FROM TeXtest WHERE value LIKE '%"+this.text+"%'");
			
			System.out.println("SELECT * FROM lem_tb WHERE "+cw.createInTable(this.text));
			
			rs = st.executeQuery("SELECT * FROM lem_tb WHERE "+cw.createInTable(this.text));
			//rs = st.executeQuery("SELECT * FROM lem_tb WHERE apply LIKE '%"+this.text+"%'");
			cw.addToTable(rs);
		}finally{
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (cn != null)
				cn.close();
		}
	}

	
}
