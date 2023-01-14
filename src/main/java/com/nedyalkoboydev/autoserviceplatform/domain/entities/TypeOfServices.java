package com.nedyalkoboydev.autoserviceplatform.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "type_of_services")
public class TypeOfServices extends BaseEntity{
    private String name;
}
