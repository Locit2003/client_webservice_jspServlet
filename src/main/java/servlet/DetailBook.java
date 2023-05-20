package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.WebResource;

import entities.Book;
import entities.CityDTO;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
@WebServlet("/DetailBook")
public class DetailBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer BookId = Integer.parseInt(request.getParameter("id"));
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api/"+BookId);
		
		String result = resource.get(String.class);
		Gson son = new Gson();
		Book book = son.fromJson(result, Book.class);
		request.setAttribute("b", book);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
