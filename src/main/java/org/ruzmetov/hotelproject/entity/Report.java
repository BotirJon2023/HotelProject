package org.ruzmetov.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "report")
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private UUID reportId;

    @Column(name = "report_start_date")
    private Date startDate;

    @Column(name = "report_end_date")
    private Date endDate;

    @Column(name = "report_revenue_by_rooms")
    private String revenueByRooms;

    @Column(name = "report_revenue_by_event")
    private String revenueByEvent;

    @Column(name = "report_revenue_by_service")
    private String revenueByService;

    @Column(name = "report_occupied_rooms")
    private String occupiedRooms;

    @Column(name = "report_vacant_rooms")
    private String vacantRooms;

    @Column(name = "review_scores_and_feedback")
    private String reviewScoresAndFeedback;

    @ManyToMany
    @JoinColumn(name = "cancellation_rates", referencedColumnName = "reservation_cancelled_info")
    @Column(name = "cancellation_rates")
    private String cancellationRates;

    @ManyToMany
    @JoinColumn (name = "report_access_employee_id", referencedColumnName = "employee_id")
    @Column(name = "report_access_employee_id")
    private UUID accessEmployeeId;

    @ManyToMany
    @JoinColumn (name = "report_access_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "report_access_administrator_id")
    private UUID accessAdministratorId;

    @Column(name = "report_create")
    private Date reportTabCreate;

    @Column(name = "report_update")
    private Date reportTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(reportId, report.reportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId);
    }

    @Override
    public String toString() {
        return "CommonReport{" +
                "reportId=" + reportId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", revenueByRooms='" + revenueByRooms + '\'' +
                ", revenueByEvent='" + revenueByEvent + '\'' +
                ", revenueByService='" + revenueByService + '\'' +
                ", occupiedRooms='" + occupiedRooms + '\'' +
                ", vacantRooms='" + vacantRooms + '\'' +
                ", reviewScoresAndFeedback='" + reviewScoresAndFeedback + '\'' +
                ", cancellationRates='" + cancellationRates + '\'' +
                ", accessEmployeeId=" + accessEmployeeId +
                ", accessAdministratorId=" + accessAdministratorId +
                ", reportTabCreate=" + reportTabCreate +
                ", reportTabUpdate=" + reportTabUpdate +
                '}';
    }
}
