package service;

import java.util.List;

import model.Job;
import dao.JobDao;

public class JobManager {
private JobDao jobDao;
	
	public List<Job> getAllJobs(){
		jobDao = new JobDao();
		return jobDao.ListAll();
	}
	
	public void addJob(Job job){
		jobDao = new JobDao();
		jobDao.save(job);
	}
}
