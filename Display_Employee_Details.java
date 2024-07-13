package employee_details;

import java.util.Scanner;

class Employee
{
	int emp_no;
	String emp_name;
	String join_data;
	char designation_code;
	String department;
	int basic;
	int hra;
	int it;
	public Employee(int emp_no, String emp_name, String join_data, char designation_code, String department, int basic,
			int hra, int it) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.join_data = join_data;
		this.designation_code = designation_code;
		this.department = department;
		this.basic = basic;
		this.hra = hra;
		this.it = it;
	}
	String getDesignation(Employee target) 
	{
		String designation="";
		switch(target.designation_code)
		{
			case 'e' : designation="Enginner";break;
			case 'c' : designation="Consultant";break;
			case 'k' : designation="Clerk";break;
			case 'r' : designation="Receptionist";break;
			case 'm' : designation="Manager";break;
		}
		return designation;
	}
	
	int getDA(char code)
	{
		int da=0;
		switch(code)
		{
			case 'e' : da=20000;break;
			case 'c' : da=32000;break;
			case 'k' : da=12000;break;
			case 'r' : da=15000;break;
			case 'm' : da=40000;break;
		}
		return da;
	}
	
	int getSalary(Employee emp)
	{
		return emp.basic + emp.hra + getDA(emp.designation_code) - emp.it;
	}
}

public class Display_Employee_Details {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Employee[] employees = new Employee[7];
		employees[0] = new Employee(1001,"Ashish","01/04/2009",'e',"R&D",20000,8000,3000);
		employees[1] = new Employee(1002,"Sushma","23/08/20012",'c',"PM",30000,12000,9000);
		employees[2] = new Employee(1003,"Rahul","12/11/2008",'k',"Acct",10000,8000,1000);
		employees[3] = new Employee(1004,"Chahat","29/01/2013",'r',"Front Desk",12000,6000,2000);
		employees[4] = new Employee(1005,"Ranjan","16/07/2005",'m',"Engg",50000,20000,20000);
		employees[5] = new Employee(1006,"Suman","01/01/2000",'e',"Manufacturing",23000,9000,4400);
		employees[6] = new Employee(1007,"Tanmay","12/06/2006",'c',"PM",29000,12000,10000);
		
		System.out.print("Enter ID of the employee : ");
		int key = sc.nextInt();
		
		Employee target = null;
		
		for(int i=0;i<7;i++) {
			if(employees[i].emp_no==key) {
				target = employees[i];
			}
		}
		
		if(target==null) {
			System.out.println("There is no employee with emp_id :"+key);
		}
		else {
			System.out.println("Employee Id : "+target.emp_no);
			System.out.println("Employee Name : "+target.emp_name);
			System.out.println("Department : "+target.department);
			System.out.println("Designation : "+target.getDesignation(target));
			System.out.println("Salary : "+target.getSalary(target));
		}
		
		sc.close();	
	}
}
