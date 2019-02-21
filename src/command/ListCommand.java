package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

public class ListCommand extends Command{
	// ?cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("list커멘드 진입!");
		PageProxy pagePxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagePxy.carryOut(page);
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case CUS_LIST: 
			List<CustomerDTO> list = CustomerServiceImpl
			.getInstance()
			.bringCustomerList
			(pagePxy);
			request.setAttribute("list", list);
			request.setAttribute("pagination", page);
		break;
		case PRO_LIST:
			List<ProductDTO> proList = ProductServiceImpl
			.getInstance()
			.bringAllProductList(pagePxy);
			request.setAttribute("proList", proList);
			System.out.println("프로리스트 ==== "+proList);
			request.setAttribute("pagination", page);
		break;
		default:
			break; 
		}
		
	}
}
