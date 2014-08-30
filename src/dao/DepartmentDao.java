package dao;

import java.util.List;

import model.Department;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentDao {
	private Session session=null;

	//�ڹ��췽��֮��ʵ����session����
    public DepartmentDao(){
       // �ҵ�Hibernate����
       Configuration config=new Configuration().configure();
       //��������ȡ��SessionFactory
       SessionFactory factory=config.buildSessionFactory();
       //��SessionFactory��ȡ��һ��Session
       this.session=factory.openSession();
    }

    public List<Department> ListAll(){
    	Query query = this.session.createQuery("from Department");
		@SuppressWarnings("unchecked")
		List<Department>result = query.list();
		
		return result;
			
	}
	public void save(Department department){
		Transaction tran=this.session.beginTransaction();
		//ִ�����
		this.session.save(department);
		//�ύ����
		tran.commit();
	}
}
