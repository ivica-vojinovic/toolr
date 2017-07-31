package net.ivica.toolr.dao;

import net.ivica.toolr.api.ParameterTuple;
import net.ivica.toolr.api.UserProfile;
import net.ivica.toolr.api.dao.UserProfileDao;
import org.springframework.stereotype.Repository;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractGenericDao<UserProfile> implements UserProfileDao {

    public UserProfileDaoImpl() {
        super(UserProfile.class);
    }

    @Override
    public UserProfile findUserProfileByEmail(String email) {
        return findSingleResult("user_profile_find_by_email", new ParameterTuple("email", email));
    }

}
