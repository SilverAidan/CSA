
public class WellesTurner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ex1
		String[] books = new String[]{"Howls Moving Castle", "Ready Player One", "The Alchemist", "Castle in the Sky", "Kingdom Hearts Ultimania"};
		Book[] library = new Book[5];
		
		//ex2
		for(int i = 0; i <books.length; i++) {
			library[i] = new Book(books[i]);
		}
		library[2].setAuthor("Paul Coelho");
		
		//ex3
		library[3].setAuthors(new String[] {"Dani Cavallaro", "Jonathan Swift"});
		System.out.println(library[3].getAuthors()[1]);
		
		//ex4
		Book tempBook = library[0];
		library[0] = library[library.length-1];
		library[library.length-1] = tempBook;
		for(Book book:library) {
			System.out.println(book.getTitle());
		}
		
		//ex5
		for (Book book:library) {
			int year = (int)(Math.random()*124)+1900;
			book.setPubYear(year);
			System.out.println(book.getPubYear());
		}
		int closest = 1984;
		Book close = null;
		int distance = 1000;
		for (Book book:library) {
			if(Math.abs(book.getPubYear()-closest)<distance) {
				distance = Math.abs(book.getPubYear()-closest);
				close = book;
			}
		}
	}
}
