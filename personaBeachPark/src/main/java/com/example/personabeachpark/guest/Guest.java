package com.example.personabeachpark.guest;

import com.example.personabeachpark.exceptions.guestRelated.FamilyMemberException;
import com.example.personabeachpark.guest.passes.IPass;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.user.UserRegistration;

import java.util.ArrayList;

public class Guest extends UserRegistration {
    private PassType passType;
    private IPass pass;
    private ArrayList<Member> familyMembers;

    public Guest(PassType passType){
        familyMembers = new ArrayList<>();
        this.passType = passType;
    }

    public void addMember(Member e) throws FamilyMemberException {
        if(familyMembers.contains(e)){
            throw new FamilyMemberException("Member already in the family!");
        }
        familyMembers.add(e);
    }

    public void removeMember(Member e) throws FamilyMemberException {
        if(!familyMembers.contains(e)){
            throw new FamilyMemberException("This member does not exist!");
        }
        familyMembers.remove(e);
    }

    public ArrayList<Member> getFamilyMembers(){
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

    public String logFamily(){
        String aux = "";
        for(Member e : familyMembers){
            aux += e.toString();
        }
        return aux;
    }

    @Override
    public String toString() {
        return "[" +
                "passType=" + passType +
                ", familyMembers=" + logFamily() +
                ']';
    }
}
