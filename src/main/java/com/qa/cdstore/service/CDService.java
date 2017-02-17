package com.qa.cdstore.service;

public interface CDService {

	public String getAllCds();

	String addNewCd(String cdJson);

	String replaceCd(Integer cdId, String updatedCd);

	String deleteCd(Integer cdId);

}