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
import com.sun.jersey.api.client.WebResource;

import entities.Book;
import entities.CityDTO;
import entities.CountryDTO;

import com.sun.jersey.api.client.Client;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

@WebServlet("/InsertCity")
public class InsertCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertCity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
		
		Book book = new Book(0, author, description, image, name, price, sale_price, category);
		
		Gson gson = new Gson();
		String dataBook = gson.toJson(book);
		
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/web-service-restful/rest/book-api");
		
		ClientResponse clientResource = resource.type("application/json").post(ClientResponse.class, dataBook);
		String result = clientResource.getEntity(String.class);	
		Boolean bl = gson.fromJson(result, Boolean.class);
		if(bl) {
			request.getRequestDispatcher("LoadBook").forward(request, response);
		}else {
			request.getRequestDispatcher("insertCity.jsp").forward(request, response);
//			request.getRequestDispatcher("PreInsertCity").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
