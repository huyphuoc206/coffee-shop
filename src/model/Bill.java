package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {
	private Long id;
	private long totalPrice;
	private String status;
	private LocalDateTime createdDate;
	private long staffId;
	private Payment payment;
	private List<BillDetails> billDetails;

	public Bill() {
		billDetails = new ArrayList<BillDetails>();
	}

	public long getTotalPrice() {
		return totalPrice;

	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long calTotalPrice() {
		long total = 0;
		for (BillDetails item : billDetails) {
			DrinkDetails d = item.getDrinkDetails();
			total += d.getPrice() * item.getQuantity();
		}
		return total;
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

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addBillDetails(BillDetails b) {
		long id = b.getDrinkDetails().getId();
		int index = containsItem(id);
		if (index != -1)
			billDetails.get(index).setQuantity(billDetails.get(index).getQuantity() + b.getQuantity());
		else
			billDetails.add(b);
	}

	// if contain item return index of item, else return -1
	private int containsItem(long id) {
		for (int i = 0; i < billDetails.size(); i++) {
			if (billDetails.get(i).getDrinkDetails().getId() == id)
				return i;
		}
		return -1;
	}

	public void removeBillDetail(int index) {
		billDetails.remove(index - 1);
	}
}
