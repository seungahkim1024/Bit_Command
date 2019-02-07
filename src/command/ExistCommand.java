package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		System.out.println("exist커멘드 진입!");

		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if (exist) {
				System.out.println("접근허용");
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
			exist = CustomerServiceImpl.getInstance().existsCustomer(cus);
			if (exist) {
				System.out.println("접근허용");
			} else {
				System.out.println("접근불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
				break;
			}
			System.out.println("existCommand 내부: " + super.getView());
		}
	}
}
