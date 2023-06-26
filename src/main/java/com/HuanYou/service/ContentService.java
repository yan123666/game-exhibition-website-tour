package com.HuanYou.service;

import java.util.*;
import com.HuanYou.model.Ad;
import com.HuanYou.model.Game;

public interface ContentService {

    public List<Ad> getAd();

    public List<Game> getHotGame();
}
