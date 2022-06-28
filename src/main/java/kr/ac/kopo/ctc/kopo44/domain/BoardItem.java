package kr.ac.kopo.ctc.kopo44.domain;

import java.util.Objects;

public class BoardItem {
	private int id;
	private String title;
	private String date;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardItem other = (BoardItem) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date) && id == other.id
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "BoardItem [id=" + id + ", title=" + title + ", date=" + date + ", content=" + content + "]";
	}
	
}
