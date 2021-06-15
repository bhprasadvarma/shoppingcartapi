/**
 * 
 */
package com.varma.main.entity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Varma
 *
 */
@Component
public class CartProduct {
	String id;
	String countryCode;
	String currency;
	Date created;
	Date updated;
	List<Product> product;
	
	/**
	 * 
	 */
	public CartProduct() {
		
	}
	/**
	 * @param id
	 * @param countryCode
	 * @param currency
	 * @param created
	 * @param updated
	 * @param product
	 */
	public CartProduct(String id, String countryCode, String currency, Date created, Date updated, List<Product> product) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.currency = currency;
		this.created = created;
		this.updated = updated;
		this.product = product;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CartProduct)) {
			return false;
		}
		CartProduct other = (CartProduct) obj;
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!created.equals(other.created)) {
			return false;
		}
		if (currency == null) {
			if (other.currency != null) {
				return false;
			}
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (updated == null) {
			if (other.updated != null) {
				return false;
			}
		} else if (!updated.equals(other.updated)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Cart [" + (id != null ? "id=" + id + ", " : "")
				+ (countryCode != null ? "countryCode=" + countryCode + ", " : "")
				+ (currency != null ? "currency=" + currency + ", " : "")
				+ (created != null ? "created=" + created + ", " : "")
				+ (updated != null ? "updated=" + updated + ", " : "") + (product != null ? "product=" + product : "")
				+ "]";
	}
		
}
