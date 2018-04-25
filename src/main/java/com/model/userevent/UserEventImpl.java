package com.model.userevent;

import com.db.ConnectionConfiguration;
import com.model.event.Event;
import com.model.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEventImpl implements UserEventService {

    @Override
    public void insert(int eventId, int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO userevent (event_id, user_id, owner)"
                    + "VALUES (" + eventId + " ," + userId + ", 0)");
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int eventId, int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM userevent WHERE user_id = ? and event_id = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, eventId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public UserEvent selectByIds(Integer user, Integer event) {
        UserEvent res = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            String qry = "SELECT * FROM userevent WHERE user_id = '" + user +
                    "' and event_id = '" + event + "'";

            resultSet = statement.executeQuery(qry);

            while (resultSet.next()) {
                res = new UserEvent();
                res.setId(resultSet.getInt("id"));
                res.setOwner(resultSet.getBoolean("owner"));
                res.setUserId(resultSet.getInt("user_id"));
                res.setEventId(resultSet.getInt("event_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
