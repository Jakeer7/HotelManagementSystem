package com.jakeer.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="myroom")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String roomcategory;
	private int roomno;
	private String status ="unbook";
	
	public Room() {
		
	}

	public Room(int id, String roomcategory, int roomno,String status) {
		super();
		this.id = id;
		this.roomcategory = roomcategory;
		this.roomno = roomno;
		this.status=status;
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

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
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
		return "Room [id=" + id + ", roomcategory=" + roomcategory +", status="+status+ ", roomno=" + roomno + "]";
	}
	
	}
