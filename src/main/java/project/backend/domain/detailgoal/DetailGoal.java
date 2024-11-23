package project.backend.domain.detailgoal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.goal.Goal;

@Entity
@Getter
@Table(name = "detailgoal")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetailGoal extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(nullable = false)
  private String detailContent;

  @Column(nullable = false)
  private boolean isComplete;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "goal_id")
  private Goal goal;

  @Builder
  private DetailGoal(String detailContent, boolean isComplete) {
    this.detailContent = detailContent;
    this.isComplete = isComplete;
  }
}
