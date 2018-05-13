package org.ytu.kemik.data.label.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "label_info", schema = "label", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "username", "labeled_simple_data_id" }) })
@SequenceGenerator(name = "common_sequence", sequenceName = "common_sequence", allocationSize = 1)
public class LabelInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "username")
	private String username;

	@ManyToOne
	@JoinColumn(name = "labeled_simple_data_id")
	private LabeledSimpleData labeledSimpleData;

	@Column(name = "label")
	private String label;

	@Column(name = "created_date")
	private Date dataCreatedDate;

	public LabelInfo() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCreatedDate() {
		return dataCreatedDate;
	}

	public void setDataCreatedDate(Date dataCreatedDate) {
		this.dataCreatedDate = dataCreatedDate;
	}

	public LabeledSimpleData getLabeledSimpleData() {
		return labeledSimpleData;
	}

	public void setLabeledSimpleData(LabeledSimpleData labeledSimpleData) {
		this.labeledSimpleData = labeledSimpleData;
	}

}