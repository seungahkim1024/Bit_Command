package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import proxy.PageProxy;
import proxy.Pagination;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("==== 3.exist커멘드 진입! ====");
		HttpSession session = request.getSession();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if (exist) {
				System.out.println("접근허용");
				Proxy paging = new Pagination();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomerList(pagePxy);
				System.out.println("한페이지의 고객 수: "+list.size());
				request.setAttribute("list", list);
				request.setAttribute("pagination", paging);
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
