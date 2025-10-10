package com.example.train.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trains")
public class Train {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String trainId;
    private String name;
    private String source;
    private String destination;
    private String departure;
    private String arrival;
    private Integer seats;
    public Train() {}
    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getTrainId(){return trainId;} public void setTrainId(String trainId){this.trainId=trainId;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getSource(){return source;} public void setSource(String source){this.source=source;}
    public String getDestination(){return destination;} public void setDestination(String destination){this.destination=destination;}
    public String getDeparture(){return departure;} public void setDeparture(String departure){this.departure=departure;}
    public String getArrival(){return arrival;} public void setArrival(String arrival){this.arrival=arrival;}
    public Integer getSeats(){return seats;} public void setSeats(Integer seats){this.seats=seats;}
}
