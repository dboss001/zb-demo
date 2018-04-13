package demo.domain;


public class Group {
	
	private Long id;
	private String name;
	private Long documentId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", documentId=" + documentId + "]";
	}
	
}
