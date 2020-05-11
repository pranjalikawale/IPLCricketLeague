package com.bl.cricketleagueanalysis.playerdao;

import com.bl.cricketleagueanalysis.cricketenum.Cricket;
import com.bl.cricketleagueanalysis.model.BallerCSV;
import com.bl.cricketleagueanalysis.model.BatsManCSV;

public class PlayerDAO {

    public int fiveW;
    public int fourW;
    public double econ;
    public int bbi;
    public int wkts;
    public double over;
    public int six;
    public int four;
    public int halfCentury;
    public int century;
    public double sr;
    public int bf;
    public double avg;
    public String hs;
    public int runs;
    public int no;
    public int inns;
    public int match;
    public String player;
    public int pos;

    public PlayerDAO(BatsManCSV batsManCsv){
        this.pos=batsManCsv.pos;
        this.player=batsManCsv.player;
        this.match=batsManCsv.match;
        this.inns=batsManCsv.inns;
        this.no=batsManCsv.no;
        this.runs=batsManCsv.runs;
        this.hs=batsManCsv.hs;
        this.avg=batsManCsv.avg;
        this.bf=batsManCsv.bf;
        this.sr=batsManCsv.sr;
        this.century=batsManCsv.century;
        this.halfCentury=batsManCsv.halfCentury;
        this.four=batsManCsv.four;
        this.six=batsManCsv.six;
    }

    public PlayerDAO(BallerCSV ballerCsv){
        this.pos=ballerCsv.pos;
        this.player=ballerCsv.player;
        this.match=ballerCsv.match;
        this.inns=ballerCsv.inns;
        this.over=ballerCsv.over;
        this.runs=ballerCsv.runs;
        this.wkts=ballerCsv.wkts;
        this.bbi=ballerCsv.bbi;
        this.avg=ballerCsv.avg;
        this.econ=ballerCsv.econ;
        this.sr=ballerCsv.sr;
        this.fourW=ballerCsv.fourW;
        this.fiveW=ballerCsv.fiveW;

    }

    public int getSix() {
        return six;
    }
    public int getFour(){
        return four;
    }

    public double getStrickRate() {
        return sr;
    }

    public double getAverage() {
        return avg;
    }

    public int getRuns() {
        return runs;
    }

    public double getEcon() {
        return econ;
    }

    public int getFiveW() {
        return fiveW;
    }

    public int getFourW() {
        return fourW;
    }

    public int getWkts() {
        return wkts;
    }

    public  Object getPlayerDTO(Cricket.CricketLeague cricketLeague) {
        if (cricketLeague.equals(Cricket.CricketLeague.BATSMAN))
            return new BatsManCSV(pos, player, match, inns, no, runs, hs, avg, bf, sr, century, halfCentury, four, six);
        return new BallerCSV(pos,player,match,inns,over,runs,wkts,bbi,avg,econ,sr,fourW,fiveW);
    }


}
