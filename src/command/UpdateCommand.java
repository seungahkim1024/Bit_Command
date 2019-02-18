package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("===업데이트커멘드 진입!!!===");
		
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(request.getParameter("customer_id"));
		cus =CustomerServiceImpl.getInstance().retrieveCustomer(cus);
		System.out.println(cus.toString());
		
		if(!request.getParameter("phone").equals("")){
			cus.setPhone(request.getParameter("phone"));
		}
		if(!request.getParameter("city").equals("")){
			cus.setCity(request.getParameter("city"));
		}
		if(!request.getParameter("address").equals("")){
			cus.setAddress(request.getParameter("address"));
		}
		if(!request.getParameter("postal_code").equals("")){
			cus.setPostalCode(request.getParameter("postal_code"));
		}
		if(!request.getParameter("password").equals("")){
			System.out.println("업데이트커멘드 비밀번호 cus: "+cus.toString());
			cus.setPassword(request.getParameter("password"));
		}
		System.out.println("수정하려는 회원의 정보: "+cus.toString());
		request.setAttribute("cus",cus);
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
	}
}
