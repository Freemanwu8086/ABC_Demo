package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.Announce;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author searchingwu
 * @Description
 * @create 2022-02-15 15:20
 */
@Mapper
public interface AnnounceDAO {
    //首页展示公告
    Announce showAnnounce(Announce announce);
}
