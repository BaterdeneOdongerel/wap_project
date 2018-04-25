package com.servlet;

import com.model.event.EventService;
import com.model.event.EventServiceImpl;
import com.model.user.UserService;
import com.model.user.UserServiceImpl;
import com.model.userevent.UserEventImpl;
import com.model.userevent.UserEventService;

/**
 * Created by admin on 4/23/18.
 */
public class Services {

    public static EventService EventService;
    public static UserService UserService;
    public static UserEventService UserEventService;

    static {
        UserService = new UserServiceImpl();
        EventService = new EventServiceImpl();
        UserEventService = new UserEventImpl();
    }
}
