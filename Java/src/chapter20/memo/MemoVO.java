package chapter20.memo;

import java.sql.Date;
import java.util.Objects;

// Value Object : 값을 저장하는 객체
// DTO(Data Transfer Object) : 
// Model
// Item
public class MemoVO {
	private int id;
	private String title;
	private String contents;
	private Date registerDate;
	private Date modifyDate;
	public MemoVO() {
	}
	public MemoVO(int id, String title, String contents, Date registerDate, Date modifyDate) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
	}
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemoVO other = (MemoVO) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", title=" + title + ", contents=" + contents + ", registerDate=" + registerDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}

