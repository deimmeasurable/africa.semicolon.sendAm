package africa.semicolon.sendAm.controllers;


import africa.semicolon.sendAm.data.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.data.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.data.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.TrackingPackageResponse;
import africa.semicolon.sendAm.data.dtos.responses.UpdateTrackingInfoResponse;
import africa.semicolon.sendAm.services.PackageService;
import africa.semicolon.sendAm.services.PackageServiceImpl;
import org.springframework.web.bind.annotation.*;

    public class PackageController {
    @RestController
    @RequestMapping("/package")
    public class PackageControllers {
        private PackageService services = new PackageServiceImpl();

        @PostMapping("/addPackage")
        public AddPackageResponse addNewPackage(@RequestBody AddPackageRequest myPackage){
            return services.addPackage(myPackage);
        }

        @GetMapping("/{trackingNumber}")
        public TrackingPackageResponse trackPackage(@PathVariable int trackingNumber){
            return services.trackPackage(trackingNumber);
        }

        @PatchMapping("/updateStatus")
        public UpdateTrackingInfoResponse updateTrackingInfo(@RequestBody UpdateTrackingInfoRequest request){
            return  services.updateTrackingInfo(request);
        }
    }
}
