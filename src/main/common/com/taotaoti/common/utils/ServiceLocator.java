package com.taotaoti.common.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.mail.javamail.JavaMailSender;

public class ServiceLocator {

	private static ServiceLocator locator = null;

	private BeanFactory factory = null;

	private ServiceLocator() {
	}

	public void setFactory(BeanFactory factory) {
		this.factory = factory;
	}

	public static ServiceLocator getInstance() {
		if (locator == null) {
			locator = new ServiceLocator();
		}
		return locator;
	}

	public JavaMailSender getJavaMailSender() {
		return (JavaMailSender) factory.getBean("mailSender");
	}
	
}
