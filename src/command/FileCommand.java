package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import enums.Action;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			System.out.println("[파일커맨드 파일업로드 진입]");
			ImageProxy ipxy = new ImageProxy();
			ipxy.carryOut(request);
			Map<String, Object> map = CustomerServiceImpl
										.getInstance()
										.fileUpload(ipxy);
			request.setAttribute("image", map.get("img"));
			request.setAttribute("cus", map.get("cus"));
			break;
		default:
			break;
		}
	}
}
