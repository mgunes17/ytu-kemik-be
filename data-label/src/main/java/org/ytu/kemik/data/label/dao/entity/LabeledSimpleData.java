package org.ytu.kemik.data.label.dao.entity;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("labeled_simple_data")
public class LabeledSimpleData {

	@PrimaryKey
	@Column("id")
	private String id;

	@Column("id_from_source")
	private String idFromSource;

	@Column("source_type")
	private String sourceType;

	@Column("content")
	private String content;

	@Column("project_name")
	private String projectName;

	@Column("label")
	private String label;

	@Column("is_certaing")
	private boolean isCertain;

	@Column("labeled_date")
	private LocalDateTime labeledDate;

	@Column("data_created_date")
	private LocalDateTime dataCreatedDate;

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

	public LocalDateTime getLabeledDate() {
		return labeledDate;
	}

	public void setLabeledDate(LocalDateTime labeledDate) {
		this.labeledDate = labeledDate;
	}

	public LocalDateTime getDataCreatedDate() {
		return dataCreatedDate;
	}

	public void setDataCreatedDate(LocalDateTime dataCreatedDate) {
		this.dataCreatedDate = dataCreatedDate;
	}

}
