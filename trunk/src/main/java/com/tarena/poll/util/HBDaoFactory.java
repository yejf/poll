package com.tarena.poll.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HBDaoFactory {
	private static SessionFactory factory = null;
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		ServiceRegistry service = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(service);
	}

	public static Session getSession() {
		return factory.openSession();
	}
}
