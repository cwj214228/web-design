package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

/**
 * 
 * @author ASUS
 *Addcourse Addstudent Serchcourse Serchstudent Deletecourse Deletestudent upscore changecourse 
 */
public class teacher {
	private String tid,tpw,tname;
	Connection conn;
	public teacher(String tid, String tpw, String tname) {
		super();
		this.tid = tid;
		this.tpw = tpw;
		this.tname = tname;
	}
	public teacher(){
		
	}
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTpw() {
		return tpw;
	}

	public void setTpw(String tpw) {
		this.tpw = tpw;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	public void Addcourse(score sc) throws SQLException, ClassNotFoundException {
		String sql="insert into score(id,kname,xuefen,tname) values("+Integer.parseInt(sc.getId())+",'"+sc.getKname()+"','"+sc.getXuefen()+"','"+sc.getTname()+"')";
		connectiondatabase.getState().executeUpdate(sql);
	}
	public void Addstudent(student stu) throws SQLException, ClassNotFoundException{
		String sql="insert into student(sid,spw,sname,sclass,major) values("+stu.getSid()+",'"+stu.getSpw()+"','"+stu.getSname()+"','"+stu.getSclass()+"','"+stu.getMajor()+"')";
		connectiondatabase.getState().executeUpdate(sql);
	}
	
	public ArrayList<student> managestudent() throws SQLException, ClassNotFoundException {
		student stu=null;
		ArrayList<student> managestudents=new ArrayList<student>();
		String sql="select * from student";
		ResultSet rs=connectiondatabase.getState().executeQuery(sql);
		while(rs.next()){
			managestudents.add(new student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return managestudents;
	}
	public ArrayList<score> managecourse() throws SQLException, ClassNotFoundException {
		score sc=null;
		ArrayList<score> managecourses=new ArrayList<score>();
		String sql="select * from score";
		ResultSet rs=connectiondatabase.getState().executeQuery(sql);
		while(rs.next()){
			managecourses.add(new score(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return managecourses;
	}
}
