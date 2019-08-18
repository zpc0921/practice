package service;

import model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BirthdayGreetingService {
    public void send(List<User> userList) {
        userList.stream().peek(item -> {
            Date date = new Date();
            //创建不同的日期格式
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

            if (Objects.equals(item.getBirthDay(), df.format(date))) {
                this.sendEmail(item);
            }
        });
    }

    public void sendEmail(User user) {
        System.out.println("Happy birthday!\n");
        System.out.printf("Happy birthday, deay %s!", user.getFirstName());
    }
}
