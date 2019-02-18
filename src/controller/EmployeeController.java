package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Carrier;
import command.Receiver;


@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("=== 1.컨트롤러  진입 ===");
		Receiver.init(request, response); //-> 이걸로인해 다섯군데를 돌아다니며 view가 셋팅 끝.
		Carrier.forward(request, response);
	}	
}
