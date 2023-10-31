package com.jakeer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakeer.modal.Customer;
import com.jakeer.modal.Room;
@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
    public List<Room> findByStatus(String status);
    public Room findByRoomno(int roomno);

}
