package cn.probuing.crm.service.impl;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.dao.impl.CustomerDaoImpl;
import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.domain.LinkMan;
import cn.probuing.crm.service.LinkManService;
import cn.probuing.crm.utils.HibernateUtil;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/21 17:11
 * @Description: 联系人接口实现类
 */
public class LinkManServiceImp implements LinkManService {

    private CustomerDao cd = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();

    @Override
    public void save(LinkMan lm) {

        try {
            //打开事务
            HibernateUtil.getCurrentSession().beginTransaction();
            //根据客户id获取客户对象
            Long customer_id = lm.getCust_id();
            //添加linkman到客户中
            Customer ct = cd.getByCustomerId(customer_id);
            //保存linkman到数据库
            lm.setCustomer(ct);
            lmd.save(lm);
            HibernateUtil.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            HibernateUtil.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
