package cn.probuing.crm.service.impl;

import cn.probuing.crm.dao.UserDao;
import cn.probuing.crm.domain.User;
import cn.probuing.crm.service.UserService;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Transaction;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/1 16:23
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao ud;

    public UserDao getUd() {
        return ud;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public User login(User user) {
        //打开事物
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        //根据登录名称查询User对象
        User exisU = ud.getByUserCode(user.getUser_code());
        //查询结束 提交事物
        tx.commit();
        //参数获得不到=>抛出异常提示用户名不存在
        if (exisU == null) {
            throw new RuntimeException("用户名不存在");
        }
        //比对密码是否一致
        if (!exisU.getUser_password().equals(user.getUser_password())) {
            throw new RuntimeException("密码错误!");
        }
        //密码不一致抛出异常提示密码错误
        //将数据库查询的user返回
        return exisU;
    }
}
