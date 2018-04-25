package com.model.userevent;

public interface UserEventService {

    void insert(int eventId , int userId);

    void delete(int eventId , int userId);

    UserEvent selectByIds(Integer user, Integer event);
}
