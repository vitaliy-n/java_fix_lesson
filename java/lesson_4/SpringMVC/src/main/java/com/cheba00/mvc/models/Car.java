package com.cheba00.mvc.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "owner")
@Entity
@Table(name = "fix_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;



}
