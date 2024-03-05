import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Arrays;

public class main {
	public static String employee_hourly_rate;
	public static String[] employee;
	
	public static void main(String [] args) {
		
		boolean conts = true;
		while (conts) {
			System.out.println("======= Start of Session ===========");
			define_data_type();
			
//			System.out.println("hourly rate : "+employee_hourly_rate);
//			System.out.println(Arrays.toString(employee));
			
			// return 0 kung empty
			// return n kung may laman
			if(employee.length != 0) {
				System.out.println("Employee ID: " + employee[0]);
				System.out.println("Name: " + employee[1] + ", " + employee[2]);
				System.out.println("Position: " + employee[11]);
				System.out.println("hourly salary: " + employee[18]);
				System.out.println("Basic Salary: " + sanitize_data(employee[13]));
				
				System.out.println("============== Calculation ==============");
				String sss_contrib = get_sss_calculation();
				
			} else {
				System.out.println("No data found. Please try again");
			}
			System.out.println("======= End of Session ===========");
			System.out.println("**********************************");
		}
	}
	
	public static void reset_data() {
		employee_hourly_rate = "";
		employee = new String [0];
	}
	
	public static void define_data_type() {
		reset_data();
		System.out.print("Enter an Employee number: ");
		
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInput = inputReader.readLine();
			
			String employee_detail = get_employee_details(userInput);
			
			if(!employee_detail.equals("")) {
				String[] row = employee_detail.split(",");
				employee = row;
				employee_hourly_rate = row[18];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}
	
	public static String sanitize_data(String info) {
		return info.replace(";x;", ",").replace("\"", "");
	}
	
	public static String get_employee_details(String employee_id) {
		// identify the file directory
		String file = System.getProperty("user.dir") + "/src/employee_details.csv";
		
		// initialize the variables
		BufferedReader reader = null;
		String line = "";
		String employee_found = "";
		
		try {
			// get the csv file from directory and load it onto your java project
			reader = new BufferedReader(new FileReader(file));
			
			// tell the system to iterate on each line of the csv
			while ((line = reader.readLine()) != null) {
				
				String repl = line.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
				String[] row = repl.split(",");

				if (Integer.parseInt(row[0]) == Integer.parseInt(employee_id)) {
					employee_found = repl;
				}

			}
		} catch (Exception e) {e.printStackTrace(); }
		
		return employee_found;
		
	}
	
	public static String get_sss_calculation() {
		
		String d_montly_salary = employee[13].replace(";x;", "").replace("\"", "");
		System.out.println("monthly salary: "+d_montly_salary);
		return null;
	}
    
}


