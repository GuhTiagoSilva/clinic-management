package br.com.gustavo.clinicmanagement.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.gustavo.clinicmanagement.entities.Doctor;

public class DoctorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String crmNumber;

	private String phoneNumber;

	private String address;

	private String complement;

	private Integer homeNumber;

	private String neighborhood;

	private String cellphoneNumber;

	private String zipCode;

	private Set<SpecialtyDTO> specialties = new HashSet<>();

	public DoctorDTO() {

	}

	public DoctorDTO(Long id, String name, String crmNumber, String phoneNumber, String address, String complement,
			Integer homeNumber, String neighborhood, String cellphoneNumber, String zipCode) {
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

	public DoctorDTO(Doctor doctor) {
		this.id = doctor.getId();
		this.address = doctor.getAddress();
		this.cellphoneNumber = doctor.getCellphoneNumber();
		this.complement = doctor.getComplement();
		this.crmNumber = doctor.getCrmNumber();
		this.homeNumber = doctor.getHomeNumber();
		this.name = doctor.getName();
		this.neighborhood = doctor.getNeighborhood();
		this.phoneNumber = doctor.getPhoneNumber();
		this.zipCode = doctor.getZipCode();
		doctor.getSpecialties().forEach(specialty -> this.getSpecialties().add(new SpecialtyDTO(specialty)));
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

	public String getCrmNumber() {
		return crmNumber;
	}

	public void setCrmNumber(String crmNumber) {
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

	public Integer getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(Integer homeNumber) {
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
