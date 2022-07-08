package chapter13.confirm;

public class Board {
	private String title;
	private String content;
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return String.format("Board [title=%s, content=%s]", title, content);
	}
	
}