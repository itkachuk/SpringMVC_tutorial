package com.springapp.mvc.dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "Category", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "isExpense" }))
public class Category {
	public static final String CATEGORY_ID_FIELD_NAME = "id";
	public static final String NAME_FIELD_NAME = "name";
	public static final String IS_EXPENSE_FIELD_NAME = "isExpense";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CATEGORY_ID_FIELD_NAME)
	private int id;

    @Column(name = NAME_FIELD_NAME)
	private String name;

    @Column(name = IS_EXPENSE_FIELD_NAME)
	private boolean isExpense; // Expense - true, Income - false
	
	public Category() {
		// needed by JPA
	}

	public Category(int id, String name, boolean isExpense) {
		super();
		this.id = id;
		this.name = name;
		this.isExpense = isExpense;
	}
	
	public Category(String name, boolean isExpense) {
		super();
		this.name = name;
		this.isExpense = isExpense;
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

	public boolean isExpense() {
		return isExpense;
	}

	public void setExpense(boolean isExpense) {
		this.isExpense = isExpense;
	}

	@Override
	public String toString() {
		return name == null ? "" : name;
	}

	public boolean equals(Category category) {
		return (id == category.getId());
	}
}
