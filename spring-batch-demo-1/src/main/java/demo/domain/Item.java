package demo.domain;

import java.math.BigDecimal;

public class Item {
	
	private Long id;
	private String name;
	private BigDecimal amount;
	private Long groupId;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", amount=" + amount + ", groupId=" + groupId + ", documentId="
				+ documentId + "]";
	}
	
}
