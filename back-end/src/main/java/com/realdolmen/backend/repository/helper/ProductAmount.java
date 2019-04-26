package com.realdolmen.backend.repository.helper;

import com.realdolmen.backend.domain.Product;

public class ProductAmount {

	private Product product;
	private long amount;

	public ProductAmount()
	{}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ProductAmount(Product product,long amount)
	{
		this.amount=amount;
		this.product=product;
	}
}
