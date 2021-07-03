package com.gustavobussolotti.cities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gustavobussolotti.cities.utils.PointType;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@Getter
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State uf;

    private int ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;
}

