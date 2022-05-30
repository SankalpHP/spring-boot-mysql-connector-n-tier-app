package com.spring.boot.mysql.connector.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mysql.connector.demo.model.Worker;
import com.spring.boot.mysql.connector.demo.service.WorkerService;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
	@Autowired
	private WorkerService workerService;
	
	WorkerController() {
		super();
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Worker worker) {
		
		try {
			if (Boolean.TRUE.equals(this.workerService.addWorker(worker))) {
				return "New worker record added successfully";
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while inserting a new worker record!\n" + ex);
		}
		
		return "Failure in inserting new worker record!";
	}
	
	public String get(Integer id) {
		try {
			Worker worker = this.workerService.getWorker(id);
			return worker == null ? "Empty set!" : worker.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of worker #" + id + "!\n" + ex);
		}
		
		return null;
	}
	
	@GetMapping("/all")
	public String getAll() {
		try {
			List<Worker> workers = this.workerService.getAllWorkers();
			
			return workers.isEmpty() ? "Empty set!" : workers.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching all worker records!\n" + ex);
		}
		
		return null;
	}
	
	public String update(String department, Integer id) {
		try {
			if (Boolean.TRUE.equals(this.workerService.updateWorker(department, id))) {
				return String.format("Record of worker #%d updated successfully", id);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while updating the record of worker #" + id + "!\n" + ex);
		}
		
		return String.format("Failure in updating the record of worker #%d!", id);
	}
	
	public String delete(Integer id) {
		try {
			if (Boolean.TRUE.equals(this.workerService.deleteWorker(id))) {
				return String.format("Record of worker #%d deleted successfully", id);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while deleting the record of worker #" + id + "!\n" + ex);
		}
		
		return String.format("Failure in deleting the record of worker #%d!", id);
	}
}
