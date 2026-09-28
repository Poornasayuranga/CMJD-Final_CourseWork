package com.example.demo.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentDate;
    private String paymentMethod;
    private double amount;
    //private String booking;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getPaymentDate() {
      return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
  }

  public String getPaymentMethod() {
      return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  //public String getBooking() {
      //return booking;
 // }

  //public void setBooking(String booking) {
      //this.booking = booking;
  //}

  public double getAmount() {
      return amount;
  }

  public void setAmount(double amount) {
      this.amount = amount;
  }




}
