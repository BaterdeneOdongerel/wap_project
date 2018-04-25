package com.model.event;

import java.util.List;

public interface EventService {

    void insert(Event user);

    Event selectById(int id);

    void update(Event event);

    void updateStatus(String eventStatus, Integer id);

    void raise(Event id);

    List<Event> selectByStatus(String status);

    List<Event> getAccidentEvents();

}
