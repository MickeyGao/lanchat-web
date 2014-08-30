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

	//在构造方法之中实例化session对象
    public JobDao(){
       // 找到Hibernate配置
       Configuration config=new Configuration().configure();
       //从配置中取出SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //从SessionFactory中取出一个Session
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
		//执行语句
		this.session.save(job);
		//提交事务
		tran.commit();
	}
}
