package cn.probuing.crm.dao.impl;

import cn.probuing.crm.dao.LinkManDao;
import cn.probuing.crm.domain.LinkMan;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/21 17:18
 * @Description:
 */
public class LinkManDaoImpl implements LinkManDao {
    @Override
    public void save(LinkMan lm) {
        Session session = HibernateUtil.getCurrentSession();
        session.save(lm);
    }
}
