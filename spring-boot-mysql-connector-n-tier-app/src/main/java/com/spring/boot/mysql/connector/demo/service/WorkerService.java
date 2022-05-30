package com.spring.boot.mysql.connector.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.mysql.connector.demo.dao.WorkerDao;
import com.spring.boot.mysql.connector.demo.model.Worker;
@Service
public class WorkerService {
	@Autowired
	private WorkerDao workerRepository;
	
	WorkerService() {
		super();
		
	}
	
	public Boolean addWorker(Worker worker) throws SQLException {
		Integer recordsInserted = this.workerRepository.createWorker(worker);
		
		return recordsInserted > 0;
	}
	
	public Worker getWorker(Integer id) throws SQLException {
		return this.workerRepository.findWorkerById(id);
	}
	
	public List<Worker> getAllWorkers() throws SQLException {
		return this.workerRepository.findAllWorkers();
	}
	
	public Boolean updateWorker(String department, Integer id) throws SQLException {
		Worker worker = this.workerRepository.findWorkerById(id);
		worker.setDepartment(department);
		Integer recordsUpdated = this.workerRepository.updateWorker(worker);
		
		return recordsUpdated > 0;
	}
	
	public Boolean deleteWorker(Integer id) throws SQLException {
		Integer recordsDeleted = this.workerRepository.deleteWorkerById(id);
		
		return recordsDeleted > 0;
	}
}
