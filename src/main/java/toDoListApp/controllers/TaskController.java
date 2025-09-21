package toDoListApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import toDoListApp.models.Task;
import toDoListApp.services.TaskService;

@Controller
@RequestMapping("/api/v1/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public ResponseEntity<List<Task>> getAllTasks()
	{
		return ResponseEntity.ok(taskService.getAllTask());
	}
	
	@GetMapping("/completed")
	public ResponseEntity <List<Task>> getAllCompletedTAsks()
	{
		return ResponseEntity.ok(taskService.findAllCompletedTask());
	}
	
	@GetMapping("/incomplete")
	public ResponseEntity <List<Task>> getAllIncompleteTasks()
	{
		return ResponseEntity.ok(taskService.findAllCompleteTask());
	}
	
	@PostMapping("/")
	public ResponseEntity <Task> createTask(@RequestBody Task task)
	{
		return ResponseEntity.ok(taskService.createNewTask(task));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Task> updateTask(@PathVariable Long id, @RequestBody Task task)
	{
		task.setId(id);
		return ResponseEntity.ok(taskService.updateTask(task));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Boolean> getAllTasks(@PathVariable Long id)
	{
		taskService.deleteTask(id);
		return ResponseEntity.ok(true);
	}
	
	
	
	
	
	
	
	

}
