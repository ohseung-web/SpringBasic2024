package com.green.member03.dto;

public class Member03DTO {

	private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberMobile;
    
    public Member03DTO() {}
    public Member03DTO(Long id, String memberEmail, String memberPassword,
    		String memberName, int memberAge, String memberMobile) {
    	this.id = id;
    	this.memberEmail = memberEmail;
    	this.memberPassword = memberPassword;
    	this.memberName = memberName;
    	this.memberAge = memberAge;
    	this.memberMobile = memberMobile;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberMobile() {
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}
    
    
}
