package com.poitest.service.impl;

import com.poitest.dao.PoiTestDao;
import com.poitest.dao.impl.PoiTestDaoImpl;
import com.poitest.service.PoiTestService;

public class PoiTestServiceImpl implements PoiTestService{

	@Override
	public String login(String username) {
		PoiTestDao poiTestDao = new PoiTestDaoImpl();
		String name = poiTestDao.login(username);
		return name;
	}

}
