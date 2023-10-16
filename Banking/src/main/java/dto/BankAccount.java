package dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {

	@Id
	@SequenceGenerator(initialValue = 4805001, allocationSize = 1, sequenceName = "accno", name = "accno")
	@GeneratedValue(generator = "accno")
	long AccountNo;

	@Column(nullable = false)
	double Amount;

	@Column(nullable = false)
	double AccountLimit;

	@Column(nullable = false)
	String AccountType;

	@Column(nullable = false)
	boolean Status;

	@ManyToOne
	Customer customer;

	public long getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(long accountNo) {
		AccountNo = accountNo;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getAccountLimit() {
		return AccountLimit;
	}

	public void setAccountLimit(double accountLimit) {
		AccountLimit = accountLimit;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
