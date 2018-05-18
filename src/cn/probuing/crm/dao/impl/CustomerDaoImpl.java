package cn.probuing.crm.dao.impl;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:53
 * @Description:
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        //获得session
        Session session = HibernateUtil.getCurrentSession();
        //执行保存
        session.save(customer);
    }

    /**
     * 使用criteria单表查询
     *
     * @return
     */
    @Override
    public List<Customer> getAllCustomer() {
        //获取session
        Session session = HibernateUtil.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }
}
