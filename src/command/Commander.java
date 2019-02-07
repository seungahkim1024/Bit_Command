package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {

	public static Command order(HttpServletRequest request, HttpServletResponse response){
		System.out.println("== 3.커멘더 진입 ==");
		Command  cmd = null;
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case MOVE:
			System.out.println("커멘더 무브로");
			cmd = new Command(request, response);
			break;
		case REGISTER: case SIGNUP:
			System.out.println("커멘더 레지 아니면 조인으로"+Action.valueOf(request.getParameter("cmd").toUpperCase()));
			cmd = new CreateCommand(request, response);
			break;
		case ACCESS: case SIGNIN:
			System.out.println("커멘더 액세스");
			cmd = new ExistCommand(request, response);
			break;
		}
		System.out.println("커멘더 내 : "+Receiver.cmd.getView());
		return cmd;
	}
}