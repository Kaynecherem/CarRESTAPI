package hr.algebra.springproject.bootstrap;

import hr.algebra.springproject.model.CarDTO;
import hr.algebra.springproject.service.CarSerivce;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CarSerivce carSerivce;

    @Override
    public void run(String... args) {
        System.out.println("Cars about to load...");

        final CarDTO bmw1 = CarDTO.builder().brand("BMW").model("320d").color("Portimao Blue").powerInHp(190).build();
        final CarDTO bmw2 = CarDTO.builder().brand("BMW").model("M3").color("Black").powerInHp(473).build();
        final CarDTO bmw3 = CarDTO.builder().brand("BMW").model("M5 Competition").color("Blue").powerInHp(617).build();
        final CarDTO bmw4 = CarDTO.builder().brand("BMW").model("X5 M").color("White").powerInHp(600).build();
        final CarDTO bmw5 = CarDTO.builder().brand("BMW").model("i8").color("Silver").powerInHp(369).build();

        final CarDTO audi1 = CarDTO.builder().brand("Audi").model("A6 3.0 BiTDI").color("Silver").powerInHp(313).build();
        final CarDTO audi2 = CarDTO.builder().brand("Audi").model("R8 V10 Plus").color("Red").powerInHp(610).build();
        final CarDTO audi3 = CarDTO.builder().brand("Audi").model("RS6 Avant").color("Black").powerInHp(591).build();
        final CarDTO audi4 = CarDTO.builder().brand("Audi").model("S8").color("Grey").powerInHp(563).build();

        final CarDTO porsche1 = CarDTO.builder().brand("Porsche").model("Carrera S").color("Blue").powerInHp(443).build();
        final CarDTO porsche2 = CarDTO.builder().brand("Porsche").model("Macan Turbo").color("White").powerInHp(434).build();
        final CarDTO porsche3 = CarDTO.builder().brand("Porsche").model("Panamera GTS").color("Green").powerInHp(453).build();

        final CarDTO lamborghini1 = CarDTO.builder().brand("Lamborghini").model("Aventador SVJ").color("Green").powerInHp(770).build();
        final CarDTO lamborghini2 = CarDTO.builder().brand("Lamborghini").model("Huracán EVO").color("Yellow").powerInHp(631).build();

        final CarDTO lexus1 = CarDTO.builder().brand("Lexus").model("LC 500").color("Red").powerInHp(471).build();
        final CarDTO lexus2 = CarDTO.builder().brand("Lexus").model("GS F").color("Blue").powerInHp(467).build();

        final CarDTO bugatti1 = CarDTO.builder().brand("Bugatti").model("Chiron").color("Blue").powerInHp(1479).build();
        final CarDTO bugatti2 = CarDTO.builder().brand("Bugatti").model("Veyron Super Sport").color("Black").powerInHp(1184).build();

        final CarDTO koenigsegg1 = CarDTO.builder().brand("Koenigsegg").model("Jesko").color("Silver").powerInHp(1280).build();
        final CarDTO koenigsegg2 = CarDTO.builder().brand("Koenigsegg").model("Regera").color("Red").powerInHp(1500).build();

        carSerivce.save(bmw1);
        carSerivce.save(bmw2);
        carSerivce.save(bmw3);
        carSerivce.save(bmw4);
        carSerivce.save(bmw5);
        carSerivce.save(audi1);
        carSerivce.save(audi2);
        carSerivce.save(audi3);
        carSerivce.save(audi4);
        carSerivce.save(porsche1);
        carSerivce.save(porsche2);
        carSerivce.save(porsche3);
        carSerivce.save(lamborghini1);
        carSerivce.save(lamborghini2);
        carSerivce.save(lexus1);
        carSerivce.save(lexus2);
        carSerivce.save(bugatti1);
        carSerivce.save(bugatti2);
        carSerivce.save(koenigsegg1);
        carSerivce.save(koenigsegg2);

        System.out.println("All cars successfully loaded!");
    }
}
