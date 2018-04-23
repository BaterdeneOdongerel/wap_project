package com.model.userevent;

import com.model.event.Event;

import java.util.List;

public interface UserEventService {

    void insert(Event user);

    Event selectById(int id);

    List<Event> selectAll();

    void delete(int id);

    void update(Event user, int id);
    
}