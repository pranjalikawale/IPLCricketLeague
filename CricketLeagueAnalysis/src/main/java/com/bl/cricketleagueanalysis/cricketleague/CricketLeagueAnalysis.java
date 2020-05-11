package com.bl.cricketleagueanalysis.cricketleague;


import com.bl.cricketleagueanalysis.cricketenum.Cricket;
import com.bl.cricketleagueanalysis.exception.CricketLeagueAnalysisException;
import com.bl.cricketleagueanalysis.criketleagueadapter.CricketAdapterFactory;
import com.bl.cricketleagueanalysis.playerdao.PlayerDAO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalysis {
    public Map<String, PlayerDAO> cricketerMap=null;
    private Cricket.CricketLeague cricketLeague;

    public CricketLeagueAnalysis(){}

    public CricketLeagueAnalysis(Cricket.CricketLeague cricketLeague){
        this.cricketLeague=cricketLeague;
    }

    public int cricketLeagueAnalysisData(String filePath) throws CricketLeagueAnalysisException {
        if(cricketLeague==Cricket.CricketLeague.BATSMAN)
            cricketerMap= CricketAdapterFactory.getCricketLeagueAnalysisData(cricketLeague,filePath);
       else if(cricketLeague==Cricket.CricketLeague.BALLER)
            cricketerMap= CricketAdapterFactory.getCricketLeagueAnalysisData(cricketLeague,filePath);
        else
            throw new CricketLeagueAnalysisException("No data", CricketLeagueAnalysisException.ExceptionType.NO_DATA);
        return cricketerMap.size();
    }

    public <T> String getSortedData(Comparator<PlayerDAO> comparator) throws CricketLeagueAnalysisException {
        checkForListEmpty(cricketerMap);
        return arraylistInSortedOrder(comparator);
    }

    public <T> String getSortedData(String... parameter) throws CricketLeagueAnalysisException {
        checkForListEmpty(cricketerMap);
        Comparator<PlayerDAO> comparator=null;
        for(int i=0;i<=parameter.length-1;i++) {
            comparator = sortingParameter(parameter[i]);
            if(i<parameter.length-1)
                comparator = comparator.thenComparing(sortingParameter(parameter[i++]));
        }
        return arraylistInSortedOrder(comparator.reversed());
    }

    public Comparator sortingParameter(String parameter)
    {
        Comparator<PlayerDAO> comparator=null;
        switch(parameter) {
            case "average":
                comparator = Comparator.comparing(PlayerDAO::getAverage);
                break;
            case "strickrate":
                comparator = Comparator.comparing(PlayerDAO::getStrickRate);
                break;
            case "six":
                comparator = Comparator.comparing(PlayerDAO::getSix);
                break;
            case "four":
                comparator = Comparator.comparing(PlayerDAO::getFour);
                break;
            case "run":
                comparator = Comparator.comparing(PlayerDAO::getRuns);
                break;
            case "econ":
                comparator = Comparator.comparing(PlayerDAO::getEcon);
                break;
            case "5wicket":
                comparator = Comparator.comparing(PlayerDAO::getFiveW);
                break;
            case "4wicket":
                comparator = Comparator.comparing(PlayerDAO::getFourW);
                break;
            case "wickets":
                comparator = Comparator.comparing(PlayerDAO::getWkts);
                break;
        }
        return comparator;
    }
    //Check for Empty List
    private void checkForListEmpty(Map cricketerMap) throws CricketLeagueAnalysisException {
        if (cricketerMap==null || cricketerMap.size()==0){
            throw new CricketLeagueAnalysisException("No data", CricketLeagueAnalysisException.ExceptionType.NO_DATA);
        }
    }
    //Return list in sorted order
    private String arraylistInSortedOrder(Comparator <PlayerDAO> comparator){
        ArrayList playerDTO=cricketerMap.values().stream()
                .sorted(comparator)
                .map(PlayerDAO->PlayerDAO.getPlayerDTO(cricketLeague))
                .collect(Collectors.toCollection(ArrayList::new));
        return getJson(playerDTO);
    }

    //Return JSON
    private String getJson(List list) {
        String sortedJson=new Gson().toJson(list);
        return sortedJson;
    }

}
