package com.conte.hackothumun.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("ORGANISATEUR")
public class Organisateur extends UserApp{
    private String organizationName;
    private String organizationDetails;

}
