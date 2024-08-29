package ex02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/purchaseCar")
public class CarPurchaseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String model = req.getParameter("model");
		String quantityStr = req.getParameter("quantity");
		int quantity;
		
		try {
			quantity = Integer.parseInt(quantityStr);		
		} catch (NumberFormatException e) {
			quantity = 0;
			System.out.println(quantity);
		}
		
		if(model == null || model.isEmpty() || quantity == 0) {
			model = "Tesla Model S";
			quantity = 3;
			
		}
		
		String  message = quantity + "대의 " + model + "를 구매하셨습니다!";
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("<h2>" + message + "</h2>");
		
	}
}
