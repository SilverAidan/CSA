
public class Words {
	String[] words;

	public Words(String[] words) {
		this.words = words;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	public int indexOf(String word) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word)) {
				return i;
			}
		}
		return -1;
	}

	public void addWord(String word) {
		String[] tempWords = new String[words.length + 1];
		for (int i = 0; i < words.length; i++)
			tempWords[i] = words[i];
		tempWords[tempWords.length - 1] = word;
		words = tempWords;
	}

	public void cycle() {
		String lastWord = words[words.length - 1];
		for (int i = words.length - 1; i > 0; i--) {
			words[i] = words[i - 1];

		}
		words[0] = lastWord;
	}
}
