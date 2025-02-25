package com.xworkz.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_table")
//@NamedQuery(name = "getAllData",query = "SELECT user FROM UserProfileEntity user")
@NamedQuery(name = "deleteById", query = "DELETE FROM UserProfileEntity user where user.userId= :id")
@NamedQuery(name = "getProfileById", query = "SELECT user FROM UserProfileEntity user where user.userId= :id")
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    private String email;
    @Column(name = "ph_number")
    private long phNumber;
}
