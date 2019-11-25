package model;

public class Uniform {

	private String Img;
	private Uniform next;
	private Uniform prev;

	public Uniform(String img) {
		Img = img;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	public void addUniform(Uniform newUniform) {
		if (next == null) {
			next = newUniform;
		} else {
			next.addUniform(newUniform);
		}
	}

	public Uniform searchUniform(String img) {
		if (next != null) {
			if (next.getImg().equals(img)) {
				return next;
			} else {
				return next.searchUniform(img);
			}
		} else {
			return null;
		}
	}
}
