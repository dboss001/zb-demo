package demo.domain;

import java.math.BigDecimal;

public class Total {
	
	private Long id;
	private BigDecimal amount;
	private Long grouptId;
	private Long documentId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getGrouptId() {
		return grouptId;
	}
	public void setGrouptId(Long grouptId) {
		this.grouptId = grouptId;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	@Override
	public String toString() {
		return "Total [id=" + id + ", amount=" + amount + ", grouptId=" + grouptId + ", documentId=" + documentId + "]";
	}
}
