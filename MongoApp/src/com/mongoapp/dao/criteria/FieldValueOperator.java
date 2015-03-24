package com.mongoapp.dao.criteria;

public class FieldValueOperator {
	
	private String field;
	private Object value;
	private String operator;
	
	
	public FieldValueOperator() {
	}
	
	public FieldValueOperator(String field, Object value) {
		super();
		this.field = field;
		this.value = value;
	}
	
	public FieldValueOperator(String field, Object value, String operator) {
		this(field, value);
		this.operator = operator;
	}

	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return field + " | " + operator + "|" +value;
	}
}
