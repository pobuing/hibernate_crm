package cn.probuing.crm.service;

import cn.probuing.crm.domain.User;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/1 16:23
 * @Description:
 */
public interface UserService {

    /**
     * 登录业务
     * @param user 传入的封装参数的user
     * @return
     */
    User login(User user);
}
