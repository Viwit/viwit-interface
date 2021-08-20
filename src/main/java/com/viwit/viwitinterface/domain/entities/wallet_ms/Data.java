package com.viwit.viwitinterface.domain.entities.wallet_ms;

import lombok.Builder;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;

@Getter
@Builder(toBuilder = true)
public class Data {
    private BigInteger Id;
    private BigInteger Id_method_payment;
    private BigInteger Mount;
    private String Status;
    private BigInteger Type;
    private BigInteger Wallet_id;
    private String Date;
    private String Typename;
}
