package cn.probuing.crm.dao;

import cn.probuing.crm.domain.User;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/1 16:27
 * @Description:
 */
public interface UserDao {
    /**
     * 从数据库查询User
     * @param user_code
     * @return
     */
    User getByUserCode(String user_code);
}
