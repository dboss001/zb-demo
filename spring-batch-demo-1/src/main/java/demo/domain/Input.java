package demo.domain;

import java.math.BigDecimal;

public class Input {
	
	private String documentName;
	private String groupName;
	private String itemName;
	private BigDecimal amount;
	
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Input [documentName=" + documentName + ", groupName=" + groupName + ", itemName=" + itemName
				+ ", amount=" + amount + "]";
	}
}
