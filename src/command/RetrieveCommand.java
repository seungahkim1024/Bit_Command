package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("===리트리브커멘드 진입!!!===");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(request.getParameter("customerID"));
		System.out.println("커스토머 아이디!"+cus);
		cus = CustomerServiceImpl
				.getInstance().retrieveCustomer(cus);
		request.setAttribute("cus", cus);
	}
}
