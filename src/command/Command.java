package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import proxy.Proxy;
import proxy.RequestProxy;
@Data
public class Command implements Order{
	protected String action, domain, page, view;
	public Command(){}
	public Command(Map<String, Proxy> pxy){
		System.out.println("=== 6.Command ===");
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		setAction(request.getParameter("cmd"));
		String dir =request.getParameter("dir");
		System.out.println("디렉토리 : "+dir);
		if(dir==null){
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		}else{
		setDomain(dir);
		}
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
}
