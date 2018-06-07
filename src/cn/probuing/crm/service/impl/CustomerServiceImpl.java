package cn.probuing.crm.service.impl;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.service.CustomerService;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:50
 * @Description:
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        //打开事物
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            //异常事物回滚
            transaction.rollback();
        }
        transaction.commit();


    }

    @Override
    public List<Customer> getAllCustomer() {
        //获得线程绑定session
        Session session = HibernateUtil.getCurrentSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //dao操作数据库
        List<Customer> list = customerDao.getAllCustomer();
        //数据提交
        tx.commit();
        return list;
    }

    @Override
    public List<Customer> getAllCustomer(DetachedCriteria detachedCriteria) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //离线对象关联到session
        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        List list = criteria.list();
        tx.commit();
        //执行查询并返回
        return list;
    }
}
