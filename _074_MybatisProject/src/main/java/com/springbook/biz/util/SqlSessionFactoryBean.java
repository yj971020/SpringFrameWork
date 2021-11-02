package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory=null;
	//static 블록으로 초기화
	static {
		try {
			if(sessionFactory==null) {
				Reader reader=Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory= new SqlSessionFactoryBuilder().build(reader);			
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
		
	}

}
