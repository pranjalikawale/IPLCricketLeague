package com.bl.cricketleagueanalysis.criketleagueadapter;

import com.bl.cricketleagueanalysis.exception.CricketLeagueAnalysisException;
import com.bl.cricketleagueanalysis.playerdao.PlayerDAO;

import java.util.Map;


public class CricketAdapter extends CricketAdapterAbstract
{
    public Map<String, PlayerDAO> loadedCricketAnalysisData(String filePath,Class classType )
                                                            throws CricketLeagueAnalysisException{
        return super.cricketAnalysisData(filePath,classType);
    }
}
