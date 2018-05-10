package com.swamster;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Swamster
 */
@WebServlet("/Swamster")
@MultipartConfig()

public class Swamster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
//	private boolean isMultipart;
//	   private String filePath;
//	   private int maxFileSize = 50 * 1024;
//	   private int maxMemSize = 4 * 1024;
//	   private File file ;
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Swamster() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
//    public void init( ){
//        // Get the file location where it would be stored.
//        filePath = getServletContext().getInitParameter("file-upload"); 
//     }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status"); // Retrieves <input type="text" name="status">
        Part uploadedFile = request.getPart("input"); // Retrieves <input type="file" name="uploadedFile">
        InputStream content = uploadedFile.getInputStream();
       csvParse plzgo = new csvParse();
       plzgo.csvParser(content);
       try {
		JSONArray json= new JSONArray(plzgo.getJson());
	
		

		
		response.getOutputStream().println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"design.css\"/>\r\n" + 
				"<title>Swamster | Home</title>\r\n" + 
				"</head>\r\n" + 
				"<body class=\"bodybackground\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"topnav\" id=\"indextopnav\">\r\n" + 
				"  <a href=\"index.html\" class=\"active\">Home</a>\r\n" + 
				"  <a href=\"edit.html\">Edit</a>\r\n" + 
				"  <a href=\"select.html\">Select</a>\r\n" + 
				"  <input type=\"text\" placeholder=\"Search..\">\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"defaultbody\" id=\"indexbody1\">");
		
		
		
		response.getOutputStream().println("<button type=\"button\"  onclick=\"send("+"'"+json+"'"+" )\">Send\r\n" +" </button> ");
		
       } catch (JSONException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
		RequestDispatcher go = request.getRequestDispatcher("/test.html");
		go.include(request, response);
		
	}

}




















//String typein = request.getParameter("enter");
//
//response.getOutputStream().println("<!DOCTYPE html>\r\n" + 
//		"<html>\r\n" + 
//		"<head>\r\n" + 
//		"<meta charset=\"UTF-8\">\r\n" + 
//		"<link rel=\"stylesheet\" type=\"text/css\" href=\"design.css\"/>\r\n" + 
//		"<title>Swamster | Home</title>\r\n" + 
//		"</head>\r\n" + 
//		"<body class=\"bodybackground\">\r\n" + 
//		"\r\n" + 
//		"\r\n" + 
//		"\r\n" + 
//		"\r\n" + 
//		"<div class=\"topnav\" id=\"indextopnav\">\r\n" + 
//		"  <a href=\"index.html\" class=\"active\">Home</a>\r\n" + 
//		"  <a href=\"edit.html\">Edit</a>\r\n" + 
//		"  <a href=\"select.html\">Select</a>\r\n" + 
//		"  <input type=\"text\" placeholder=\"Search..\">\r\n" + 
//		"</div>\r\n" + 
//		"\r\n" + 
//		"<div class=\"defaultbody\" id=\"indexbody1\">");
//
//
//
//response.getOutputStream().println("<button type=\"button\"  onclick=\"send("+"'"+ typein+"'"+" )\">Send\r\n" +" </button> ");
//
//
//RequestDispatcher go = request.getRequestDispatcher("/test.html");
//go.include(request, response);
