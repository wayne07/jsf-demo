package de.seliger.jsf.demo;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class BeanModel {

	@Inject
	private BeanManager beanManager;
	
	public BeanModel() {
	}
	
	@SuppressWarnings("serial")
	public List<BeanInfo> getAllBeanDescriptions() {
		List<BeanInfo> descriptions = new ArrayList<BeanInfo>();
		
		for(Bean<?> bean: beanManager.getBeans(Object.class, new AnnotationLiteral<Any>(){})) {
			String beanClass = bean.getBeanClass().getCanonicalName();
			if( beanClass.startsWith("de.seliger")) {
				BeanInfo beanInfo = new BeanInfo();
				beanInfo.setClassName( beanClass);
				beanInfo.setName( bean.getName());
				Set<Annotation> qualifiers = bean.getQualifiers();
				if(!qualifiers.isEmpty()) {
					for (Annotation annotation : qualifiers) {
						beanInfo.addAnnotationName(annotation.annotationType().getSimpleName());
					}
				}
				
				beanInfo.setScope( bean.getScope().getSimpleName());
				descriptions.add(beanInfo);
			}
		}
		
		return descriptions;
	}

}
