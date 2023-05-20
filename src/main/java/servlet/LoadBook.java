package servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/LoadBook")
public class LoadBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api");
		
		String data = resource.get(String.class);
		Gson son = new Gson();
		GenericType<List<Book>> listType = new GenericType<List<Book>>() {};
		List<Book> listBook = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listBook);
		request.getRequestDispatcher("listBook.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
