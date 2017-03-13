package com.track.courier.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Parcels")
public class Courier implements Serializable {

	private static final long serialVersionUID = -3420553989668720778L;

	@Id
	@NotBlank(message = "Parcel Id cannot be empty")
	private String parcelId;

	@NotBlank(message = "From person name cannot be empty")
	private String fromPersonName;

	@NotBlank(message = "To person name cannot be empty")
	private String toPersonName;

	private String color;

	@NotNull(message = "Weight cannot be empty")
	private Float weight;

	@NotNull(message = "Service price cannot be empty")
	private Float servicePrice;

	@NotBlank(message = "Dispatched on cannot be empty")
	private String dispatchedOn;

	@NotBlank(message = "Expected delivery cannot be empty")
	private String expectedDelivery;

	@NotBlank(message = "Sender address cannot be empty")
	private String senderAddress;

	@NotBlank(message = "Receiver address cannot be empty")
	private String receiverAddress;

	@NotBlank(message = "Current location cannot be empty")
	private String currentLocationLat;

	@NotBlank(message = "Current location cannot be empty")
	private String currentLocationLong;

	private String senderPhoneNo;

	@NotBlank(message = "Receiver phone cannot be empty")
	private String receiverPhoneNo;
	
	@NotBlank(message = "Status cannot be empty")
	private String status;
	

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

	public String getToPersonName() {
		return toPersonName;
	}

	public void setToPersonName(String toPersonName) {
		this.toPersonName = toPersonName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Float servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getDispatchedOn() {
		return dispatchedOn;
	}

	public void setDispatchedOn(String dispatchedOn) {
		this.dispatchedOn = dispatchedOn;
	}

	public String getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(String expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getCurrentLocationLat() {
		return currentLocationLat;
	}

	public void setCurrentLocationLat(String currentLocationLat) {
		this.currentLocationLat = currentLocationLat;
	}

	public String getCurrentLocationLong() {
		return currentLocationLong;
	}

	public void setCurrentLocationLong(String currentLocationLong) {
		this.currentLocationLong = currentLocationLong;
	}

	public String getSenderPhoneNo() {
		return senderPhoneNo;
	}

	public void setSenderPhoneNo(String senderPhoneNo) {
		this.senderPhoneNo = senderPhoneNo;
	}

	public String getReceiverPhoneNo() {
		return receiverPhoneNo;
	}

	public void setReceiverPhoneNo(String receiverPhoneNo) {
		this.receiverPhoneNo = receiverPhoneNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	Courier() {
	}
}
