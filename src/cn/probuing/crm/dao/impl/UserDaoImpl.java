package cn.probuing.crm.dao.impl;

import cn.probuing.crm.dao.UserDao;
import cn.probuing.crm.domain.User;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/1 16:28
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getByUserCode(String user_code) {
        Session session = HibernateUtil.getCurrentSession();
        String hql = "from User where user_code = ?";
        //创建查询对象
        Query query = session.createQuery(hql);
        query.setParameter(0, user_code);
        User user = (User) query.uniqueResult();
        return user;
    }
}
