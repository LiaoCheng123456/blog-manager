package com.service.blog.controller.user;

import com.alibaba.fastjson.JSON;
import com.service.blog.constbag.Const;
import com.service.blog.constbag.RepsitoryPool.ControllerRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.ServiceRepositoryNamePool;
import com.service.blog.constbag.route.UserRoute;
import com.service.blog.model.User;
import com.service.blog.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * the controller main be uses for handle user be related to
 */
@RestController
@RequestMapping(value = ControllerRepositoryNamePool.CONTROLLER_USER)
public class UserController {

    @Resource(name = ServiceRepositoryNamePool.SERVICE_USER)
    private UserService userService;

    @PostMapping(value = UserRoute.USER_LOGIN, headers = Const.HEADERS, produces = Const.PRODUCES_JSON)
    public String userLogin(HttpServletRequest request, @RequestBody String requestParam) {
        User user = JSON.parseObject(requestParam, User.class);
        return userService.userLogin(JSON.toJSONString(user));
    }
}
