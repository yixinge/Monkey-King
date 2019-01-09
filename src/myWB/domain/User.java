package myWB.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
public class User implements Serializable {

	private static final long serialVersionUID = -5655247310739937715L;
	
	private Integer id;			// id
	
	@NotNull
	@Size(min=2,max=9,message="{username.size}")
	private String username;	// 用户名
	@NotNull
	@Size(min=2,max=9,message="{loginname.size}")
	private String loginname;	// 登录名
	@NotNull
	@Size(min=2,max=9,message="{password.size}")
	private String password;	// 密码
	private Integer status;		// 状态
	private Date createDate;	// 建档日期
	// 无参数构造器
	public User() {
		super();
	}
	// setter和getter方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginname="
				+ loginname + ", password=" + password + ", status=" + status
				+ ", createDate=" + createDate + "]";
	}
	
	
}
