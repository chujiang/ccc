package com.kingnod.etraining.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.kingnod.etraining.security.entity.UserAccount;

@Deprecated 
public class UserDetailsServiceDaoImp extends JdbcDaoImpl{
	
	public static final String DEF_USERS_BY_USERNAME_QUERY = "select ID, SITE_ID, EMAIL, LOGIN_NAME, PASSWORD from ORG_USER where login_name = ?";
	public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
        "select username, authority " +
        "from authorities " +
        "where username = ?";
	public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
        "select g.id, g.group_name, ga.authority " +
        "from groups g, group_members gm, group_authorities ga " +
        "where gm.username = ? " +
        "and g.id = ga.group_id " +
        "and g.id = gm.group_id";
	
	public UserDetailsServiceDaoImp() {
		super.setUsersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY);
		super.setAuthoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
		super.setGroupAuthoritiesByUsernameQuery(DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY);
	}
  
  @Override
  protected List<UserDetails> loadUsersByUsername(String username) {
    return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>() {
      public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	  Long id = rs.getLong(1);
    	  Long siteId = rs.getLong(2);
    	  String email=rs.getString(3);
          String username = rs.getString(4);
          String password = rs.getString(5);
          boolean enabled = true;
          UserAccount userDetails = new UserAccount(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
          userDetails.setId(id);
          userDetails.setSiteId(siteId);
          userDetails.setEmail(email);
          return userDetails;
      }

  });
  }
  
  protected List<GrantedAuthority> loadUserAuthorities(String username) {
      return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[] {username}, new RowMapper<GrantedAuthority>() {
          public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
              String roleName = getRolePrefix() + rs.getString(2);
              GrantedAuthorityImpl authority = new GrantedAuthorityImpl(roleName);

              return authority;
          }
      });
  }
  
  @Override
  protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
      List<GrantedAuthority> combinedAuthorities) {
    String returnUsername = userFromUserQuery.getUsername();

    if (!isUsernameBasedPrimaryKey()) {
        returnUsername = username;
    }
    UserAccount tmpUserDetails = (UserAccount)userFromUserQuery;
    UserAccount userDetails = new UserAccount(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), true, true, true, combinedAuthorities);
    userDetails.setId(tmpUserDetails.getId());
    userDetails.setSiteId(tmpUserDetails.getSiteId());
    userDetails.setEmail(tmpUserDetails.getEmail());
    return userDetails;
  }
}
