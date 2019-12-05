package com.cts.authenticationservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {
	@Id
	@Column(name = "user_id")
	String userId;
	@Column(name = "first_name")
	String firstname;
	@Column(name = "last_name")
	String lastname;
	@Column(name = "age")
	int age;
	@Column(name = "gender")
	String gender;
	@Column(name = "contact_number")
	long contact;
	@Column(name = "password")
	String password;
	@Column(name = "user_type")
	String userType;
	@Column(name="status")
	String status;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_info_user_id"), inverseJoinColumns = @JoinColumn(name = "role_role_id"))
	private Set<Role> roleList;

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "fav_us_id"), inverseJoinColumns = @JoinColumn(name = "fav_mo_id"))
	private Set<Movie> movieList;

	public Set<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<Movie> movieList) {
		this.movieList = movieList;
	}*/

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contactNumber) {
		this.contact = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstname + ", lastName=" + lastname + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contact + ", password=" + password + ", userType="
				+ userType + ", status=" + status + "]";
	}
}

