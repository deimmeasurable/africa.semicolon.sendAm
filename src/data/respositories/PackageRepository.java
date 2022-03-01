package data.respositories;

import data.models.Package;

import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);
    Package findById(int id);
    void delete(Package aPackage);
    void delete(int id);
    List<Package> findAll();
    int count();
}