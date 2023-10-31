package com.jakeer.modal;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="roder")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 private String customerName;
	    private int customerId;
	    private LocalDate fromDate;
	    private LocalDate toDate;
	    private int roomid;
	    
	    public Order() {
	    	
	    }
	    public Order(int id, String customerName, int customerId, LocalDate fromDate, LocalDate toDate, int roomid) {
			super();
			this.id = id;
			this.customerName = customerName;
			this.customerId = customerId;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.roomid = roomid;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public LocalDate getFromDate() {
			return fromDate;
		}
		public void setFromDate(LocalDate fromDate) {
			this.fromDate = fromDate;
		}
		public LocalDate getToDate() {
			return toDate;
		}
		public void setToDate(LocalDate toDate) {
			this.toDate = toDate;
		}
		public int getRoomid() {
			return roomid;
		}
		public void setRoomid(int roomid) {
			this.roomid = roomid;
		}
		@Override
		public String toString() {
			return "Order [id=" + id + ", customerName=" + customerName + ", customerId=" + customerId + ", fromDate="
					+ fromDate + ", toDate=" + toDate + ", roomid=" + roomid + "]";
		}
		
		

}
