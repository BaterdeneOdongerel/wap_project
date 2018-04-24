package com.model.event;

import com.db.ConnectionConfiguration;

import com.utils.Utils;

import com.model.user.User;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventServiceImpl implements EventService {

    @Override
    public void insert(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();

            preparedStatement = connection.prepareStatement(
                    "INSERT into Event(title, start_date, end_date, begin_location, " +
                            "end_location, distance, comment, status, accident_location, accident_description, hasAccident) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, event.getTitle());
            preparedStatement.setTimestamp(2, Utils.convertTime(event.getStartDate()));
            preparedStatement.setTimestamp(3, Utils.convertTime(event.getEndDate()));
            preparedStatement.setString(4, event.getBeginLocation());
            preparedStatement.setString(5, event.getEndLocation());
            preparedStatement.setFloat(6, event.getDistance().floatValue());
            preparedStatement.setString(7, event.getComment());
            preparedStatement.setString(8, event.getStatus());
            preparedStatement.setString(9, event.getAccidentLocation());
            preparedStatement.setString(10, event.getAccidentDescription());
            preparedStatement.setBoolean(11, false);
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
    public Event selectById(int id) {
        Event user = new Event();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM event WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //user.setUserId(resultSet.getInt("user_id"));
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

        return user;
    }

    @Override
    public List<Event> selectAll() {
        List<Event> users = new ArrayList<Event>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM event");

            while (resultSet.next()) {
                Event event = new Event();

               // event.setPassword(resultSet.getString("password"));
               // users.add(user);
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

        return users;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM event WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM event WHERE id = ?");

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
    public void update(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE event SET " + "first_name = ?, last_name = ?, email = ? WHERE user_id = ?");

            preparedStatement.setInt(4, event.getId());
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
    public List<Event> selectByStatus(String status) {
        List<Event> users = new ArrayList<Event>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            String qry = "SELECT * FROM event WHERE status = '" + status + "'" ;

            resultSet = statement.executeQuery(qry);

            while (resultSet.next()) {
                Event event = new Event();
                event.setId( resultSet.getInt("id") );
                event.setTitle( resultSet.getString("title") );
                event.setStartDate(LocalDate.parse(resultSet.getString("start_date").substring(0,10) ) );
                event.setEndDate( LocalDate.parse(resultSet.getString("end_date").substring(0,10) ) );
                event.setBeginLocation( resultSet.getString("begin_location") );
                event.setEndLocation( resultSet.getString("end_location") );
                event.setDistance( resultSet.getFloat("distance") );
                event.setComment( resultSet.getString("comment") );
                event.setStatus( resultSet.getString("status") );
                event.setAccidentLocation( resultSet.getString("accident_location") );
                event.setHasAccident( resultSet.getBoolean("hasAccident") );
                users.add(event);
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

        return users;
    }



    public static void main(String[] args) {
    }
}
