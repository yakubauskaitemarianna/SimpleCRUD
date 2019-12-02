package bmstu.restfulcrud.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;

import bmstu.restfulcrud.DAO.EmployeeDAO;
import bmstu.restfulcrud.model.Employee;
 
@Path("/employees")
public class EmployeeService extends HttpServlet {
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void getEmployees_JSON(HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException, ClientProtocolException{
    	
        List<Employee> listOfCountries = EmployeeDAO.getAllEmployees();
        
        PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(listOfCountries);
		out.flush(); 
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void getEmployee(@PathParam("empNo") String empNo, HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException, ClientProtocolException {
    	
    	PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(EmployeeDAO.getEmployee(empNo));
		out.flush();
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addEmployee(Employee emp, HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException, ClientProtocolException{
    	
    	HttpPost httpPost = new HttpPost("http://localhost:8080/RESTfulCRUD/employees");
    	httpPost.setEntity(new UrlEncodedFormEntity(EmployeeDAO.addEmployee(emp);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        response.getStatusLine().getStatusCode();
        client.close();
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void updateEmployee(Employee emp, HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException, ClientProtocolException{
    	
    	HttpPost httpPost = new HttpPost("http://localhost:8080/RESTfulCRUD/employees");
    	httpPost.setEntity(new UrlEncodedFormEntity(EmployeeDAO.addEmployee(emp);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        response.getStatusLine().getStatusCode();
        client.close();
    }
 
    @DELETE
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteEmployee(@PathParam("empNo") String empNo, HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException, ClientProtocolException{
    	
    	HttpDelete httpDelete = new HttpDelete("http:////localhost:8080/RESTfulCRUD" + empNo);
    	ClientProtocolException("Unexpected response status: " + (String) response.getStatusLine().getStatusCode(););
        EmployeeDAO.deleteEmployee(empNo);
        CloseableHttpResponse response = client.execute(httpDelete);
        client.close();
    }
 
}
