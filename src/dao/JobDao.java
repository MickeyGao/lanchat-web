package dao;

import java.util.List;

import model.Job;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JobDao {
	private Session session=null;

	//�ڹ��췽��֮��ʵ����session����
    public JobDao(){
       // �ҵ�Hibernate����
       Configuration config=new Configuration().configure();
       //��������ȡ��SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //��SessionFactory��ȡ��һ��Session
       this.session=factory.openSession();
    }

    public List<Job> ListAll(){
    	Query query = this.session.createQuery("from Job");
		@SuppressWarnings("unchecked")
		List<Job>result = query.list();
		
		return result;
			
	}
	public void save(Job job){
		Transaction tran=this.session.beginTransaction();
		//ִ�����
		this.session.save(job);
		//�ύ����
		tran.commit();
	}
}
