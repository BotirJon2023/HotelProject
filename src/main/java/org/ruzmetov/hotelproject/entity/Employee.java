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
@Table (name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn (name = "employee_id", referencedColumnName = "reservation_employee_id")
    @JoinColumn (name = "employee_id", referencedColumnName = "room_employee_id")
    @JoinColumn (name = "employee_id", referencedColumnName = "payment_employee_id")
    @JoinColumn (name = "employee_id", referencedColumnName = "service_employee_id")
    @JoinColumn (name = "employee_id", referencedColumnName = "event_employee_id")
    @JoinColumn (name = "employee_id", referencedColumnName = "report_access_employee_id")
    @Column(name = "employee_id")
    private UUID employeeId;

    @Column(name = "employee_first_name")
    private String firstName;

    @Column(name = "employee_last_name")
    private String lastName;

    @Column(name = "employee_departament")
    private String departament;

    @Column(name = "employee_position")
    private String employeePosition;

    @Column(name = "employee_shift_start_time")
    private Date shiftStartTime;

    @Column(name = "employee_shift_start_time")
    private Date shiftEndTime;

    @ManyToMany
    @JoinColumn(name = "employee_feedback", referencedColumnName = "feedback_id")
    @Column(name = "employee_feedback")
    private String feedback;

    @Column(name = "employee_complains")
    private String complains;

    @Column(name = "employee_create")
    private Date employeeTabCreate;

    @Column(name = "employee_update")
    private Date employeeTabUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "CommenEmployee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departament='" + departament + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", shiftStartTime=" + shiftStartTime +
                ", shiftEndTime=" + shiftEndTime +
                ", feedback='" + feedback + '\'' +
                ", complains='" + complains + '\'' +
                ", employeeTabCreate=" + employeeTabCreate +
                ", employeeTabUpdate=" + employeeTabUpdate +
                '}';
    }
}
