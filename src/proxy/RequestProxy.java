package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class RequestProxy implements Proxy{
	private HttpServletRequest request; //연관관계 갖게된다.
	
	@Override
	public void carryOut(Object o) {
		System.out.println("----3----");
		if((HttpServletRequest) o !=null){
			System.out.println("o 안에 들어있는 cmd : "+((HttpServletRequest) o).getParameter("cmd"));
			System.out.println("o 안에 들어있는 page : "+((HttpServletRequest) o).getParameter("page"));
			setRequest((HttpServletRequest) o);
		}else{
			System.out.println("o 가 널");
		}
	}

}
