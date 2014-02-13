package com.taotaoti.common.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.taotaoti.common.generic.bo.BaseObject;
import com.taotaoti.common.generic.dao.impl.GenericDao;

/**
 * 
 * @author liulxiang
 */
public abstract class AbstractDao<KEY extends Serializable, ENTITY extends BaseObject<KEY>> extends GenericDao<KEY, ENTITY> {
	
	@Override
	@Resource(name = "dynamicJdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}
	public AbstractDao() {
		super();
	}
	public ENTITY get(KEY id){
		@SuppressWarnings("unchecked")
		List<ENTITY> entities = get(Arrays.asList(id));
		if(CollectionUtils.isEmpty(entities)){
			return null;
		}
		return entities.get(0);
	}
}
