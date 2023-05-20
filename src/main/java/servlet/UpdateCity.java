package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.Book;
import entities.CityDTO;
import entities.CountryDTO;

@WebServlet("/UpdateCity")
public class UpdateCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int category = Integer.parseInt(request.getParameter("category_id"));
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		Date foundationDate = null;
//		try {
//			foundationDate = sf.parse(request.getParameter("foundationDate"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Float price = Float.parseFloat(request.getParameter("price")) ;
		Float sale_price = Float.parseFloat(request.getParameter("sale_price"));
		String image = request.getParameter("image");
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		
		Book bookUpdate = new Book(id, author, description, image, name, price, sale_price, category);
		
		Gson gson = new Gson();
		String dataBook = gson.toJson(bookUpdate);
		
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api");
		
		ClientResponse clientResource = resource.type("application/json").put(ClientResponse.class, dataBook);
		String result = clientResource.getEntity(String.class);	
		Boolean bl = gson.fromJson(result, Boolean.class);
		if(bl) {
			request.getRequestDispatcher("LoadBook").forward(request, response);
		}else {
			resource = client.resource("http://localhost:8080/WEBSERV_Lab04_Webservices/rest/cityService/"+id);
			String data = resource.get(String.class);
			Book book = gson.fromJson(data, Book.class);
			request.setAttribute("err", "Update failed!");
			request.setAttribute("b", book);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
