package com.HuanYou.service.impl;

import com.HuanYou.model.Game;
import com.HuanYou.service.GameService;
import com.HuanYou.dao.GameDao;

import java.util.List;

public class GameServiceImpl implements GameService {
    GameDao gameDao = new GameDao();
    @Override
    public List<Game> getGameList() {
        return gameDao.findAll();
    }

    public List<Game> getCategory(String category){
        return gameDao.findCategory(category);
    }

    public List<Game> gameSearch(String searchText){
        return gameDao.findText(searchText);
    }

    public int gameAdd(Game game){return gameDao.insert(game);}

    public int gameDelete(int gameID){return gameDao.delete(gameID);}
}
