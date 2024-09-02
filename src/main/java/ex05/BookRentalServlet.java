package ex05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rentalBook")
public class BookRentalServlet extends HttpServlet{
	private final static int MAX_RENTAL_PERIOD = 14;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("bookId");
		String rentalPeriodStr = req.getParameter("rentalPeriod");
		int rentalPeriod = 0;
		
		
		if(bookId == "" || rentalPeriodStr == "") {
			bookId = "불편한 편의점";
			try {
				rentalPeriod = Integer.parseInt(rentalPeriodStr);
			} catch (NumberFormatException e) {
				rentalPeriod = 7;
			}
		}
		
		if(rentalPeriod > MAX_RENTAL_PERIOD) {
			req.setAttribute("errorMsg", "최대 대여기간을 초과하였습니다. 대여 기간은 최대 " + MAX_RENTAL_PERIOD + "일 입니다.");
			
			req.getRequestDispatcher("/rentalFail.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("bookId", bookId);
			req.setAttribute("rentalPeriod", rentalPeriod);
			
			req.getRequestDispatcher("/rentalResult.jsp").forward(req, resp);
			
		}
	}
}
