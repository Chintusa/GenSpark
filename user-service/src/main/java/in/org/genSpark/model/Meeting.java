package in.org.genSpark.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meetings")
@Getter
@Setter
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proposer_id", nullable = false)
	private User proposer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attendee_id", nullable = false)
	private User attendee;

	@Column(nullable = false)
	private LocalDateTime meetingTime;

	@Column(nullable = false)
	private boolean confirmed = false;

	private String meetingLink; // Manually pasted by users

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "reminder_sent")
	private boolean reminderSent = false;
}