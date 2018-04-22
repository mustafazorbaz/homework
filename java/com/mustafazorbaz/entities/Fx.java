package com.mustafazorbaz.entities;

import java.util.ArrayList;
import java.util.List;

public class Fx {
	private List<Merchant>merchant =new ArrayList<>();

	public List<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}
	public void addMerchant(Merchant merchant) {
		this.merchant.add(merchant);
	}
}
