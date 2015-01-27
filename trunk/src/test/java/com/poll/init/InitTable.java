package com.poll.init;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class InitTable {
	@Test
	public void testDDL() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SchemaExport ex = new SchemaExport(cfg);
		ex.create(true, true);
	}

	
}
