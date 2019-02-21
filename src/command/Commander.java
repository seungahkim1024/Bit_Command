package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {

	public static Command order(Map<String,Proxy> pxy){
		System.out.println("== 5.Commander 진입 ==");
		Command  cmd = null;
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("커멘더 액션 "+request.getParameter("cmd"));
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case MOVE:
			cmd = new Command(pxy);
			break;
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS: case SIGNIN:
			cmd = new ExistCommand(pxy);
			break;
		case CUS_LIST: case PRO_LIST:
			System.out.println("---- list-----");
			cmd = new ListCommand(pxy);
			break;
		case CUS_RETRIEVE:
			cmd = new RetrieveCommand(pxy);
			break;
		case CUST_UPDATE:
			System.out.println("커멘더====CUST_UPDATE");
			cmd = new UpdateCommand(pxy);
			break;
		case CUST_FILE_UPLOAD:
			cmd = new FileCommand(pxy);
			break;
		case CUS_DELETE:
			cmd = new DeleteCommand(pxy);
			break;
		default:
			break;
		}
		
		System.out.println("커멘더 내 : "+Receiver.cmd.getView());
		return cmd;
	}
}