package com.HuanYou.service.impl;

import com.HuanYou.model.Ad;
import com.HuanYou.model.Game;
import com.HuanYou.service.ContentService;
import com.HuanYou.dao.ContentDao;

import java.util.List;

public class ContentServiceImpl implements ContentService {
    ContentDao contentDao = new ContentDao();
    @Override
    public List<Ad> getAd() {
        return contentDao.getAd();
    }
    public List<Game> getHotGame(){
        return contentDao.getHotGame();
    }
}
