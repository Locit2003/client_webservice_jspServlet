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

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api/"+bookId);
		
		String result = resource.type("application/json").delete(String.class);
		Gson son = new Gson();
		Boolean bl = son.fromJson(result, Boolean.class);
		if(bl) {
			request.setAttribute("success", "Delete successfully!");
		}else {
			request.setAttribute("err", "Delete failed!");
		}
		
		
		resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api/");
		String data = resource.get(String.class);
		
		GenericType<List<Book>> listType = new GenericType<List<Book>>() {};
		List<Book> listBook = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listBook);
		request.getRequestDispatcher("listBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
