package com.springapp.mvc.dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
	
	public static final String ACCOUNT_ID_FIELD_NAME = "id";
	public static final String NAME_FIELD_NAME = "name";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String DESCRIPTION_FIELD_NAME = "description";
	public static final String IS_REMOVABLE_FIELD_NAME = "isRemovable";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ACCOUNT_ID_FIELD_NAME)
	private int id;

    @Column(name = NAME_FIELD_NAME, unique = true)
	private String name;

    @Column(name = CURRENCY_FIELD_NAME)
	private String currency;

    @Column(name = DESCRIPTION_FIELD_NAME)
	private String description;
	
	public Account() {
		// needed by JPA
	}

	public Account(int id, String name, String currency, String description) {
		super();
		this.id = id;
		this.name = name;
		this.currency = currency;
		this.description = description;
	}
	
	public Account(String name, String currency, String description) {
		super();
		this.name = name;
		this.currency = currency;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return name == null ? "" : name;
	}
	
	public boolean equals(Account account) {
		return (id == account.getId());
	}

}
