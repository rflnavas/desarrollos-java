package jUnitExample.test;

import java.util.Date;

import jUnitExample.bean.Todo;
import jUnitExample.myservices.TodoList;

import org.junit.Assert;
import org.junit.Test;

public class TodoListTest {
	
	
	@Test
	public final void insercion(){
		TodoList tl = new TodoList();
		tl.addTodo(new Todo("Sacar al perro", new Date()));
		tl.addTodo(new Todo("Sacar al perro", new Date()));
		
		Assert.assertTrue(tl.getTodoList().size() == 1 );
	}
}
