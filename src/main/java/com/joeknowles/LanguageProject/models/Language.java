package com.joeknowles.LanguageProject.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8469587086500567642L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 200)
	private String name;
	@Size(min = 2, max = 20)
	private String creator;
	@Size(min = 1)
	private String version;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated;
	
	public Language() {}
	public Language(String n, String c, String v) {
		name = n;
		creator = c;
		version = v;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getCreator() { return creator; }
	public void setCreator(String creator) { this.creator = creator; }
	public String getVersion() { return version; }
	public void setVersion(String version) { this.version = version; }
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }

	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
	
	@Override
	public String toString() {
		return String.format("%s %s %s", name, creator, version);
	}
	
	
	
	
	
	
	
	
	
	
}
