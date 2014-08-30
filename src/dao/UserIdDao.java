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

	//在构造方法之中实例化session对象
    public UserIdDao(){
       // 找到Hibernate配置
       Configuration config=new Configuration().configure();
       //从配置中取出SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //从SessionFactory中取出一个Session
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
		//执行语句
		this.session.save(userid);
		//提交事务
		tran.commit();
	}

}
