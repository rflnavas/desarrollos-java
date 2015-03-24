package es.hibernatewebapp.util;

public enum Operator {
	EQ(" = "), GT(" > "), GE(" >= "), LT(" < "), LE(" <= "), LIKE(" LIKE "), 
	BETWEEN(" BETWEEN "), AND(" AND "), OR("OR"), IN(" IN ");

	String operator;
	private Operator(String op) {
		this.operator = op;
	}
	public String operator() {
		return  operator;
	}
}
