package com.levdoc.medhapp.repository;

import com.levdoc.medhapp.model.notification.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository
        extends GenericRepository<Patient>{
}
