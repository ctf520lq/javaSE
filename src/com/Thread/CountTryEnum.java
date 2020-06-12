package com.Thread;

public enum CountTryEnum {

	ONE(1,"齐"),Tow(2,"楚"),THREE(3,"燕"),Four(4,"赵"),five(5,"魏"),six(6,"韩");
	
	private Integer retCode;
	private String retMessage;
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getRetMessage() {
		return retMessage;
	}
	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	
	CountTryEnum(Integer reCode,String retMessage){
		this.retCode = reCode;
		this.retMessage = retMessage;
	}
	public static CountTryEnum forEach_CountryEnum(int index) {
		CountTryEnum[] myArray = CountTryEnum.values();
		for(CountTryEnum eleEnum : myArray) {
			if(index == eleEnum.getRetCode()) {
				return eleEnum;
			}
		}
		return null;
	}
}
