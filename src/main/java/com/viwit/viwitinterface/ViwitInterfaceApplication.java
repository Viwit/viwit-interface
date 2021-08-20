package com.viwit.viwitinterface;

import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.general_ms.adapter.RouteAdapter;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.wallet_ms.adapter.WalletAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ViwitInterfaceApplication {
    public static void main(String[] args) { SpringApplication.run(ViwitInterfaceApplication.class, args);}
}
