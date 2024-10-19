package lai.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lai.dev.data.dao.UserDao;
import lai.dev.data.driver.MySQLDriver;
import lai.dev.data.model.User;

public class UserImpl implements UserDao {

    Connection con = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(User user) {
    String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD, ROLE) VALUES(null, ?, ?, ?)";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getRole());
        return stmt.executeUpdate() > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Trả về false nếu có lỗi
}

    @Override
    public boolean update(User user) {
    String sql = "UPDATE USERS SET email = ? ,password = ?, role = ? WHERE id = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getRole());
        stmt.setInt(4, user.getId());
        return stmt.executeUpdate() > 0; // Trả về true nếu cập nhật thành công
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    @Override
    public boolean delete(int userId) {
    String sql = "DELETE FROM USERS WHERE id = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, userId);
        return stmt.executeUpdate() > 0; // Trả về true nếu xóa thành công
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    @Override
    public User find(int userId) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(userId, email, password, role);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE ID > ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                users.add(new User(id, email, password, role));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User find(String email, String password) {
        User user = null;
        try {
            String sql = "SELECT * FROM USERS WHERE email = ? AND password = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User find(String email) {
        String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(id, email, password, role);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
