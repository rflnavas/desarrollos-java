package es.hibernatewebapp.util;

public class ParameterFilter {
	
	private Operator operator;
	private Object [] values;
	private String column;
	
	public ParameterFilter(String column,
			Operator operator, Object ... values) {
		super();
		this.column = column;
		this.operator = operator;
		this.values = values;
	}
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
	
	@Override
	public String toString() {
		
		StringBuilder _values = new StringBuilder();
		for(int i = 0; i < values.length ; i++){
			_values.append(values[i]).append(" ");
		}
		return column + "-"+operator+"-" + _values.toString() ;
	}
}
