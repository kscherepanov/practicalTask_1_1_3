package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 10);
        userService.saveUser("Petr", "Petrov", (byte) 20);

        userService.removeUserById(2);
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.printf(
                    "ID: %s NAME: %s LASTNAME: %s AGE: %s\n",
                    user.getId(),
                    user.getName(),
                    user.getLastName(),
                    user.getAge()
            );
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
