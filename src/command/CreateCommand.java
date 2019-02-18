package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();

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
		cus.setPassword(request.getParameter("pass"));
		cus.setCustomerName(request.getParameter("name"));
		cus.setSsn(request.getParameter("ssn"));
		cus.setAddress(request.getParameter("address"));
		cus.setCity(request.getParameter("city"));
		cus.setPostalCode(request.getParameter("postalCode"));
		System.out.println("커멘드 id==="+request.getParameter("id"));
		CustomerServiceImpl.getInstance().registCustomer(cus);
		break;
		default:
			break;
		}		
	}
}
