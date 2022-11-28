package com.example.personabeachpark.guest;

import com.example.personabeachpark.exceptions.guestRelated.FamilyMemberException;
import com.example.personabeachpark.guest.guestFactory.PassFactory;
import com.example.personabeachpark.guest.passes.IPass;
import com.example.personabeachpark.guest.passes.types.PassType;
import com.example.personabeachpark.usersData.User;

import java.util.ArrayList;

public class Guest extends User {
    private PassType passType;
    private IPass pass;
    private ArrayList<Member> familyMembers;
    private PassFactory passFactory = PassFactory.getInstance();

    public Guest(PassType passType){
        familyMembers = new ArrayList<>();
        this.passType = passType;
        pass = passFactory.createPass(passType);
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
        return  super.toString()
                +"{" +
                "Pass= '" + passType + '\'' +
                ", Family Members= " + logFamily() +
                "}" + "]";
    }
}
