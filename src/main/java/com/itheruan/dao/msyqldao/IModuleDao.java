package com.itheruan.dao.msyqldao;

import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;

import java.util.List;

/**
 * @program: ElasticSearch
 * @description: 景点和点评所属模块和标签的持久层接口
 * @author: YAN.YUE.SHUANG
 * @create: 2020-12-26 17:52
 **/
public interface IModuleDao {

    /**
     * 查询所有模块
     * @return
     */
    List<Travelremarkmodule> findAllModule();

    /**
     * 查询所有标签
     * @return
     */
    List<Travelremarklabel> findAllLabel();

}
