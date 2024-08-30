package ex03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rentBook")
public class BookRentalServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// "bookName"과 "rentalDays" 파라미터 추출
		String bookName = req.getParameter("bookName");
		String rentalDaysStr = req.getParameter("rentalDays");
		int rentalDays;
		
		try {
			rentalDays = Integer.parseInt(rentalDaysStr);
			
		}catch (NumberFormatException e) {
			rentalDays = 0;
		}
		
		if(bookName == null || bookName.isEmpty() || rentalDays == 0) {
			bookName = "불편한 편의점";
			rentalDays = 10;
		}
		
		// 요청 속성에 도서명과 대여일수 저장
		req.setAttribute("bookName", bookName);
		req.setAttribute("rentalDays", rentalDays);
		
		// rentalConfirm.jsp로 포워딩
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/rentalConfirm.jsp");
		dispatcher.forward(req, resp);
		
	}

}
