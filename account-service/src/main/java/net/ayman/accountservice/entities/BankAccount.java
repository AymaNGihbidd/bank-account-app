package net.ayman.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.ayman.accountservice.enums.AccountType;
import net.ayman.accountservice.model.Customer;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
