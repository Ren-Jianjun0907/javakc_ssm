package com.zhg.javakc.modules.test.service;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.modules.test.dao.TestDao;
import com.zhg.javakc.modules.test.entity.Testentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :任建军
 * @date: 2019/11/19
 **/
@Service
public class TestService extends BaseService<TestDao, Testentity> {
    @Autowired
    private TestDao testDao;

    public Page<Testentity> queryTest(Testentity testentity, Page page) {
//        设置分页参数，才会被mybatis分页插件所识别，拦截SQL，在其前后加入分页SQL语句
        testentity.setPage(page);
//        根据分页与查询条件进行测试数据的查询
        List<Testentity> testList = testDao.findList(testentity);
        //将查询数据设置到分页类的List集合当中，一起返回
        page.setList(testList);
        return page;

    }
}
