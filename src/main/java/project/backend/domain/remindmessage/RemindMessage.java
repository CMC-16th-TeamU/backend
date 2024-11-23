package project.backend.domain.remindmessage;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.user.User;

@Entity
@Getter
@Table(name = "remindmessage")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RemindMessage extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(nullable = false)
  private String messageContent;

  @Column(nullable = false)
  private Date reminderDate;

  @Column(nullable = false)
  private boolean isSent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Builder
  private RemindMessage(String messageContent, Date reminderDate, boolean isSent) {
    this.messageContent = messageContent;
    this.reminderDate = reminderDate;
    this.isSent = isSent;
  }
}
