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
			cmd = new Command(request, response);
			break;
		case REGISTER:
			cmd = new CreateCommand(request, response);
			break;
		}
		return cmd;
	}
}