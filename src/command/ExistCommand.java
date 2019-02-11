package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		System.out.println("exist커멘드 진입!");
		HttpSession session = request.getSession();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if (exist) {
				System.out.println("접근허용");
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomerList();
				System.out.println("총 고객의 수: "+list.size());
				System.out.println("가장 최근에 가입한 고객명: "+list.get(0).getCustomerName());
				request.setAttribute("list", list);
			} else {
				System.out.println("접근불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;

		case SIGNIN:
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(request.getParameter("id"));
			cus.setPassword(request.getParameter("pass"));
			System.out.println("dto id==="+request.getParameter("id"));
			System.out.println("dto pass==="+request.getParameter("pass"));
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			
			if (cus!=null) {
				System.out.println("로그인성공");
				session.setAttribute("customer", cus);
			} else {
				System.out.println("로그인실패");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			break;
		default:
			break;
		}
	}
}
