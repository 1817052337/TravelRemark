package com.itheruan.dao.msyqldao.Impl;

import com.itheruan.dao.msyqldao.IModuleDao;
import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.Province;
import com.itheruan.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @program: ElasticSearch
 * @description:景点和点评所属模块和标签的持久层实现类
 * @author: YAN.YUE.SHUANG
 * @create: 2020-12-26 17:55
 **/
public class ModuleDaoImpl implements IModuleDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有模块
     * @return
     */
    @Override
    public List<Travelremarkmodule> findAllModule() {
        String sql = "select * from travelremarkmodule ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Travelremarkmodule.class));
    }


    /**
     * 查询所有标签
     * @return
     */
    @Override
    public List<Travelremarklabel> findAllLabel() {
        String sql = "select * from travelremarklabel ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Travelremarklabel.class));
    }


}
