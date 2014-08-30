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

	//�ڹ��췽��֮��ʵ����session����
    public UserDao(){
       // �ҵ�Hibernate����
       Configuration config=new Configuration().configure();
       //��������ȡ��SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //��SessionFactory��ȡ��һ��Session
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
		//ִ�����
		this.session.save(user);
		//�ύ����
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
