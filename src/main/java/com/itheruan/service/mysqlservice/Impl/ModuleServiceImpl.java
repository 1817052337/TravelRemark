package com.itheruan.service.mysqlservice.Impl;

import com.itheruan.dao.msyqldao.Impl.ModuleDaoImpl;
import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;
import com.itheruan.service.mysqlservice.IModuleService;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.SerializeUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ElasticSearch
 * @description: 景点和点评所属模块和标签的业务层实现类
 * @author: YAN.YUE.SHUANG
 * @create: 2020-12-26 17:52
 **/
public class ModuleServiceImpl implements IModuleService {

    /**
     * 查询所有模块
     * @return
     */
    @Override
    public List<Travelremarkmodule> findAllModule() {
        ModuleDaoImpl moduleDao = new ModuleDaoImpl();

        Jedis jedis = JedisUtil.getJedis();
        // 获取缓存中城市集合
        List<byte[]> moduleListJ = jedis.lrange("moduleList".getBytes(), 0, -1);
        List<Travelremarkmodule> moduleList = null;
        // 2.判断查询的集合是否为空
        if (moduleListJ == null || moduleListJ.size() == 0) {
            System.out.println("从数据库查询....");
            // 3.如果为空,需要从数据库查询,在将数据存入redis
            // 3.1 从数据库查询
            moduleList = moduleDao.findAllModule();
            System.out.println(moduleList);

            // 3.2 将集合数据存储到redis中的 category的key
            for (int i = 0; i < moduleList.size(); i++) {
                Travelremarkmodule travelremarkmodule = moduleList.get(i);
                System.out.println(travelremarkmodule);
                // 将城市信息存储到redis缓冲之中
                jedis.lpush("moduleList".getBytes(), SerializeUtil.serialize(travelremarkmodule));
                //jedis.lpush("moduleList".getBytes(), SerializeUtilList.serialize(travelremarkmodule));
            }
        } else {
            System.out.println("从redis中查询.....");

            // 4.如果不为空,将set的数据存入list
            moduleList = new ArrayList<Travelremarkmodule>();
            for (byte[] bs : moduleListJ) {
                Travelremarkmodule travelremarkmodule = (Travelremarkmodule) SerializeUtil.unserialize(bs);
                moduleList.add(travelremarkmodule);
            }

        }
        return moduleList;
    }


    /**
     * 查询所有标签
     * @return
     */
    @Override
    public List<Travelremarklabel> findAllLabel() {
        ModuleDaoImpl moduleDao = new ModuleDaoImpl();

        Jedis jedis = JedisUtil.getJedis();
        // 获取缓存中城市集合
        List<byte[]> labelListJ = jedis.lrange("labelList".getBytes(), 0, -1);
        List<Travelremarklabel> labelList = null;
        // 2.判断查询的集合是否为空
        if (labelListJ == null || labelListJ.size() == 0) {
            // 3.如果为空,需要从数据库查询,在将数据存入redis
            // 3.1 从数据库查询
            labelList = moduleDao.findAllLabel();

            // 3.2 将集合数据存储到redis中的 category的key
            for (int i = 0; i < labelList.size(); i++) {
                Travelremarklabel travelremarklabel = labelList.get(i);

                // 将城市信息存储到redis缓冲之中
                jedis.lpush("labelList".getBytes(), SerializeUtil.serialize(travelremarklabel));
            }
        } else {
            // 4.如果不为空,将set的数据存入list
            labelList = new ArrayList<Travelremarklabel>();
            for (byte[] bs : labelListJ) {
                Travelremarklabel travelremarkmodule = (Travelremarklabel) SerializeUtil.unserialize(bs);
                labelList.add(travelremarkmodule);
            }

        }
        return labelList;
    }




    public static void main(String[] args) {
        List<Travelremarkmodule> allModule = new ModuleServiceImpl().findAllModule();
        System.out.println(allModule);
        System.out.println("--------------");
        List<Travelremarklabel> allLabel = new ModuleServiceImpl().findAllLabel();
        System.out.println(allLabel);
    }
}
