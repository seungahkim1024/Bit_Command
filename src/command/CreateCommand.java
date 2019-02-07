package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		System.out.println("create커멘더 진입!");
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case REGISTER :
		EmployeeDTO emp = new EmployeeDTO();
		emp.setPhoto(request.getParameter("photo")); // 메인과 다른 곳도 고치기
		emp.setManager(request.getParameter("manager"));
		emp.setName(request.getParameter("name"));
		emp.setBirthDate(request.getParameter("birthday"));
		emp.setNotes(request.getParameter("desc"));
		EmployeeServiceImpl.getInstance().registEmployee(emp);
		break;
		
		case SIGNUP:
		System.out.println("createCommand의 signup!!!");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(request.getParameter("id"));
		cus.setCustomerName(request.getParameter("name"));
		cus.setPassword(request.getParameter("pass"));
		cus.setSsn(request.getParameter("ssn"));
		cus.setAddress(request.getParameter("address"));
		cus.setCity(request.getParameter("city"));
		cus.setPostalCode(request.getParameter("postalCode"));
		CustomerServiceImpl.getInstance().registCustomer(cus);
		break;
		}		
	}
}
