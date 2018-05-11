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
@Table(name = "label_info", schema = "crawler", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "project_name", "username", "labeled_simple_data_id" }) })
@SequenceGenerator(name = "common_sequence", sequenceName = "common_sequence", allocationSize = 1)
public class LabelInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	@Column(name = "username")
	private String username;

	@Column(name = "project_name")
	private String projectName;

	@ManyToOne
	@JoinColumn(name = "labeled_simple_data_id")
	private LabeledSimpleData labeledSimpleDataId;

	@Column(name = "label")
	private String label;

	@Column(name = "labeled_date")
	private Date labeledDate;

	@Column(name = "data_created_date")
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getLabeledDate() {
		return labeledDate;
	}

	public void setLabeledDate(Date labeledDate) {
		this.labeledDate = labeledDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataCreatedDate() {
		return dataCreatedDate;
	}

	public void setDataCreatedDate(Date dataCreatedDate) {
		this.dataCreatedDate = dataCreatedDate;
	}

	public LabeledSimpleData getLabeledSimpleDataId() {
		return labeledSimpleDataId;
	}

	public void setLabeledSimpleDataId(LabeledSimpleData labeledSimpleDataId) {
		this.labeledSimpleDataId = labeledSimpleDataId;
	}

}