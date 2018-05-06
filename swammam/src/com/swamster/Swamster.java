package com.swamster;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Swamster
 */
@WebServlet("/Swamster")
public class Swamster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Swamster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//	response.setContentType("text/html");
//	PrintWriter printwriter = response.getWriter();
//	printwriter.println("<html>");
//	printwriter.println("<head>");
//	printwriter.println("<script language\"JavaScript\">");
//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/js/fireconnect.js");
//		requestDispatcher.include(request,response);
//	printwriter.println("</head>");
//	printwriter.println("<body>");
//	printwriter.println("<form action=\"/swammam/WebContent/test.html\" onClick=\"return user(this.username.value)\">");
//	
//	printwriter.println("<input type=\"button\" value=\"Button\">");
//	printwriter.println("</form>");
//	printwriter.println("</body>");
//	printwriter.println("</html>");
	
//	double takein = Double.parseDouble(request.getParameter("num1"));
//	double takein2 = Double.parseDouble(request.getParameter("num2"));
//	System.out.println(takein + takein2);
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String typein = request.getParameter("enter");
//		System.out.println(jefa);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//		PrintWriter printwriter = response.getWriter();
//		printwriter.println("<html>");
//		printwriter.println("<head>");
//
//
//		printwriter.println("</head>");
//		printwriter.println("<body>");
//		
//	
//		printwriter.println("</body>");
//		printwriter.println("</html>");
		
		
		
		
		
		
		
//		response.setContentType("text/html");
//		PrintWriter printwriter = response.getWriter();
//		
//		String one = request.getParameter("vehicle");
//		
//		;
//		//RequestDispatcher go = request.getRequestDispatcher("/test.html");
//		
//		printwriter.println("<html>");
//		printwriter.println("<head>");
//
//
//		printwriter.println("</head>");
//		printwriter.println("<body>");
//	
//		
//		
//		printwriter.println("</body>");
//		
//		
//		printwriter.println("<script>");
//		printwriter.println("src=\"https://www.gstatic.com/firebasejs/4.13.0/firebase.js\">");
//		printwriter.println("</script>");
//		
//		printwriter.println("<script>");
//		printwriter.println("// Initialize Firebase\r\n" + 
//				"  var config = {\r\n" + 
//				"    apiKey: \"AIzaSyAJIorYfyXdhQ9THqnJsXp4rjGIjxcS1ds\",\r\n" + 
//				"    authDomain: \"swamsteras.firebaseapp.com\",\r\n" + 
//				"    databaseURL: \"https://swamsteras.firebaseio.com\",\r\n" + 
//				"    projectId: \"swamsteras\",\r\n" + 
//				"    storageBucket: \"swamsteras.appspot.com\",\r\n" + 
//				"    messagingSenderId: \"824450759757\"\r\n" + 
//				"  };\r\n" + 
//				"  firebase.initializeApp(config);");
//		printwriter.println("</script>");
//		
//		
//		printwriter.println("<script>");
//		printwriter.println("var database = firebase.database();"); 
//		printwriter.println("firebase.database().ref('server').set(\"urdone\");");
//		printwriter.println("</script>");
//		
//		printwriter.println("</html>");
		
		
		
		response.getOutputStream().print("<button type=\"button\"  onclick=\"send(" +"'"+ typein+ "'" +")\">Send\r\n" +" </button> ");
		RequestDispatcher go = request.getRequestDispatcher("/test.html");
		go.include(request, response);
		


		
		
		
		
		
		
//		response.setContentType("application/javascript");
////		PrintWriter printwriter = response.getWriter();
//		
//		String one = request.getParameter("vehicle");
//		
//		ScriptEngineManager manager = new ScriptEngineManager();
//	    ScriptEngine engine = manager.getEngineByName("JavaScript");
//	    
//	    try {
//			engine.eval("/js/fireconnect.js");
//		} catch (ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//	    
//	    Invocable inv = (Invocable) engine;
//	    
//	    try {
//			inv.invokeFunction("firebase", "it work");
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//		
////		RequestDispatcher go = request.getRequestDispatcher("/test.html");
////		go.include(request, response);
//		
		
		
		
		
		
	}

}
