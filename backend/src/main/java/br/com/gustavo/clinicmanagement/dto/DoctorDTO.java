package br.com.gustavo.clinicmanagement.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DoctorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String name;

	private Long crmNumber;

	private String phoneNumber;
	
	private String address;
	
	private String complement;
	
	private String homeNumber;
	
	private String neighborhood;

	private String cellphoneNumber;

	private String zipCode;
	
	private Set<SpecialtyDTO> specialties = new HashSet<>();
	
	public DoctorDTO() {
		
	}

	public DoctorDTO(Long id, String name, Long crmNumber, String phoneNumber, String address, String complement,
			String homeNumber, String neighborhood, String cellphoneNumber, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.crmNumber = crmNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.complement = complement;
		this.homeNumber = homeNumber;
		this.neighborhood = neighborhood;
		this.cellphoneNumber = cellphoneNumber;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCrmNumber() {
		return crmNumber;
	}

	public void setCrmNumber(Long crmNumber) {
		this.crmNumber = crmNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Set<SpecialtyDTO> getSpecialties() {
		return specialties;
	}
	
	public void setSpecialties(Set<SpecialtyDTO> specialties) {
		this.specialties = specialties;
	}
	
	

}
