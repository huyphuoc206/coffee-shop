package model;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
	private Long id;
	private double totalPrice;
	private String status;
	private LocalDateTime createdDate;
	private User staff;
	private Payment payment;
	private List<BillDetails> billDetails;

	public Bill() {
		super();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}

	public Long getId() {
		return id;
	}

}
