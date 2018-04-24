package com.wap;

/**
 * Created by admin on 4/24/18.
 */
public enum EventStatus {
    UPCOMING {
        @Override
        public String toString() {
            return "Upcoming";
        }
    }, ONGOING {
        @Override
        public String toString() {
            return "On going";
        }
    }
}
