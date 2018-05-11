package cn.probuing.crm.dao.impl;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:53
 * @Description:
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        //获得session
        Session session = HibernateUtil.openSession();
        //打开事物
        Transaction transaction = session.beginTransaction();
        //执行保存
        session.save(customer);
        //提交事物
        transaction.commit();
        //关闭资源
        session.close();
    }
}
