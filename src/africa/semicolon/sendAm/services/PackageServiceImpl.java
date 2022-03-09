package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.data.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.data.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.TrackingInfo;
import africa.semicolon.sendAm.data.dtos.responses.TrackingPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.UpdateTrackingInfoResponse;
import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.respositories.PackageRepository;
import africa.semicolon.sendAm.data.respositories.PackageRepositoryImpl;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PackageServiceImpl implements PackageService{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    private int availableId;

    @Override
    public AddPackageResponse addPackage(AddPackageRequest myPackage) {
        Package packageToBeAdded = new Package();
        PackageDescription description = new PackageDescription();
        description.setName(myPackage.getName());
        description.setWeightInGrammes(myPackage.getWeightInGrammes());



        packageToBeAdded.setDescription(description);

        Status status = new Status();
        status.setStatus("Packed");
        packageToBeAdded.getStatusList().add(status);
        System.out.println(packageToBeAdded.getStatusList());

        Package savedPackage = packageRepository.save(packageToBeAdded);

        AddPackageResponse packageResponse = new AddPackageResponse();
        packageResponse.setId(savedPackage.getId());
        packageResponse.setName(savedPackage.getDescription().getName());
        packageResponse.setWeightInGrammes(savedPackage.getDescription().getWeightInGrammes());
//        packageResponse.setStatus(savedPackage.getDescription());
        return packageResponse;
    }




    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }



    @Override
    public UpdateTrackingInfoResponse updateTrackingInfo(UpdateTrackingInfoRequest TrackingInfoRequest) {
        //get package from repo
        Package foundPackage = packageRepository.findById(TrackingInfoRequest.getTrackingNumber());

        Status status = new Status();

//        create new status
        status.setStatus(TrackingInfoRequest.getTrackingInfo());

//        add new status
//        save package
        foundPackage.getStatusList().add(status);
        packageRepository.save(foundPackage);
        return null;
    }

    @Override
    public TrackingPackageResponse trackPackage(int trackingNumber) {
// find package
        Package savedPackage = packageRepository.findById(trackingNumber);
        System.out.println(savedPackage);

//        get list of status
        List<Status> statusList = savedPackage.getStatusList();
        System.out.println(statusList);
//        create response
        TrackingPackageResponse response = new TrackingPackageResponse();
//        add list of status
        for (Status status : statusList) {
            TrackingInfo info = new TrackingInfo();
            info.setInformation(status.getStatus());
            info.getDateTime(DateTimeFormatter.ofPattern("E yyyy-MM-dd a").format(status.getDateTime()));
            response.getTrackingInfo().add(info);
        }

        return response;
    }


}

