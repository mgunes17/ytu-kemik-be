package org.ytu.kemik.data.label.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "labeled_simple_data", schema = "label")
@SequenceGenerator(name = "common_sequence", sequenceName = "common_sequence", allocationSize = 1)
public class LabeledSimpleData {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	@Column(name = "id_from_source")
	private String idFromSource;

	@Column(name = "source_type")
	private String sourceType;

	@Column(name = "content")
	private String content;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "label")
	private String label;

	@Column(name = "is_certain")
	private boolean isCertain;

	@Column(name = "labeled_date")
	private Date labeledDate;

	@Column(name = "data_created_date")
	private Date dataCreatedDate;

	public LabeledSimpleData() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdFromSource() {
		return idFromSource;
	}

	public void setIdFromSource(String idFromSource) {
		this.idFromSource = idFromSource;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCertain() {
		return isCertain;
	}

	public void setCertain(boolean isCertain) {
		this.isCertain = isCertain;
	}

	public Date getLabeledDate() {
		return labeledDate;
	}

	public void setLabeledDate(Date labeledDate) {
		this.labeledDate = labeledDate;
	}

	public Date getDataCreatedDate() {
		return dataCreatedDate;
	}

	public void setDataCreatedDate(Date dataCreatedDate) {
		this.dataCreatedDate = dataCreatedDate;
	}
}
