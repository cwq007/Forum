package cn.jxau.soft.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDriver {
	@Resource(name = AdminService.SERVICENAME)
	private AdminService adminSer;

	@Test
	public void testAdminService() {
		adminSer.getAdminByLoginUser("admin");
	}
}
