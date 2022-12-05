package com.example.personabeachpark.guest;

import com.example.personabeachpark.booking.areas.BookedArea;
import com.example.personabeachpark.exceptions.guestRelated.FamilyMemberException;
import com.example.personabeachpark.food.order.OrderPad;
import com.example.personabeachpark.guest.guestFactory.PassFactory;
import com.example.personabeachpark.guest.passes.IPass;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.User;

import java.util.HashSet;
import java.util.Set;

public class Guest extends User {
    private PassType passType;
    private IPass pass;
    private Set<Member> familyMembers;
    private PassFactory passFactory = PassFactory.getInstance();
    private Set<BookedArea> booked;
    private OrderPad orderPad;

    public Guest(PassType passType){
        familyMembers = new HashSet<>();
        this.passType = passType;
        pass = passFactory.createPass(passType);
        booked = new HashSet<>();
    }

    public void addMember(Member e) throws FamilyMemberException {
        if(familyMembers.contains(e)){
            throw new FamilyMemberException("Member already in the family!");
        }
        familyMembers.add(e);
    }

    public Member getMember(String firstName, String lastName){
        for(Member x : familyMembers){
            if(x.getFullName().equals(firstName + lastName)){
                return x;
            }
        }
        return null;
    }
    public void addMember(String firstName, String lastName){
        Member x = getMember(firstName, lastName);
        if(x != null){
            return; // throw
        }
        familyMembers.add(new Member(firstName, lastName));
    }

    public void removeMember(Member e) throws FamilyMemberException {
        if(!familyMembers.contains(e)){
            throw new FamilyMemberException("This member does not exist!");
        }
        familyMembers.remove(e);
    }

    public void removeMember(String firstName, String lastName){
        Member x = getMember(firstName, lastName);
        if(x == null){
            return; // throw
        }
        familyMembers.remove(x);
    }
    public boolean isBooked(BookedArea bookedArea){
        for(BookedArea x : booked){
            if(x.equals(bookedArea)){
                return true;
            }
        }
        return false;
    }
    public void addBooking(BookedArea bookedArea){
        booked.add(bookedArea);
    }

    public void removeBooking(BookedArea bookedArea){
        booked.remove(bookedArea);
    }
    public Set<Member> getFamilyMembers(){
        return familyMembers;
    }

    public PassType getPassType() {
        return passType;
    }

    public void setPassType(PassType passType) {
        this.passType = passType;
    }

    public IPass getPass() {
        return pass;
    }

    public void setPass(IPass pass) {
        this.pass = pass;
    }

    public Set<BookedArea> getBooks(){
        return booked;
    }

    public String logFamily(){
        String aux = "";
        for(Member e : familyMembers){
            aux += e.toString();
        }
        return aux;
    }

    public int getPassCode(){
        return passType.getCode();
    }

    public OrderPad getOrderPad() {
        return orderPad;
    }

    public void setOrderPad(OrderPad orderPad) {
        this.orderPad = orderPad;
    }

    @Override
    public String toString() {
        return  super.toString()
                +"{" +
                "Pass= '" + passType + '\'' +
                ", Family Members= " + logFamily() +
                "}" + "]";
    }
}
