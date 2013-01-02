package de.seliger.jsf.demo;

public class BeanInfo {

	private String beanClass;
	private String name;
	private String scope;
	private String annotations = "";

	public void setClassName(String beanClass) {
		this.beanClass = beanClass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public String getName() {
		return name;
	}

	public String getScope() {
		return scope;
	}

	public void addAnnotationName(String annotationName) {
		if(annotations.length() > 0) {
			annotations+= ", "+annotationName;
		} else {
			annotations= annotationName;
		}
	}

	public String getAnnotations() {
		return annotations;
	}

}
