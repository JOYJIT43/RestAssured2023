package Trial;

public class Try {

	public static void main(String[] args) {
		
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWhUJO8DTOc5vmBXX_r9wHz7EnUsUVRB0UINRgsO4v9IJ-pK01lzhFpE0VdSt-57Tg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		

	    System.out.print(url.split("&")[0].split("code=")[1]);
	}

}
