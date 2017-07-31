package net.ivica.toolr.api.dao;

import net.ivica.toolr.api.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile> {

    UserProfile findUserProfileByEmail(String email);

}
