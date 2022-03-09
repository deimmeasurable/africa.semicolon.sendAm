package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.data.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.data.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.TrackingPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.UpdateTrackingInfoResponse;
import africa.semicolon.sendAm.data.respositories.PackageRepository;

public interface PackageService {

    PackageRepository getRepository();

    AddPackageResponse addPackage(AddPackageRequest myPackage);

  UpdateTrackingInfoResponse updateTrackingInfo(UpdateTrackingInfoRequest TrackingInfoRequest);

  TrackingPackageResponse trackPackage(int i);

  ;
}
