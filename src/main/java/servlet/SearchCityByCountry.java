package servlet;

import java.io.IOException;
import java.net.URLEncoder;
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
@WebServlet("/SearchBook")
public class SearchCityByCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchCityByCountry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookName = request.getParameter("name");
		
		Client client = Client.create();
		if(bookName==null || bookName.length()==0)
			bookName = " ";
		
		String NameSearch = URLEncoder.encode(bookName, "UTF-8");
				
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api/"+NameSearch);
		String data = resource.get(String.class);
		
		Gson son = new Gson();
		GenericType<List<Book>> listType = new GenericType<List<Book>>() {};
		List<Book> books = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", books);
		request.getRequestDispatcher("listCity.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
