package Artha_Project;

import java.util.*;

public class Subject {
	String general;
	Map<String,Double> resultMap=new HashMap<String,Double>();
	int flag=0;
	/**
	 * 
	 */
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param general
	 * @param resultMap
	 * @param flag
	 */
	public Subject(String general, Map<String, Double> resultMap, int flag) {
		super();
		this.general = general;
		this.resultMap = resultMap;
		this.flag = flag;
	}



	/**
	 * @return the general
	 */
	public String getGeneral() {
		return general;
	}
	/**
	 * @param general the general to set
	 */
	public void setGeneral(String general) {
		this.general = general;
	}
	/**
	 * @return the resultMap
	 */
	public Map<String, Double> getResultMap() {
		return resultMap;
	}
	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map<String, Double> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}



	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}



	
	
	@Override
	public String toString() {
		return "Subject [general=" + general + ", resultMap=" + resultMap + ", flag=" + flag + "]";
	}



	public String toString(int flag) {
		if(flag==1) {
		return "| Subject | " + general + " | result | " + resultMap ;
	}
		return "| Name | " + general + " | result | " + resultMap ;

	}
	
	
}