package com.service.blog.dao.user;

import com.service.blog.model.User;

public interface IUserDao {
    User userLogin(User user);

    User getUser(User user);
}
