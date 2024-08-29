package ex01;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		// "name" 파라미터 추출
		String name = req.getParameter("name");
		if(name == null || name.isEmpty()) {
			name = "Guest";
		}
		
		// 환영 메시지 생성
		String message = "Hello, " + name + "!";
		
		// 응답 설정
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("<h2>" + message + "</h2>");
	}

}
