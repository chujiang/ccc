package com.kingnod.etraining.security.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.kingnod.core.entity.IdEntity;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.organization.entity.UserGroup;

/**
 * 扩展SpringSecurity中的UserDetails对象，增加系统所必须的一些帐户信息。
 * @author Sam
 *
 */
public class UserAccount extends User implements IdEntity<Long> {

	private static final long serialVersionUID = -8317882881499613858L;
	
	public static final String ROLE = "_roles_";
	
	public static final String GROUP = "_group_";
	
	/**
	 * 当前帐户ID
	 */
	protected Long id;
	
	/**
	 * 当前帐户所属的站点ID
	 */
	private Long siteId;
	
	private int clientScreenWidth = 1024;
	
	private int clientScreenHeight = 768;
	
	/**
	 * 当前帐户的邮箱
	 */
	private String email;
	
	/**
	 * 用户帐户的角色 信息
	 */
	private Collection<Role> roles;
	
	/**
	 * 用户所属的用户组信息
	 */
	private Collection<UserGroup> groups;
	
	/**
	 * 用户的姓名全名
	 */
	private String fullName;
	
	/**
	 * 站点名称（登录时填的短名称，非中文名称）
	 */
	private String siteName;

	private Map<String, Serializable> attributes = new HashMap<String, Serializable>();

	public UserAccount(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAttribute(String key, Serializable value) {
		attributes.put(key, value);
	}

	public Object getAttribute(String key) {
		if (attributes.containsKey(key)) {
			return attributes.get(key);
		} else {
			return null;
		}
	}

	public void removeAttribute(String key) {
		if (attributes.containsKey(key)) {
			attributes.remove(key);
		}
	}
	
    public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Collection<UserGroup> groups) {
		this.groups = groups;
	}

	/**
     * Returns {@code true} if the supplied object is a {@code User} instance with the
     * same {@code username} value.
     * <p>
     * In other words, the objects are equal if they have the same username, representing the
     * same principal.
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof UserAccount) {
            return this.getUsername().equals(((UserAccount) rhs).getUsername());
        }
        return false;
    }

    /**
     * Returns the hashcode of the {@code username}.
     */
    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Username: ").append(this.getUsername()).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Enabled: ").append(this.isEnabled()).append("; ");
        sb.append("AccountNonExpired: ").append(this.isAccountNonExpired()).append("; ");
        sb.append("credentialsNonExpired: ").append(this.isCredentialsNonExpired()).append("; ");
        sb.append("AccountNonLocked: ").append(this.isAccountNonLocked()).append("; ");

        if (!this.getAuthorities().isEmpty()) {
            sb.append("Granted Authorities: ");

            boolean first = true;
            for (GrantedAuthority auth : this.getAuthorities()) {
                if (!first) {
                    sb.append(",");
                }
                first = false;

                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public int getClientScreenWidth() {
		return clientScreenWidth;
	}

	public void setClientScreenWidth(int clientScreenWidth) {
		this.clientScreenWidth = clientScreenWidth;
	}

	public int getClientScreenHeight() {
		return clientScreenHeight;
	}

	public void setClientScreenHeight(int clientScreenHeight) {
		this.clientScreenHeight = clientScreenHeight;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteName() {
		return siteName;
	}

}
