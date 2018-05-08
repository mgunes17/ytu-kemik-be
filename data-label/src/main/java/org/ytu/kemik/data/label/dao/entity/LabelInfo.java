package org.ytu.kemik.data.label.dao.entity;

import java.time.LocalDateTime;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("label_info")
public class LabelInfo {

	@PrimaryKeyColumn(name = "data_uuid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String dataUuid;

	@PrimaryKeyColumn(name = "username", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private String username;

	@PrimaryKeyColumn(name = "project_name", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String projectName;

	@Column("label")
	private String label;

	@Column("labeled_date")
	private LocalDateTime labeledDate;

	public LabelInfo() {
		super();
	}

	public String getDataUuid() {
		return dataUuid;
	}

	public void setDataUuid(String dataUuid) {
		this.dataUuid = dataUuid;
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

	public LocalDateTime getLabeledDate() {
		return labeledDate;
	}

	public void setLabeledDate(LocalDateTime labeledDate) {
		this.labeledDate = labeledDate;
	}
}