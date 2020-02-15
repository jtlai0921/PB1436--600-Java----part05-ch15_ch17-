/**
 * @jdk版本:1.6
 * @寫程式時間:2010-3-20
 */
package com.mingrisoft.entity;

import java.util.Map;

/**
 * @author bwm
 * 
 */
public class BookPrice {

	// 屬性名稱和屬性值列表
	private Map<String, String> attributeMap;
	// 價格值
	private Double value;

	public Map<String, String> getAttributeMap() {
		return this.attributeMap;
	}

	public void setAttributeMap(Map<String, String> attributeMap) {
		this.attributeMap = attributeMap;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[atrributes=" + this.attributeMap + "\n");
		buffer.append("vlaue=" + this.value + "\n]");
		return buffer.toString();
	}
}
