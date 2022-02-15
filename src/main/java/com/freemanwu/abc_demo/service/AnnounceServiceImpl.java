package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.AnnounceDAO;
import com.freemanwu.abc_demo.entity.Announce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author searchingwu
 * @Description
 * @create 2022-02-15 15:22
 */
@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Autowired
    private AnnounceDAO announceDAO;
    @Override
    public Announce showAnnounce(Announce announce) {
        return announceDAO.showAnnounce(announce);
    }
}
