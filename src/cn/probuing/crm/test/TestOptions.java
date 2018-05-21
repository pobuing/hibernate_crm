package cn.probuing.crm.test;

import cn.probuing.crm.domain.Role;
import cn.probuing.crm.domain.User;
import cn.probuing.crm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/21 14:12
 * @Description: 测试类
 */
public class TestOptions {

    /**
     * 保存员工以及角色
     */
    @Test
    public void testAddUserAndRole() {
        //从工厂获得session
        Session session = HibernateUtil.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //操作数据
        //-------------------------------
        //创建两个User
        User user1 = new User();
        User user2 = new User();
        user1.setUser_name("blackman");
        user2.setUser_name("whiteman");

        //创建两个role
        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();
        role1.setRole_name("vp");
        role2.setRole_name("cto");
        role3.setRole_name("security");


        //用户表达关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);
        //角色表达关系
        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);
        //保存到数据库
        session.save(user1);
        session.save(user2);
        session.save(role1);
        session.save(role2);
        session.save(role3);
        //-------------------------------
        //提交事务
        tx.commit();
        //关闭资源
        session.close();
    }

    @Test
    /**
     * 添加角色到某个用户中
     */
    public void addRoleToUser() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        //操作
        //------------
        //获得要添加的用户
        User user = session.get(User.class, 3l);
        //创建公关角色
        Role role = new Role();
        role.setRole_name("公关");
        //将角色添加到用户
        user.getRoles().add(role);
        //将角色转换为持久化
        session.save(role);
        //------------
        tx.commit();
        session.close();
    }

    @Test
    public void delRoleFromUser(){
        //获取session
        Session session = HibernateUtil.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //操作数据
        //-------------
        //获得要删除的数据
        User user = session.get(User.class, 3l);
        //获得要删除的角色数据
        Role role = session.get(Role.class, 7l);
        user.getRoles().remove(role);
        //-------------
        //提交事务
        tx.commit();
        //关闭资源
        session.close();

    }
}
