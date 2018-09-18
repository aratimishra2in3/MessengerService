package org.arati.javaproject.messengers.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arati.javaproject.messengers.model.Profile;
import org.arati.javaproject.messengers.service.ProfileService;


@Path("/profile")


public class ProfileResourse {
	
	
private ProfileService profileService=new ProfileService();

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Profile> getProfile(){
	return profileService.getAllProfiles();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
public Profile addProfile(Profile profile) {
	return profileService.addProfile(profile);
}

@PUT
@Path("/{profileName}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
	profile.setProfileName(profileName);
	return profileService.updateProfile(profile);
}

@DELETE
@Path("/{profileName}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public void deleteProfile(@PathParam("profileName") String profileName){
	profileService.reomoveProfile(profileName);
}

@GET
@Path("/{profileName}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public Profile getProfile(@PathParam("profileName") String profileName) {
	return profileService.getProfiles(profileName);
}

}
