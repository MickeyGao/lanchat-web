package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.UserId;

public class UserIdDao {
	private Session session=null;

	//�ڹ��췽��֮��ʵ����session����
    public UserIdDao(){
       // �ҵ�Hibernate����
       Configuration config=new Configuration().configure();
       //��������ȡ��SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //��SessionFactory��ȡ��һ��Session
       this.session=factory.openSession();
    }

    public List<UserId> ListAll(){
    	Query query = this.session.createQuery("from UserId");
		@SuppressWarnings("unchecked")
		List<UserId>result = query.list();
		
		return result;
			
	}
	public void save(UserId userid){
		Transaction tran=this.session.beginTransaction();
		//ִ�����
		this.session.save(userid);
		//�ύ����
		tran.commit();
	}

}
