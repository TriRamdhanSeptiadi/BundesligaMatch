package com.example.bundesligamatch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class ResponseMatch{

	@SerializedName("events")
	private List<EventsItem> events;

	public List<EventsItem> getEvents(){
		return events;
	}
}