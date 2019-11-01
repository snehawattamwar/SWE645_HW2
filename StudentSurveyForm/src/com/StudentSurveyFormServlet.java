/** Name- Sneha Wattamwar
*G#- G01209653
*The servlet is called when form is submitted
*It takes the raffle input and check if it contains 100.
*If one of the number is 100 it declares the student as the winner else declares that the student has lost the raffle
*/

package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSurveyFormServlet
 */
@WebServlet("/StudentSurveyFormServlet")
public class StudentSurveyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSurveyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "THANK YOU!! for submitting your valuable feedback";
		String winMessage = "CONGRATULATIONS you have won the raffle. Your movie tickets will be emailed to you";
		String lostMessage = "Sorry you did not win the raffle";
		String decisionMessage;
		if (request.getParameter("raffle").contains("100")) {
			decisionMessage  = winMessage;
		} else {
			decisionMessage = lostMessage;
		}
		request.setAttribute("MESSAGE", message);
		request.setAttribute("DECISION_MESSAGE", decisionMessage);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
 
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
