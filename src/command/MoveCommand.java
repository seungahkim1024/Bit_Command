package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		System.out.println("== 4.무브커맨더진입 ==");
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		setPage(request.getParameter("page"));;
		execute();
	}
}
