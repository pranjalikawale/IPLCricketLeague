package com.bl.cricketleagueanalysis.model;

import com.opencsv.bean.CsvBindByName;

public class BatsManCSV {

    @CsvBindByName(column = "POS",required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER",required = true)
    public String player;

    @CsvBindByName(column = "Mat",required = true)
    public int match;

    @CsvBindByName(column = "Inns",required = true)
    public int inns;

    @CsvBindByName(column = "NO",required = true)
    public int no;

    @CsvBindByName(column = "Runs",required = true)
    public int runs;

    @CsvBindByName(column = "HS",required = true)
    public String hs;

    @CsvBindByName(column = "Avg",required = true)
    public double avg;

    @CsvBindByName(column = "BF",required = true)
    public int bf;

    @CsvBindByName(column = "SR",required = true)
    public double sr;

    @CsvBindByName(column = "100",required = true)
    public int century;

    @CsvBindByName(column = "50",required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s",required = true)
    public int four;

    @CsvBindByName(column = "6s",required = true)
    public int six;

    public BatsManCSV(){}

    public BatsManCSV(int pos, String player, int match, int inns, int no, int runs, String hs
            , double avg, int bf, double sr, int century, int halfCentury, int four, int six) {
        this.pos=pos;
        this.player=player;
        this.match=match;
        this.inns=inns;
        this.no=no;
        this.runs=runs;
        this.hs=hs;
        this.avg=avg;
        this.bf=bf;
        this.sr=sr;
        this.century=century;
        this.halfCentury=halfCentury;
        this.four=four;
        this.six=six;
    }
}
