package jUnitExample.myservices;

import jUnitExample.bean.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	
	List<Todo> todoList = new ArrayList<>();
	
	public void addTodo(Todo t) {
		todoList.add(t);
	}
	
	public void removeTodo(Todo t) {
		todoList.remove(t);
	}
	
	
	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
	
}
