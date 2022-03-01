package com.sibyl.sshm.hbmDao.impl;

import com.sibyl.sshm.entity.Role;
import com.sibyl.sshm.hbmDao.RoleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname RoleDaoImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/01 14:41
 */

@Transactional(value = "hbmTransactionManager", propagation = Propagation.REQUIRED)
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Role> findAll() {
        String hql = "from Role";
        Query<Role> query = this.getSession().createQuery(hql);
//        query.setFirstResult(0);
//        query.setMaxResults(1);
        return query.list();
    }
    @Override
    public Role findBookById(int id) {
        // TODO Auto-generated method stub
        Role role = this.getSession().get(Role.class, id);
        return role;
    }
    @Override
    public void save(Role book) {
        this.getSession().save(book);
    }
    @Override
    public void update(Role book) {
        // TODO Auto-generated method stub
    }
    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Object> query(String sql) {
//        Query query = getSession().createQuery(" SELECT DISTINCT m.key  " +
//                "FROM user_role ur  " +
//                "LEFT JOIN role r on ur.role_id = r.id  " +
//                "LEFT JOIN role_menu rm on ur.role_id = rm.role_id " +
//                "LEFT JOIN menu m on m.id = rm.menu_id " +
//                "where user_id = 3213");
        //r.id,r.name,rm.menuId
        Query query = getSession().createQuery("select r.id,r.name,rm.menuId " +
                "from Role r " +
                "left join RoleMenu rm on r.id = rm.roleId");

        List list = query.list();
        return list;
    }
}
