package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.Book;
import entities.CityDTO;
import entities.CountryDTO;

@WebServlet("/PreUpdateBook")
public class PreUpdateCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreUpdateCity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Client client = Client.create();
		Gson son = new Gson();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api/"+id);
		String data = resource.get(String.class);
		Book book = son.fromJson(data, Book.class);
		
		request.setAttribute("b", book);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
