package com.HuanYou.service;

import java.util.List;
import com.HuanYou.model.Game;

public interface GameService {

    public List<Game> getGameList();

    public List<Game> getCategory(String category);

    public List<Game> gameSearch(String searchText);

    public int gameAdd(Game game);

    public int gameDelete(int gameID);
}
