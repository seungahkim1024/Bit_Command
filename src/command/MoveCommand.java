package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		System.out.println("== 4.무브커맨더진입 ==");
		setRequest(request);
		setAction(request.getParameter("action"));
		System.out.println("무브커멘더의 action값 : "+action);
		setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		System.out.println("무브커멘더의 domain값 : "+request.getServletPath().split("/")[1].replace(".do", ""));
		setPage(request.getParameter("page"));;
		System.out.println("무브커멘더의 page값 : "+page);
		execute();
	}
}
