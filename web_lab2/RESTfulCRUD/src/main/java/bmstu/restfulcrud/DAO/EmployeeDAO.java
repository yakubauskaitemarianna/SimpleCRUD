package bmstu.restfulcrud.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bmstu.restfulcrud.model.Employee;

public class EmployeeDAO {
	
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();
	
   
    static {
        initEmps();
    }
 
    private static void initEmps() {
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");
 
        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
    }
 
    public static Employee getEmployee(String empNo) {
    	return empMap.get(empNo); 
    }
 
    // NullPointerException - if the specified key or value is null and this map does not permit null keys or values
    // ClassCastException - if the class of the specified key or value prevents it from being stored in this map
    // UnsupportedOperationException - if the put operation is not supported by this map
    // IllegalArgumentException - if some property of the specified key or value prevents it from being stored in this map
    
    public static Employee addEmployee(Employee emp) {
    	try {
    		empMap.put(emp.getEmpNo(), emp);
    	}
        catch(NullPointerException e) {
        	System.out.print("EXCEPTION:" + e.getMessage()); 
        }
    	catch(ClassCastException e1) {
    		System.out.print("EXCEPTION:" + e1.getMessage());
    	}
    	catch(UnsupportedOperationException e2) {
    		System.out.print("EXCEPTION:" + e2.getMessage());
    	}
    	catch(IllegalArgumentException e3) {
    		System.out.print("EXCEPTION:" + e3.getMessage());
    	}
        return emp;
    }
    
    // NullPointerException - if the specified key or value is null and this map does not permit null keys or values
    // ClassCastException - if the class of the specified key or value prevents it from being stored in this map
    // UnsupportedOperationException - if the put operation is not supported by this map
    // IllegalArgumentException - if some property of the specified key or value prevents it from being stored in this map
    
    public static Employee updateEmployee(Employee emp) {
    	try {
    		empMap.put(emp.getEmpNo(), emp);
    	}
    	catch(NullPointerException e) {
    		System.out.print("EXCEPTION: " + e.getMessage());
    	}
    	catch(ClassCastException e1) {
    		System.out.print("EXCEPTION:" + e1.getMessage());
    	}
    	catch(UnsupportedOperationException e2) {
    		System.out.print("EXCEPTION:" + e2.getMessage());
    	}
    	catch(IllegalArgumentException e3) {
    		System.out.print("EXCEPTION:" + e3.getMessage());
    	}
        return emp;
    }
    
    // UnsupportedOperationException - if the remove operation is not supported by this map
    // ClassCastException - if the key is of an inappropriate type for this map
    // NullPointerException - if the specified key is null and this map does not permit null keys 
    
    public static void deleteEmployee(String empNo) {
    	try {
    		empMap.remove(empNo);
    	}
    	catch(UnsupportedOperationException e) {
    		System.out.print("EXCEPTION: " + e.getMessage());
    	}
    	catch(ClassCastException e1) {
    		System.out.print("EXCEPTION: " + e1.getMessage());
    	}
    	catch(NullPointerException e2) {
    		System.out.print("EXCEPTION: " + e2.getMessage());
    	}
    }
    
    // IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
    // NullPointerException - if the specified collection is null
    
    public static List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        try {
        	list.addAll(c);
        }
        catch(IndexOutOfBoundsException e) {
        	System.out.print("EXCEPTION: " + e.getMessage());
        }
        catch(NullPointerException e1) {
        	System.out.print("EXCEPTION: " + e1.getMessage());
        }        
        return list;
    }
     
}