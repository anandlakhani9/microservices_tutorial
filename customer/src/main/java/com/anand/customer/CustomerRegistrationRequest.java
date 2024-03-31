package com.anand.customer;


public record CustomerRegistrationRequest (
    String firstName,
    String lastName,
    String email
){

}
