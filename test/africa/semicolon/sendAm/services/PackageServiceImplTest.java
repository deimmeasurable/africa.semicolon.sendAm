package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.RegisterPackageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackageServiceImplTest {

    private PackageService packageService;


    @BeforeEach
    void setUp() {
        packageService = new PackageServiceImpl();
    }

    @Test
    public void afterRegister_repositoryContainsOneElement() {
        //given
        RegisterPackageRequest requestNote = new RegisterPackageRequest();
        requestNote.setId(1);
        requestNote.setQuantityOfPackage(2);
        requestNote.setWhatWasOrder("appleLaptop");
        requestNote.setEmailAddress("gerrald@gmail.com");
        requestNote.setLocation("lagos");
        packageService.register(requestNote);


        assertEquals(1,packageService.getRepository().count());


    }
}