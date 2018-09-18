package org.arati.javaproject.messengers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arati.javaproject.messengers.database.DatabaseClass;
import org.arati.javaproject.messengers.model.Profile;

public class ProfileService {

	private Map<String ,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Arati" , new Profile(1L, "Arati", "Arati", "Mishra" ));
		profiles.put("Piyush" , new Profile(2L, "Piyush", "Piyush", "Dubey" ));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfiles(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile ) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile reomoveProfile(String profileName){
		return profiles.remove(profileName);
	}
	
}
