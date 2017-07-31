package net.ivica.toolr.api.service;

import net.ivica.toolr.api.UserProfile;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserProfileService extends GenericService<UserProfile>, UserDetailsService {
}
