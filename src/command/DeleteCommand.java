package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("===딜리트커멘드 진입!!!===");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(request.getParameter("customerID"));
		CustomerServiceImpl
			.getInstance()
			.removeCustomer(cus);
	}
}
