package model;

public class Uniform {

	private String name;
	private String Img;
	private Uniform first;
	private Uniform prev;

	public Uniform(String name, String img) {
		this.name = name;
		Img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

}
