package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enums.Action;
import command.Carrier;
import command.Receiver;
import domain.EmployeeDTO;
import service.EmployeeService;
import service.EmployeeServiceImpl;


@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = EmployeeServiceImpl.getInstance(); 
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		EmployeeDTO emp = null;
		
		System.out.println("=== 1.컨트롤러  진입 ===");
		Receiver.init(request, response); //-> 이걸로인해 다섯군데를 돌아다니며 view가 셋팅 끝.
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())){
			case MOVE:
			Carrier.forward(request, response);
			break;
		case REGISTER:
			System.out.println("register 진입!!!");
			emp = new EmployeeDTO();
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setNotes(request.getParameter("notes"));
			service.registEmployee(emp);
			Carrier.forward(request, response);
			break;
		}
	}	
}
