package vo;

public class Logistics {
	String taskNO;
	String sender;
	String recipient;
	String senPhone;
	String recPhone;
	String senAdd;
	String recAdd;
	String senPost;
	String recPoSt;
	String remarks;
	String amount;
	String product;
	
	public Logistics(String taskNo,String sender, String recipient, String senPhone, String recPhone, String senAdd, String recAdd,
			String senPost, String recPoSt, String remarks, String amount,String product) {
		super();
		this.taskNO=taskNo;
		this.sender = sender;
		this.recipient = recipient;
		this.senPhone = senPhone;
		this.recPhone = recPhone;
		this.senAdd = senAdd;
		this.recAdd = recAdd;
		this.senPost = senPost;
		this.recPoSt = recPoSt;
		this.remarks = remarks;
		this.amount = amount;
		this.product = product;
	}
	
	
	public Logistics() {
		super();
	}
	public String getTaskNO() {
		return taskNO;
	}
	public void setTaskNO(String taskNO) {
		this.taskNO = taskNO;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSenPhone() {
		return senPhone;
	}
	public void setSenPhone(String senPhone) {
		this.senPhone = senPhone;
	}
	public String getRecPhone() {
		return recPhone;
	}
	public void setRecPhone(String recPhone) {
		this.recPhone = recPhone;
	}
	public String getSenAdd() {
		return senAdd;
	}
	public void setSenAdd(String senAdd) {
		this.senAdd = senAdd;
	}
	public String getRecAdd() {
		return recAdd;
	}
	public void setRecAdd(String recAdd) {
		this.recAdd = recAdd;
	}
	public String getSenPost() {
		return senPost;
	}
	public void setSenPost(String senPost) {
		this.senPost = senPost;
	}
	public String getRecPoSt() {
		return recPoSt;
	}
	public void setRecPoSt(String recPoSt) {
		this.recPoSt = recPoSt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
	    this.product = product;
	}    
	
	
}
