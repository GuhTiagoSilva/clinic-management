package br.com.gustavo.clinicmanagement.entities;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_doctor")
@SQLDelete(sql = "UPDATE tb_doctor SET is_active=false WHERE id=?")
@Where(clause = "is_active = true")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank(message = "Name is required")
	@Column(name = "nm_doctor")
	private String name;

	@NotNull
	@NotBlank(message = "CRM Number is required")
	@Column(name = "nr_crm")
	private String crmNumber;

	@NotNull
	@NotBlank(message = "Phone number is required")
	@Column(name = "nr_phone")
	private String phoneNumber;

	@NotNull
	@NotBlank(message = "Address is required")
	@Column(name = "ds_address")
	private String address;

	@Column(name = "ds_complement")
	private String complement;

	@NotNull
	@NotBlank(message = "Home number is required")
	@Column(name = "nr_home")
	private Integer homeNumber;

	@NotNull
	@NotBlank(message = "Neighborhood is required")
	@Column(name = "ds_neighborhood")
	private String neighborhood;

	@NotNull
	@NotBlank(message = "CellPhone is required")
	@Column(name = "nr_cellphone")
	private String cellphoneNumber;

	@NotNull
	@NotBlank(message = "Zip code is required")
	@Column(name = "nr_zipcode")
	private String zipCode;

	private Boolean isActive;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_doctor_specialty", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	@NotNull
	private Set<Specialty> specialties = new HashSet<>();

	public Doctor() {

	}

	public Doctor(Long id, String name, String crmNumber, String phoneNumber, String address, String complement,
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

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
