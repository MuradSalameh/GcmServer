package main.java.hibernate.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "event_title")
	private String eventTitle;

	@Column(name = "event_description")
	private String eventDescription;

	@Column(name = "event_date")
	private LocalDate date;

	@Column(name = "event_start_time")
	private LocalTime eventStartTime;

	@Column(name = "event_end_time")
	private LocalTime eventEndTime;

	@Column(name = "event_additional_notes")
	private String eventAddidtionalNotes;

	@Column(name = "reoccuring")
	private boolean reoccuring;

	//join table for members
	@ManyToMany(cascade = { CascadeType.ALL})
	@JoinTable(
			name = "events_members", 
			joinColumns = { @JoinColumn(name = "event_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "member_id") }
			)
	List<Member> members = new ArrayList<>();

	public Event() {
		super();
	}



}
