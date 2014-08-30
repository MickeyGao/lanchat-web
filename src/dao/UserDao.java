package dao;

import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
	private Session session=null;

	//在构造方法之中实例化session对象
    public UserDao(){
       // 找到Hibernate配置
       Configuration config=new Configuration().configure();
       //从配置中取出SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //从SessionFactory中取出一个Session
       this.session=factory.openSession();
    }

    public List<User> ListAll(){
    	Query query = this.session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User>result = query.list();
		
		return result;
			
	}
	public void save(User user){
		Transaction tran=this.session.beginTransaction();
		//执行语句
		this.session.save(user);
		//提交事务
		tran.commit();
	}
	
	public User login(String id, String password){
		Query query = this.session.createQuery("from User where id=? and password=?");
		
		query.setParameter(0, id);
		query.setParameter(1, password);
		
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		
		session.getTransaction().commit();
		session.close();
		User user = users.get(0);
		if(user!=null){
			return user;
		}
		else{
			return null;
		}
	}
}
