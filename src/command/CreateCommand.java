package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		System.out.println("create커멘더 진입!");
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setPhoto(request.getParameter("photo")); // 메인과 다른 곳도 고치기
		emp.setManager(request.getParameter("manager"));
		emp.setName(request.getParameter("name"));
		emp.setBirthDate(request.getParameter("birthday"));
		emp.setNotes(request.getParameter("desc"));
		EmployeeServiceImpl.getInstance().registEmployee(emp);
	
		
	}
}
