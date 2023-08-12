package com.example.bundesligamatch.model;

import com.google.gson.annotations.SerializedName;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class TableItem{

	@SerializedName("strTeam")
	private String strTeam;

	@SerializedName("intGoalsAgainst")
	private String intGoalsAgainst;

	@SerializedName("intPoints")
	private String intPoints;

	@SerializedName("intGoalDifference")
	private String intGoalDifference;

	@SerializedName("intGoalsFor")
	private String intGoalsFor;

	@SerializedName("intPlayed")
	private String intPlayed;

	@SerializedName("idTeam")
	private String idTeam;

	@SerializedName("strTeamBadge")
	private String strTeamBadge;

	@SerializedName("dateUpdated")
	private String dateUpdated;

	@SerializedName("strDescription")
	private String strDescription;

	@SerializedName("strForm")
	private String strForm;

	@SerializedName("idStanding")
	private String idStanding;

	@SerializedName("intDraw")
	private String intDraw;

	@SerializedName("intRank")
	private String intRank;

	@SerializedName("intLoss")
	private String intLoss;

	@SerializedName("strLeague")
	private String strLeague;

	@SerializedName("intWin")
	private String intWin;

	@SerializedName("idLeague")
	private String idLeague;

	@SerializedName("strSeason")
	private String strSeason;

	public String getStrTeam(){
		return strTeam;
	}

	public String getIntGoalsAgainst(){
		return intGoalsAgainst;
	}

	public String getIntPoints(){
		return intPoints;
	}

	public String getIntGoalDifference(){
		return intGoalDifference;
	}

	public String getIntGoalsFor(){
		return intGoalsFor;
	}

	public String getIntPlayed(){
		return intPlayed;
	}

	public String getIdTeam(){
		return idTeam;
	}

	public String getStrTeamBadge(){
		return strTeamBadge;
	}

	public String getDateUpdated(){
		return dateUpdated;
	}

	public String getStrDescription(){
		return strDescription;
	}

	public String getStrForm(){
		return strForm;
	}

	public String getIdStanding(){
		return idStanding;
	}

	public String getIntDraw(){
		return intDraw;
	}

	public String getIntRank(){
		return intRank;
	}

	public String getIntLoss(){
		return intLoss;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public String getIntWin(){
		return intWin;
	}

	public String getIdLeague(){
		return idLeague;
	}

	public String getStrSeason(){
		return strSeason;
	}
}