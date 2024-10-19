/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lai.dev.data.faker;

import java.util.ArrayList;
import java.util.List;
import lai.dev.data.impl.UserImpl;
import lai.dev.data.model.User;

public class UserGenerator {
    // Hàm tạo danh sách người dùng ngẫu nhiên
    public List<UserFaker> generateRandomUsers(int count) {
        List<UserFaker> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            UserFaker user = new UserFaker();  // Tạo người dùng ngẫu nhiên
            users.add(user);  // Thêm người dùng vào danh sách
        }
        return users;
    }

    public static void main(String[] args) {
        UserImpl userImpl = new UserImpl();
        
        // Tạo một đối tượng User mới
        User newUser = new User(0, "vichicken@example.com", "123", "user");
        
        // Thêm người dùng vào cơ sở dữ liệu
        if (userImpl.insert(newUser)) {
            System.out.println("Người dùng đã được thêm thành công!");
        } else {
            System.out.println("Có lỗi xảy ra khi thêm người dùng.");
        }
    }
}




