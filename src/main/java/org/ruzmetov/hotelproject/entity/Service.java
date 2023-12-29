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
@Table (name = "service")
@Entity

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn (name = "service_id", referencedColumnName = "reservation_service_id")
    @JoinColumn (name = "service_id", referencedColumnName = "customer_service_id")
    @JoinColumn (name = "service_id", referencedColumnName = "room_additional_service")
    @JoinColumn(name = "service_id", referencedColumnName = "payment_service_id")
    @JoinColumn(name = "service_id", referencedColumnName = "feedback_service_id")
    @Column(name = "service_id")
    private UUID serviceId;



    @Column(name = "service_breakfast_booking")
    private boolean isBeakfastBooked;

    @Column(name = "service_breakfast_price")
    private double serviceBreakfastPrice;

    @Column(name = "service_restaurant_booking")
    private boolean isRestaurantBooked;

    @Column(name = "service_restaurant_price")
    private double serviceRestaurantPrice;

    @Column(name = "service_bar_booking")
    private boolean isBarBooked;

    @Column(name = "service_bar_price")
    private double serviceBarPrice;

    @Column(name = "service_swimming_pool_booking")
    private boolean isSwimmingPoolBooked;

    @Column(name = "service_swimming_pool_price")
    private double serviceSwimmingPoolPrice;

    @Column(name = "service_gym_booking")
    private boolean IsGymBooked;

    @Column(name = "service_gym_price")
    private double serviceGymPrice;

    @Column(name = "service_garage_booking")
    private boolean isGarageBooked;

    @Column(name = "service_garage_price")
    private double serviceGaragePrice;

    @Column(name = "service_airport_transfer")
    private boolean isAirportTransferBooked;

    @Column(name = "service_airport_transfer_price")
    private double serviceAirportTransferPrice;

    @ManyToMany
    @JoinColumn(name = "service_total_price", referencedColumnName = "payment_total_amount")
    @Column(name = "service_total_price")
    private double serviceTotalPrice;

    @ManyToMany
    @JoinColumn(name = "service_payment_method", referencedColumnName = "payment_method")
    @Column(name = "service_payment_method")
    private String servicePaymentMethod;

    @OneToOne
    @JoinColumn(name = "service_payment_id", referencedColumnName = "payment_id")
    @Column(name = "service_payment_id")
    private UUID servicePaymentId;

    @ManyToMany
    @JoinColumn (name = "service_employee_id", referencedColumnName = "employee_id")
    @Column(name = "service_employee_id")
    private UUID serviceEmployeeId;

    @ManyToMany
    @JoinColumn (name = "service_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "service_administrator_id")
    private UUID serviseAdministratorId;

    @Column(name = "service_create")
    private Date serviceTabCreate;

    @Column(name = "service_update")
    private Date serviceTabUpdate;


    public Service(boolean isBeakfastBooked, double serviceBreakfastPrice, boolean isRestaurantBooked, double serviceRestaurantPrice, boolean isBarBooked, double serviceBarPrice, boolean isSwimmingPoolBooked, double serviceSwimmingPoolPrice, boolean isGymBooked, double serviceGymPrice, boolean isGarageBooked, double serviceGaragePrice, boolean isAirportTransferBooked, double serviceAirportTransferPrice, double serviceTotalPrice, String servicePaymentMethod, UUID servicePaymentId, UUID serviceEmployeeId, UUID serviseAdministratorId, Date serviceTabCreate, Date serviceTabUpdate) {
        this.serviceId = UUID.randomUUID();
        this.isBeakfastBooked = isBeakfastBooked;
        this.serviceBreakfastPrice = serviceBreakfastPrice;
        this.isRestaurantBooked = isRestaurantBooked;
        this.serviceRestaurantPrice = serviceRestaurantPrice;
        this.isBarBooked = isBarBooked;
        this.serviceBarPrice = serviceBarPrice;
        this.isSwimmingPoolBooked = isSwimmingPoolBooked;
        this.serviceSwimmingPoolPrice = serviceSwimmingPoolPrice;
        this.IsGymBooked = isGymBooked;
        this.serviceGymPrice = serviceGymPrice;
        this.isGarageBooked = isGarageBooked;
        this.serviceGaragePrice = serviceGaragePrice;
        this.isAirportTransferBooked = isAirportTransferBooked;
        this.serviceAirportTransferPrice = serviceAirportTransferPrice;
        this.serviceTotalPrice = serviceTotalPrice;
        this.servicePaymentMethod = servicePaymentMethod;
        this.servicePaymentId = servicePaymentId;
        this.serviceEmployeeId = serviceEmployeeId;
        this.serviseAdministratorId = serviseAdministratorId;
        this.serviceTabCreate = serviceTabCreate;
        this.serviceTabUpdate = serviceTabUpdate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service that = (Service) o;
        return isBeakfastBooked == that.isBeakfastBooked && Double.compare(serviceBreakfastPrice, that.serviceBreakfastPrice) == 0 && isRestaurantBooked == that.isRestaurantBooked && Double.compare(serviceRestaurantPrice, that.serviceRestaurantPrice) == 0 && isBarBooked == that.isBarBooked && Double.compare(serviceBarPrice, that.serviceBarPrice) == 0 && isSwimmingPoolBooked == that.isSwimmingPoolBooked && Double.compare(serviceSwimmingPoolPrice, that.serviceSwimmingPoolPrice) == 0 && IsGymBooked == that.IsGymBooked && Double.compare(serviceGymPrice, that.serviceGymPrice) == 0 && isGarageBooked == that.isGarageBooked && Double.compare(serviceGaragePrice, that.serviceGaragePrice) == 0 && isAirportTransferBooked == that.isAirportTransferBooked && Double.compare(serviceAirportTransferPrice, that.serviceAirportTransferPrice) == 0 && Double.compare(serviceTotalPrice, that.serviceTotalPrice) == 0 && Objects.equals(serviceId, that.serviceId) && Objects.equals(servicePaymentMethod, that.servicePaymentMethod) && Objects.equals(servicePaymentId, that.servicePaymentId) && Objects.equals(serviceEmployeeId, that.serviceEmployeeId) && Objects.equals(serviseAdministratorId, that.serviseAdministratorId) && Objects.equals(serviceTabCreate, that.serviceTabCreate) && Objects.equals(serviceTabUpdate, that.serviceTabUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, isBeakfastBooked, serviceBreakfastPrice, isRestaurantBooked, serviceRestaurantPrice, isBarBooked, serviceBarPrice, isSwimmingPoolBooked, serviceSwimmingPoolPrice, IsGymBooked, serviceGymPrice, isGarageBooked, serviceGaragePrice, isAirportTransferBooked, serviceAirportTransferPrice, serviceTotalPrice, servicePaymentMethod, servicePaymentId, serviceEmployeeId, serviseAdministratorId, serviceTabCreate, serviceTabUpdate);
    }

    @Override
    public String toString() {
        return "CommonService{" +
                "serviceId=" + serviceId +
                ", isBeakfastBooked=" + isBeakfastBooked +
                ", serviceBreakfastPrice=" + serviceBreakfastPrice +
                ", isRestaurantBooked=" + isRestaurantBooked +
                ", serviceRestaurantPrice=" + serviceRestaurantPrice +
                ", isBarBooked=" + isBarBooked +
                ", serviceBarPrice=" + serviceBarPrice +
                ", isSwimmingPoolBooked=" + isSwimmingPoolBooked +
                ", serviceSwimmingPoolPrice=" + serviceSwimmingPoolPrice +
                ", IsGymBooked=" + IsGymBooked +
                ", serviceGymPrice=" + serviceGymPrice +
                ", isGarageBooked=" + isGarageBooked +
                ", serviceGaragePrice=" + serviceGaragePrice +
                ", isAirportTransferBooked=" + isAirportTransferBooked +
                ", serviceAirportTransferPrice=" + serviceAirportTransferPrice +
                ", serviceTotalPrice=" + serviceTotalPrice +
                ", servicePaymentMethod='" + servicePaymentMethod + '\'' +
                ", servicePaymentId=" + servicePaymentId +
                ", serviceEmployeeId=" + serviceEmployeeId +
                ", serviseAdministratorId=" + serviseAdministratorId +
                ", serviceTabCreate=" + serviceTabCreate +
                ", serviceTabUpdate=" + serviceTabUpdate +
                '}';
    }
}
