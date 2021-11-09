package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@OneToOne(targetEntity =FurnitureUser .class, cascade = CascadeType.MERGE)
	private FurnitureUser furnitureuser;
	@Column(name = "name", nullable = false, length = 20)
	//@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 30, message = "Name should be less than or equal to 20 characters")
	//@NotBlank(message = "Name should not be blank")
	private String name;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "addressid", referencedColumnName = "addressId")
	private Address address;

	@Column(name = "contactno", unique = true, nullable = false, length = 10)
	//@Pattern(regexp = "^[6|7|8|9]{1}[0-9]{9}$")
	@Size(max = 10, message = "Contact number must be 10 numbers")
	private String contactNo;

	@Column(name = "email", unique = true, nullable = false, length = 25)
	//@Pattern(regexp = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")
	@Size(max = 25, message = "Email should have be valid")
	private String email;
	


	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public FurnitureUser getFurnitureuser() {
		return furnitureuser;
	}

	public void setFurnitureuser(FurnitureUser furnitureuser) {
		this.furnitureuser = furnitureuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", furnitureuser=" + furnitureuser + ", name=" + name + ", address=" + address
				+ ", contactNo=" + contactNo + ", email=" + email + "]";
	}

	

	

}

