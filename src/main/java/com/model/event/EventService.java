package com.model.event;

import java.util.List;

public interface EventService {

    void insert(Event user);

    Event selectById(int id);

    List<Event> selectAll();

    void delete(int id);

    void update(Event event);
    
}
