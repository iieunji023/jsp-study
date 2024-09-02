package ex04;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/feedbackSummary")
public class FeedbackSummaryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 애플리케이션 범위에서 피드백 리스트를 가져옵니다.
        ServletContext context = getServletContext();
        ArrayList<String> feedbackList = (ArrayList<String>) context.getAttribute("feedbackList");

        // 피드백 리스트를 request 속성에 설정합니다.
        req.setAttribute("feedbackList", feedbackList);
        
        resp.setContentType("text/html; charset=UTF-8");

        // 피드백 요약 페이지로 포워딩합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/feedbackSummary.jsp");
        dispatcher.forward(req, resp);
        
    }
}
