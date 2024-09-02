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

@WebServlet("/submitFeedback")
public class FeedbackSubmissionServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용자로부터 받은 피드백 데이터를 가져옵니다.
        String feedback = req.getParameter("feedback");
        System.out.println(feedback);

        // 애플리케이션 범위에 저장된 피드백 리스트를 가져옵니다.
        ServletContext context = getServletContext();
        ArrayList<String> feedbackList = (ArrayList<String>) context.getAttribute("feedbackList");
        System.out.println(feedbackList);
        
        
        // 처음 실행시 feedbackList가 null일 경우, 새로운 리스트를 생성합니다.
        if (feedbackList == null) {
            feedbackList = new ArrayList<>();
            context.setAttribute("feedbackList", feedbackList);
        }

        // 피드백 리스트에 새로운 피드백을 추가합니다.
        feedbackList.add(feedback);

        // 피드백 제출 후에는 피드백 요약 페이지로 리다이렉트합니다.
        resp.sendRedirect("feedbackSummary");
    }
		
	}

