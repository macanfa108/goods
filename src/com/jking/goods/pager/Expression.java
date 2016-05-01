package com.jking.goods.pager;
/**
 *  封装查询条件
 *  name  条件  value 
 * @author joker
 *
 */
public class Expression {
	
	private String name ;         //列名
	private String operator ;    //条件
	private String value ;		  //值
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Expression(){
		
	}
	public Expression(String name, String operator, String value) {
		super();
		this.name = name;
		this.operator = operator;
		this.value = value;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Expression [name=" + name + ", operator=" + operator
				+ ", value=" + value + "]";
	}
}
