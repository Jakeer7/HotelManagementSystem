package com.jakeer.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RoomsBooked")
public class RoomBooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String roomcategory;
	private int roomno;
	
	public RoomBooking() {
		
	}

	public RoomBooking(int id, String roomcategory, int roomno) {
		super();
		this.id = id;
		this.roomcategory = roomcategory;
		this.roomno = roomno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomcategory() {
		return roomcategory;
	}

	public void setRoomcategory(String roomcategory) {
		this.roomcategory = roomcategory;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomcategory=" + roomcategory + ", roomno=" + roomno + "]";
	}
	
	}
