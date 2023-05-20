package entities;


public class Book {
	
	private int id;
	
	private String author;
	
	private String description;
	
	private String image;
	
	private String name;
	
	private float price;
	
	private float sale_price;
	
	private int category_id;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String author, String description, String image, String name, float price, float sale_price,
			int category_id) {
		super();
		this.id = id;
		this.author = author;
		this.description = description;
		this.image = image;
		this.name = name;
		this.price = price;
		this.sale_price = sale_price;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
}
