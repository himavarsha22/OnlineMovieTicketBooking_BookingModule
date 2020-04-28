package com.cg.sprint.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class ReservedSeats 
{
    @Id
    @Column(name="rs_id")
    int rsId;
    String seat;
    @OneToOne
    @JoinColumn(name="class_id")
    Class seatclass;
    public ReservedSeats() {}
	public ReservedSeats(int rsId, String seat, Class seatclass) 
	{
		this.rsId = rsId;		this.seat = seat;		this.seatclass = seatclass;
	}
	public int getRsId() {
		return rsId;
	}
	public void setRsId(int rsId) {
		this.rsId = rsId;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Class getSeatclass() {
		return seatclass;
	}
	public void setSeatclass(Class seatclass) {
		this.seatclass = seatclass;
	}
}
