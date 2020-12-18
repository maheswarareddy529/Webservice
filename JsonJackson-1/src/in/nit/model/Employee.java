package in.nit.model;
//alt+shift+s,o=constructor
//alt+shift+s,r=getters and setters
//alt+shift+s,s=toString
public class Employee {
	//JAVA OBJECT TO JSON
	private int eid;
	private String ename;
	private double esal;
	public Employee() {
		System.out.println("zero param Constructor");
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	

}
