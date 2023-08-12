package com.example.bundesligamatch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class ResponseStanding{

	@SerializedName("table")
	private List<TableItem> table;

	public List<TableItem> getTable(){
		return table;
	}
}