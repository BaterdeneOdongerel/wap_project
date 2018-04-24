package com.model.event;

import com.db.ConnectionConfiguration;
import com.utils.Utils;
import com.wap.Services;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventServiceImpl implements EventService {

    @Override
    public void insert(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();

            preparedStatement = connection.prepareStatement(
                    "INSERT into Event(title, start_date, end_date, begin_location, " +
                            "end_location, distance, comment, status, accident_location, accident_description, hasAccident, owner) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, event.getTitle());
            preparedStatement.setTimestamp(2, Utils.convertTime(event.getStartDate()));
            preparedStatement.setTimestamp(3, Utils.convertTime(event.getEndDate()));
            preparedStatement.setString(4, event.getBeginLocation());
            preparedStatement.setString(5, event.getEndLocation());
            preparedStatement.setFloat(6, event.getDistance().floatValue());
            preparedStatement.setString(7, event.getComment());
            preparedStatement.setString(8, "Upcoming");
            preparedStatement.setString(9, event.getAccidentLocation());
            preparedStatement.setString(10, event.getAccidentDescription());
            preparedStatement.setBoolean(11, false);
            preparedStatement.setInt(12, Services.UserService.getCurrentUser().getUserId());
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
        Event event = new Event();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM event WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            int userId = Services.UserService.getCurrentUser().getUserId();

            while (resultSet.next()) {
                event.setId(resultSet.getInt("id"));
                event.setTitle(resultSet.getString("title"));
                event.setStartDate(Utils.convertTime(resultSet.getTimestamp("start_date")));
                event.setBeginLocation(resultSet.getString("begin_location"));
                event.setEndLocation(resultSet.getString("end_location"));
                event.setComment(resultSet.getString("comment"));
                event.setStatus(resultSet.getString("status"));
                event.setDistance(resultSet.getFloat("distance"));

                if (resultSet.getInt("owner") == userId)
                    event.setAccess("owner");
            }

            Statement statement = connection.createStatement();
            String qry2 = "SELECT * FROM userevent WHERE user_id = " + userId + " AND event_id=" + event.getId();
            ResultSet resultSet2 = statement.executeQuery(qry2);

            while (resultSet2.next()) {
                if (event.getAccess() != "owner") {
                    event.setAccess("participating");
                }
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

        return event;
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
                    .prepareStatement("UPDATE event SET title=?, start_date=?, end_date=?, begin_location=?, " +
                            "end_location=?, distance=?, comment=? WHERE id=?");

            preparedStatement.setString(1, event.getTitle());
            preparedStatement.setTimestamp(2, Utils.convertTime(event.getStartDate()));
            preparedStatement.setTimestamp(3, Utils.convertTime(event.getEndDate()));
            preparedStatement.setString(4, event.getBeginLocation());
            preparedStatement.setString(5, event.getEndLocation());
            preparedStatement.setFloat(6, event.getDistance().floatValue());
            preparedStatement.setString(7, event.getComment());
            preparedStatement.setInt(8, event.getId());
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
    public void raise(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE event SET hasAccident=1, accident_location=?, accident_description=? WHERE id=?");

            preparedStatement.setString(1, event.getAccidentLocation());
            preparedStatement.setString(2, event.getAccidentDescription());
            preparedStatement.setInt(3, event.getId());
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
    public void updateStatus(String status, Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE event SET status=? WHERE id=?");

            preparedStatement.setString(1, status.toString());
            preparedStatement.setInt(2, id);
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
        List<Event> events = new ArrayList<Event>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            String qry = "SELECT * FROM event WHERE status = '" + status+ "'" ;
            int userId = Services.UserService.getCurrentUser().getUserId();

            resultSet = statement.executeQuery(qry);


            while (resultSet.next()) {
                Event event = new Event();
                int id = resultSet.getInt("id");
                event.setId(id);
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
                event.setOwner( resultSet.getInt("owner") );
                events.add(event);
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

        return events;
    }

    @Override
    public List<Event> getAccidentEvents() {
        List<Event> events = new ArrayList<Event>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            String qry = "SELECT * FROM event WHERE hasAccident = 1 AND status = 'On going'" ;

            resultSet = statement.executeQuery(qry);
            HashMap<Integer, Event> eventMap = new HashMap<>();

            while (resultSet.next()) {
                Event event = new Event();
                int id = resultSet.getInt("id");
                event.setId(id);
                event.setTitle( resultSet.getString("title") );
                event.setAccidentLocation( resultSet.getString("accident_location") );
                event.setAccidentDescription( resultSet.getString("accident_description") );
                event.setHasAccident( resultSet.getBoolean("hasAccident") );
                event.setOwner( resultSet.getInt("owner") );
                events.add(event);
                eventMap.put(id, event);
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
        return events;
    }


    public static void main(String[] args) {
    }
}
