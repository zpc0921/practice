package service;

import model.User;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserProcService {
    private List<User> userList;

    public void proc(String fileName) {
        final String userInfos = FileUtil.read(fileName);
        if (Objects.isNull(userInfos)) {
            //
        }

        final List<String> userStrList = Arrays.asList(userInfos.split("\r\n"));

        this.userList = userStrList.stream().map(item -> {
            final String[] userStr = item.split(", ");
            User user = new User();
            user.setFirstName(userStr[0]);
            user.setLastName(userStr[1]);
            user.setBirthDay(userStr[2]);
            user.setEmail(userStr[3]);
            return user;

        }).collect(Collectors.toList());
    }

    public List<User> getUserList() {
        return userList;
    }

}
