package cg.demo.Assessment1;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity

public class abes_order {
	@Override
	public String toString() {
		return "abes_order [id=" + id + ", date=" + date + ", amount=" + amount + ", cus=" + cus + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private LocalDate date;
	private double amount;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private abes_customer cus;
	public abes_customer getCus() {
		return cus;
	}
	public void setCus(abes_customer cus) {
		this.cus = cus;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
